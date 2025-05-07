/*
Анализ эффективности экспедиций

Запрос, который определяет наиболее и наименее успешные экспедиции, учитывая:
- Соотношение выживших участников к общему числу
- Ценность найденных артефактов
- Количество обнаруженных новых мест
- Успешность встреч с существами (отношение благоприятных исходов к неблагоприятным)
- Опыт, полученный участниками (сравнение навыков до и после) 
*/
WITH exp_surv_rate AS (
    SELECT 
        expedition_id,
        count(*) / count(CASE WHEN survived = 1 THEN 1 END) * 100 as surv_rate
    FROM 
        expedition_members
    GROUP BY 
        expedition_id
), exp_enc_win_rate AS (
    SELECT 
        expedition_id,
        count(*) / count(CASE WHEN outcome = 1 THEN 1 END) * 100 as win_rate
    FROM 
        expedition_creatures
    GROUP BY 
        expedition_id
), exp_skill_gain AS (
    SELECT 
        e.expedition_id,
        count(*) as skills_gained
    FROM 
        dwarf_skills ds 
    JOIN 
        expedition_members em ON em.dwarf_id = ds.dwarf_id
        expedition e ON e.expedition_id = em.expedition_id 
    WHERE 
        ds.date BETWEEN e.departure_date AND e.return_date
    GROUP BY 
        e.expedition_id
)
SELECT
    e.expedition_id,
    e.destination,
    e.status,
    esr.surv_rate AS survival_rate,
    (SELECT sum(value) FROM expedition_artifacts WHERE expedition_id = e.expedition_id) AS artifacts_value,
    (SELECT count(*) FROM expedition_sites WHERE expedition_id = e.expedition_id) AS discovered_sites,
    eewr.win_rate AS encounter_success_rate,
    esg.skills_gained AS skill_improvement,
    e.return_date - e.departure_date AS expedition_duration,
    (eewr.win_rate + esr.surv_rate) / 2 AS overall_success_score,
    JSON_OBJECT(
        'member_ids', (
            SELECT JSON_ARRAYAGG(em.dwarf_id)
            FROM expedition_members em
            WHERE em.expedition_id = e.expedition_id
        ),
        'artifact_ids', (
            SELECT JSON_ARRAYAGG(ea.artifact_id)
            FROM expedition_artifacts ea
            WHERE ea.expedition_id = e.expedition_id
        ),
        'site_ids', (
            SELECT JSON_ARRAYAGG(es.site_id)
            FROM expedition_sites es
            WHERE es.expedition_id = e.expedition_id
        )
    ) AS related_entities
FROM
    expeditions e
JOIN
    exp_surv_rate esr ON esr.expedition_id = e.expedition_id
    exp_enc_win_rate eewr ON eewr.expedition_id = e.expedition_id
    exp_skill_gain esg ON esg.expedition_id = e.expedition_id
WHERE
    e.return_date IS NOT NULL;
