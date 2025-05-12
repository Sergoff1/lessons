/*
Комплексный анализ торговых отношений и их влияния на крепость

Запрос анализирующий торговые отношения со всеми цивилизациями, оценивая:
- Баланс торговли с каждой цивилизацией за все время
- Влияние товаров каждого типа на экономику крепости
- Корреляцию между торговлей и дипломатическими отношениями
- Эволюцию торговых отношений во времени
- Зависимость крепости от определенных импортируемых товаров
- Эффективность экспорта продукции мастерских 
*/
WITH civilization_trade_info AS (
    SELECT
        c.civilization_type,
        count(DISTINCT c.caravan_id) AS total_caravans,
        sum(tt.value) AS total_trade_value,
        sum(CASE cg.type = 'Import' THEN cg.value ELSE 0 END) AS import_trade_value,
        sum(CASE cg.type = 'Export' THEN cg.value ELSE 0 END) AS export_trade_value
    FROM
        caravans c
    JOIN
        trade_transactions tt ON tt.caravan_id = c.caravan_id
    JOIN 
        caravan_goods cg ON cg.caravan_id = c.caravan_id
    GROUP BY
        c.civilization_type
), resource_dependency_info AS (
    SELECT
        cg.material_type,
        sum(cg.quantity) AS total_imported,
        count(DISTINCT c.civilization_type) AS import_diversity,
        (
            (1 / NULLIF(count(DISTINCT c.civilization_type), 0)
            * sum(cg.quantity)
            * count(DISTINCT cg.goods_id))
        ) AS dependency_score
    FROM
        caravan_goods cg
    JOIN 
        caravans c ON c.caravan_id = cg.caravan_id 
    WHERE 
        cg.type = 'Import'
    GROUP BY 
        cg.material_type
), diplomatic_info AS (
    SELECT
        de.civilization_type,
        CORR(de.relationship_change, tt.value) AS diplomatic_correlation
    FROM 
        diplomatic_events de
    JOIN 
        trade_transactions tt ON tt.caravan_id = de.caravan_id
    GROUP BY 
        de.civilization_type
), export_info AS (
    SELECT
        w.type AS workshop_type,
        p.type AS product_type,
        count(DISTINCT p.product_id) AS products_created,
        count(DISTINCT cg.original_product_id) AS products_exported,
        avg(CASE cg.goods_id IS NOT NULL THEN cg.value / p.value END) AS avg_markup
    FROM
        workshops w
    JOIN 
        products p ON p.workshop_id = w.workshop_id
    LEFT JOIN
        caravan_goods cg ON cg.original_product_id = p.product_id AND cg.type = 'Export'
    GROUP BY
        w.type, p.type
), trade_growth_info AS (
    SELECT
        EXTRACT (YEAR from tt.date) AS trade_year,
        EXTRACT (QUARTER from tt.date) AS trade_quarter,
        sum(tt.value) AS quarterly_value,
        sum(CASE tt.balance_direction = 'Import' THEN tt.value ELSE 0 END) AS import_value,
        sum(CASE tt.balance_direction = 'Export' THEN tt.value ELSE 0 END) AS export_value,
        count(DISTINCT c.civilization_type) AS trade_diversity
    FROM 
        trade_transactions tt
    JOIN
        caravans c ON c.caravan_id = tt.caravan_id
    GROUP BY
        EXTRACT (YEAR from tt.date),
        EXTRACT (QUARTER from tt.date)
)
SELECT
    count(civilization_type) AS total_trading_partners,
    sum(total_trade_value) AS all_time_trade_value,
    sum(export_trade_value) - sum(import_trade_value) AS all_time_trade_balance,
    JSON_OBJECT(
        'civilization_trade_data', (
            SELECT 
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'civilization_type', cti.civilization_type,
                        'total_caravans', cti.total_caravans,
                        'total_trade_value', cti.total_trade_value,
                        'trade_balance', cti.export_trade_value - cti.import_trade_value,
                        'trade_relationship', CASE
                            WHEN (cti.export_trade_value - cti.import_trade_value) > 0 THEN 'Favorable'
                            WHEN (cti.export_trade_value - cti.import_trade_value) < 0 THEN 'Unfavorable'
                            ELSE 'Neutral'
                        END,
                        'diplomatic_correlation', di.diplomatic_correlation,
                        'caravan_ids', (
                            SELECT JSON_ARRAYAGG(c.caravan_id)
                            FROM caravans c
                            WHERE c.civilization_type = cti.civilization_type
                        )
                    )
                )
            FROM 
                civilization_trade_info cti
            LEFT JOIN 
                diplomatic_info di ON di.civilization_type = cti.civilization_type
        )
    ) AS civilization_data,
    JSON_OBJECT(
        'resource_dependency', (
            SELECT 
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'material_type', rdi.material_type,
                        'dependency_score', rdi.dependency_score,
                        'total_imported', rdi.total_imported,
                        'import_diversity', rdi.import_diversity,
                        'resource_ids', (
                            SELECT JSON_ARRAYAGG(r.resource_id)
                            FROM resources r
                            WHERE r.type = rdi.material_type
                        )
                    )
                )
            FROM
                resource_dependency_info rdi
            ORDER BY
                rdi.dependency_score DESC
            LIMIT 3
        )
    ) AS 'critical_import_dependencies',
    JSON_OBJECT(
        'export_effectiveness', (
            SELECT 
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'workshop_type', ei.workshop_type,
                        'product_type', ei.product_type,
                        'export_ratio', ROUND(ei.products_exported / NULLIF(ei.products_created, 0) * 100, 2),
                        'avg_markup', ei.avg_markup,
                        'workshop_ids', (
                             SELECT JSON_ARRAYAGG(w.workshop_id)
                             FROM workshops w
                             WHERE w.type = ei.workshop_type
                        )
                    )
                )
            FROM
                export_info ei
        )
    ) AS 'export_effectiveness',
    JSON_OBJECT(
        'trade_growth', (
            SELECT 
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'year', tgi.trade_year,
                        'quarter', tgi.trade_quarter,
                        'quarterly_value', tgi.quarterly_value,
                        'quarterly_balance', tgi.export_value - tgi.import_value,
                        'trade_diversity', tgi.trade_diversity
                    )
                )
            FROM
                trade_growth_info tgi
        )
    ) AS 'trade_timeline'
FROM
    civilization_trade_info;
