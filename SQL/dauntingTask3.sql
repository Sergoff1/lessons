/*
Комплексная оценка военной эффективности отрядов

Запрос оценивающий эффективность военных отрядов на основе:
- Результатов всех сражений (победы/поражения/потери)
- Соотношения побед к общему числу сражений
- Навыков членов отряда и их прогресса
- Качества экипировки
- Истории тренировок и их влияния на результаты
- Выживаемости членов отряда в долгосрочной перспективе 
*/
WITH battle_stats AS (
    SELECT
        sb.squad_id,
        count(*) AS total_battles,
        count(CASE sb.outcome = 'victory' THEN 1 END) AS victories,
        sum(sb.casualties) AS total_casualties,
        sum(sb.enemy_casualties) AS enemy_casualties
    FROM
        squad_battles sb
    GROUP BY
        sb.squad_id
), members_info AS (
    SELECT
        sm.squad_id,
        count(CASE sm.exit_date IS NULL THEN 1 END) AS current_members,
        count(distinct d.dwarf_id) AS total_members_ever -- distinct на случай если гном уходил из отряда, а потом вернулся
    FROM
        squad_members sm
    JOIN
        dwarves d ON d.dwarf_id = sm.dwarf_id
    GROUP BY
        sm.squad_id
), equipment_info AS (
    SELECT
        se.squad_id,
        avg(e.quality) AS avg_equipment_quality
    FROM
        squad_equipment se
    JOIN equipment e ON e.equipment_id = se.equipment_id 
    GROUP BY
        se.squad_id
), training_info AS (
    SELECT
        st.squad_id,
        count(st.schedule_id) AS total_training_sessions,
        avg(st.effectiveness) AS avg_training_effectiveness
    FROM
        squad_training st
    GROUP BY
        st.squad_id
), skill_improvement AS (
    SELECT
        sm.squad_id,
        count(CASE ds.date <= sm.join_date THEN 1 END) AS skills_count_before,
        count(s.skill_id) AS current_skills_count
    FROM
        squad_members sm
    JOIN 
        dwarf_skills ds ON ds.dwarf_id = sm.dwarf_id
    JOIN 
        skills s ON s.skill_id = ds.skill_id
    WHERE 
        s.category = 'combat'
    GROUP BY
        sm.squad_id, sm.dwarf_id
)
SELECT
    ms.squad_id,
    ms.name AS squad_name,
    ms.formation_type,
    d.name AS leader_name,
    bs.total_battles,
    bs.victories,
    ROUND((bs.victories::DECIMAL / NULLIF(bs.total_battles, 0)) * 100, 2) AS victory_percentage,
    ROUND(bs.total_casualties::DECIMAL / NULLIF(mi.total_members_ever, 0) * 100, 2) AS casualty_rate,
    ROUND(bs.enemy_casualties::DECIMAL / NULLIF(bs.total_casualties, 0), 2) AS casualty_exchange_ratio,
    mi.current_members,
    mi.total_members_ever,
    ROUND((mi.current_members::DECIMAL / NULLIF(mi.total_members_ever)) * 100, 2) AS retention_rate,
    ei.avg_equipment_quality,
    ti.total_training_sessions,
    ti.avg_training_effectiveness,
    CORR(ti.total_training_sessions, bs.victories) AS training_battle_correlation,
    ROUND(avg(si.current_skills_count - si.skills_count_before), 2) AS avg_combat_skill_improvement,
    ROUND(
        (bs.victories::DECIMAL / NULLIF(bs.total_battles, 0)) * 0.3 +
        (mi.current_members::DECIMAL / mi.total_members_ever) * 0.25 +
        avg_training_effectiveness * 0.25 +
        avg(si.current_skills_count - si.skills_count_before) * 0.2, 
        3) AS overall_effectiveness_score
     JSON_OBJECT(
        'member_ids', (
            SELECT JSON_ARRAYAGG(sm.dwarf_id)
            FROM squad_members sm
            WHERE sm.squad_id = ms.squad_id
        ),
        'equipment_ids', (
            SELECT JSON_ARRAYAGG(se.equipment_id)
            FROM squad_equipment se
            WHERE se.squad_id = ms.squad_id
        ),
        'battle_report_ids', (
            SELECT JSON_ARRAYAGG(sb.report_id)
            FROM squad_battles sb
            WHERE sb.squad_id = ms.squad_id
        ),
        'training_ids', (
            SELECT JSON_ARRAYAGG(st.schedule_id)
            FROM squad_training st
            WHERE st.squad_id = ms.squad_id
        )
    ) AS related_entities
FROM
    military_squads ms
LEFT JOIN
    members_info mi ON mi.squad_id = ms.squad_id
LEFT JOIN
    battle_stats bs ON bs.squad_id = ms.squad_id
LEFT JOIN
    dwarves d ON d.dwarf_id = ms.leader_id
LEFT JOIN 
    equipment_info ei ON ei.squad_id = ms.squad_id
LEFT JOIN 
    training_info ti ON ti.squad_id = ms.squad_id
LEFT JOIN 
    skill_improvement si ON si.squad_id = ms.squad_id
ORDER BY 
    overall_effectiveness_score DESC;
