/*
Многофакторный анализ угроз и безопасности крепости

Запрос, который комплексно анализирует безопасность крепости, учитывая:
- Историю всех атак существ и их исходов
- Эффективность защитных сооружений
- Соотношение между типами существ и результативностью обороны
- Оценку уязвимых зон на основе архитектуры крепости
- Корреляцию между сезонными факторами и частотой нападений
- Готовность военных отрядов и их расположение
- Эволюцию защитных способностей крепости со временем
*/

/*
DISCLAIMER
Часть используемых полей может быть выдуманной, так как в схеме БД есть 
только названия некоторых необходимых для этого запроса таблиц, и нет описания их полей.
*/
WITH current_threats AS (
    SELECT
        c.type AS creature_type,
        max(c.threat_level) AS threat_level,
        max(cs.date) AS last_sighting_date,
        min(ct.distance_to_fortress) AS territory_proximity
    FROM
        creatures c
    JOIN
        creature_territories ct ON ct.creature_id = c.creature_id
    LEFT JOIN
        creature_sightings cs ON cs.creature_id = c.creature_id
    WHERE
        c.active = 1
    GROUP BY
        c.type
), vulnerability_analysis AS (
    SELECT
        l.zone_id,
        l.name AS zone_name,
        l.fortification_level,
        l.wall_integrity,
        l.trap_density,
        l.choke_points,
        l.access_points,
        count(DISTINCT CASE WHEN ca.outcome = 'Defeat' THEN ca.attack_id END) AS historical_breaches,
        min(mcz.response_time) AS military_response_time,
        count(DISTINCT mcz.squad_id) AS squads_count,
        count(DISTINCT ds.structure_id) AS defense_structure_count
    FROM
        locations l
    LEFT JOIN 
        creature_attacks ca ON ca.location_id = l.location_id
    LEFT JOIN
        military_coverage_zones mcz ON mcz.zone_id = l.zone_id
    LEFT JOIN
        defense_structures ds ON ds.location_id = l.location_id
    GROUP BY
        l.zone_id, l.name, l.fortification_level, l.wall_integrity, l.trap_density, l.choke_points, l.access_points
), defense_effectiveness AS (
    SELECT
        ds.type AS defense_type,
        ROUND(count(DISTINCT CASE ca.outcome = 'Victory' THEN 1 END)::DECIMAL / 
              NULLIF(count(DISTINCT ca.attack_id), 0) * 100, 
        2) AS effectiveness_rate,
        avg(ca.enemy_casualties) AS avg_enemy_casualties
    FROM
        defense_structures ds
    LEFT JOIN 
        creature_attacks ca ON ca.defense_structures_used = ds.structure_id
    GROUP BY
        ds.type
), military_readiness_assessment AS (
    SELECT
        ms.squad_id,
        ms.name AS squad_name,
        count(DISTINCT CASE sm.exit_date IS NULL THEN sm.dwarf_id END) AS active_members,
        avg(ds.level) AS avg_combat_skill,
        ROUND(count(DISTINCT CASE sb.outcome = 'Victory' THEN sb.report_id END)::DECIMAL /
              NULLIF(count(DISTINCT sb.report_id), 0),
            2) AS combat_effectiveness,
        count(DISTINCT CASE da.assignment_id IS NOT NULL THEN da.dwarf_id END) AS dwarves_on_mission_count
    FROM
        military_squads ms
    JOIN 
        squad_members sm ON sm.squad_id = ms.squad_id
    JOIN 
        dwarf_skills ds ON ds.dwarf_id = sm.dwarf_id
    JOIN 
        skills s ON s.skill_id = ds.skill_id
    LEFT JOIN
        squad_battles sb ON sb.squad_id = ms.squad_id
    LEFT JOIN
        dwarf_assignments da ON da.dwarf_id = sm.dwarf_id AND da.end_date IS NULL
    WHERE
        s.category IN ('Combat', 'Military')
    GROUP BY
        ms.squad_id, ms.name
), security_evolution AS (
    SELECT
        EXTRACT(YEAR FROM c.date) AS year,
        count(*) AS total_attacks,
        sum(casualties) AS casualties,
        ROUND(count(CASE ca.outcome = 'Victory' THEN 1 END)::DECIMAL / NULLIF(count(*), 0) * 100, 2) AS defense_success_rate
    FROM
        creature_attacks ca
    GROUP BY
        EXTRACT(YEAR FROM ca.date)
)
SELECT
    (SELECT count(*) FROM creature_attacks) AS total_recorded_attacks,
    (SELECT count(DISTINCT creature_id) FROM creature_attacks) AS unique_attackers,
    (SELECT 
        ROUND(count(case outcome = 'Victory' THEN 1 END)::DECIMAL / NULLIF(count(*), 0) * 100, 2) 
     FROM creature_attacks) AS overall_defense_success_rate,
    JSON_OBJECT(
        'threat_assessment', JSON_OBJECT(
            'current_threat_level', (SELECT 
                                        CASE
                                            WHEN avg(threat_level) > 10 THEN 'High' 
                                            WHEN avg(threat_level) BETWEEN 5 AND 10 THE 'Moderate'
                                            ELSE 'Low'
                                        END
                                    FROM current_threats),
            'active_threats', (
                SELECT 
                    JSON_ARRAYAGG(
                        JSON_OBJECT(
                            'creature_type', ct.creature_type,
                            'threat_level', ct.threat_level,
                            'last_sighting_date', ct.last_sighting_date,
                            'territory_proximity', ct.territory_proximity,
                            'estimated_numbers', (SELECT sum(c.estimated_population) FROM creatures c WHERE c.type = ct.type),
                            'creature_ids', (
                                SELECT JSON_ARRAYAGG(c.creature_id)
                                FROM creatures c
                                WHERE c.type = ct.type AND c.active = 1
                            )
                        )
                    )
                FROM
                    current_threats ct
            )
        ),
        'vulnerability_analysis', (
            SELECT
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'zone_id', va.zone_id,
                        'zone_name', va.zone_name,
                        'vulnerability_score', ROUND(va.historical_breaches * 
                                                     va.access_points *
                                                    (1.0 / NULLIF(va.wall_integrity, 0)) *
                                                    (1.0 / NULLIF(va.trap_density, 0)) *
                                                    (1.0 / NULLIF(va.squads_count, 0)) *
                                                    (1.0 / NULLIF(va.fortification_level, 0)),
                                               2),
                        'historical_breaches', va.historical_breaches,
                        'fortification_level', va.fortification_level,
                        'military_response_time', va.military_response_time,
                        'defense_coverage', JSON_OBJECT(
                            'structure_ids', (
                                SELECT JSON_ARRAYAGG(ds.structure_id)
                                FROM defense_structures ds
                                WHERE ds.location_id = va.location_id
                            ),
                            'squad_ids', (
                                SELECT JSON_ARRAYAGG(mcz.squad_id)
                                FROM military_coverage_zones mcz
                                WHERE mcz.location_id = va.location_id
                            )
                        )
                    )
                )
            FROM
                vulnerability_analysis va
        ),
        'defense_effectiveness', (
            SELECT
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'defense_type', de.defense_type,
                        'effectiveness_rate', de.effectiveness_rate,
                        'avg_enemy_casualties', de.avg_enemy_casualties,
                        'structure_ids', (
                            SELECT JSON_ARRAYAGG(ds.structure_id)
                            FROM defense_structures ds
                            WHERE ds.type = de.defense_type
                        )
                    )
                )
            FROM
                defense_effectiveness de 
        ),
        'military_readiness_assessment', (
            SELECT
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'squad_id', mra.squad_id,
                        'squad_name', mra.squad_name,
                        'readiness_score', ROUND(1 - (mra.dwarves_on_mission_count::DECIMAL / NULLIF(mra.active_members, 0)), 2),
                        'active_members', mra.active_members,
                        'avg_combat_skill', mra.avg_combat_skill,
                        'combat_effectiveness', mra.combat_effectiveness,
                        'response_coverage', (
                            SELECT 
                                JSON_ARRAYAGG(
                                    JSON_OBJECT(
                                        'zone_id', mcz.zone_id,
                                        'response_time', mcz.response_time
                                    )
                                )
                            FROM
                                military_coverage_zones mcz
                            WHERE mcz.squad_id = mra.squad_id
                        )
                    )
                )
            FROM
                military_readiness_assessment mra
        ),
        'security_evolution', (
            SELECT
                JSON_ARRAYAGG(
                    JSON_OBJECT(
                        'year', se.year,
                        'defense_success_rate', se.defense_success_rate,
                        'total_attacks', se.total_attacks,
                        'casualties', se.casualties,
                        'year_over_year_improvement', se.defense_success_rate - 
                                                      lag(se.defense_success_rate) OVER (ORDER BY EXTRACT(YEAR FROM ca.date))
                    )
                )
            FROM
                security_evolution se
        )
    ) AS security_analysis
FROM
    (SELECT 1) AS dummy
ORDER BY
    overall_defense_success_rate DESC;
