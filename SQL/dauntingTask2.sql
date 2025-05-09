/*
Комплексный анализ эффективности производства

Запрос, который анализирует эффективность каждой мастерской, учитывая:
- Производительность каждого ремесленника (соотношение созданных продуктов к затраченному времени)
- Эффективность использования ресурсов (соотношение потребляемых ресурсов к производимым товарам)
- Качество производимых товаров (средневзвешенное по ценности)
- Время простоя мастерской
- Влияние навыков ремесленников на качество товаров
*/
WITH dwarf_stats AS (
    SELECT
        wc.workshop_id,
        count(*) AS num_craftsdwarves,
        avg(ds.level) AS avg_skill
    FROM
        workshop_craftsdwarves wc
    LEFT JOIN
        dwarf_skills ds ON ds.dwarf_id = wc.dwarf_id
    GROUP BY
        wc.workshop_id
), 
product_stats AS (
    SELECT
        wp.workshop_id,
        sum(wp.quantity) AS total_quantity_produced,
        sum(p.value) AS total_production_value,
        count(distinct wp.production_date) AS productive_days_count, 
        max(wp.production_date) - min(wp.production_date) AS total_days_count,
        avg(p.quality) AS avg_quality
    FROM
        workshop_products wp
    JOIN 
        products p ON p.product_id = wp.product_id
    GROUP BY 
        wp.workshop_id
),
material_stats AS (
    SELECT
        wm.workshop_id,
        sum(wm.quantity) AS total_materials_usage
    FROM 
        workshop_materials wm
    WHERE 
        wm.is_input = 1
    GROUP BY 
        wm.workshop_id
)
SELECT
    w.workshop_id,
    w.name AS workshop_name,
    w.type AS workshop_type,
    COALESCE(ds.num_craftsdwarves, 0) AS num_craftsdwarves,
    COALESCE(ps.total_quantity_produced, 0) AS total_quantity_produced,
    COALESCE(ps.total_production_value, 0) AS total_production_value,
    ROUND(ps.total_quantity_produced::DECIMAL / NULLIF(ps.total_days_count, 0) * 100, 2) AS daily_production_rate,
    ROUND(ps.total_production_value::DECIMAL / NULLIF(ms.total_materials_usage, 0), 2) AS value_per_material_unit, 
    ROUND((ps.productive_days_count::DECIMAL / NULLIF(ps.total_days_count, 0) * 100), 2) AS workshop_utilization_percent,
    ROUND(ms.total_materials_usage::DECIMAL / NULLIF(ps.total_quantity_produced, 0), 2) AS material_conversion_ratio,
    COALESCE(ds.avg_skill, 0) AS average_craftsdwarf_skill,
    CORR(ds.avg_skill, ps.avg_quality) AS skill_quality_correlation,
     JSON_OBJECT(
        'craftsdwarf_ids', (
            SELECT JSON_ARRAYAGG(wc.dwarf_id)
            FROM workshop_craftsdwarves wc
            WHERE wc.workshop_id = w.workshop_id
        ),
        'product_ids', (
            SELECT JSON_ARRAYAGG(wp.product_id)
            FROM workshop_produtcs wp
            WHERE wp.workshop_id = w.workshop_id
        ),
        'material_ids', (
            SELECT JSON_ARRAYAGG(wm.material_id)
            FROM workshop_materials wm
            WHERE wm.workshop_id = w.workshop_id
        ),
        'project_ids', (
            SELECT JSON_ARRAYAGG(p.project_id)
            FROM projects p
            WHERE p.workshop_id = w.workshop_id
        )
    ) AS related_entities
FROM
    workshops w
LEFT JOIN
    product_stats ps ON ps.workshop_id = w.workshop_id
LEFT JOIN 
    dwarf_stats ds ON ds.workshop_id = w.workshop_id
LEFT JOIN
    material_stats ms ON ms.workshop_id = w.workshop_id
ORDER BY 
    daily_production_rate DESC;
