/* 1. Получение информации о крепости с населением (Запрос из примера)
SELECT 
    f.fortress_id,
    f.name,
    f.location,
    f.founded_year,
    JSON_OBJECT(
        'dwarf_ids', (
            SELECT JSON_ARRAYAGG(d.dwarf_id)
            FROM dwarves d
            WHERE d.fortress_id = f.fortress_id
        ),
        'resource_ids', (
            SELECT JSON_ARRAYAGG(fr.resource_id)
            FROM fortress_resources fr
            WHERE fr.fortress_id = f.fortress_id
        ),
        'workshop_ids', (
            SELECT JSON_ARRAYAGG(w.workshop_id)
            FROM workshops w
            WHERE w.fortress_id = f.fortress_id
        ),
        'squad_ids', (
            SELECT JSON_ARRAYAGG(s.squad_id)
            FROM military_squads s
            WHERE s.fortress_id = f.fortress_id
        )
    ) AS related_entities
FROM 
    fortresses f; */

-- 2. Получение данных о гноме с навыками и назначениями
SELECT 
    d.dwarf_id,
    d.name,
    d.age,
    d.profession,
    JSON_OBJECT(
        'skill_ids', (
            SELECT JSON_ARRAYAGG(ds.skill_id)
            FROM dwarf_skills ds
            WHERE ds.dwarf_id = d.dwarf_id
        ),
        'assignment_ids', (
            SELECT JSON_ARRAYAGG(da.assignment_id)
            FROM dwarf_assignments da
            WHERE da.dwarf_id = d.dwarf_id
        ),
        'squad_ids', (
            SELECT JSON_ARRAYAGG(sm.squad_id)
            FROM squad_members sm
            WHERE sm.dwarf_id = d.dwarf_id
        ),
        'equipment_ids', (
            SELECT JSON_ARRAYAGG(de.equipment_id)
            FROM dwarf_equipment de
            WHERE de.dwarf_id = d.dwarf_id
        )
    ) AS related_entities
FROM
    dwarves d;

-- 3. Данные о мастерской с назначенными рабочими и проектами
SELECT 
    w.workshop_id,
    w.name,
    w.type,
    w.quality,
    JSON_OBJECT(
        'craftsdwarf_ids', (
            SELECT JSON_ARRAYAGG(wc.dwarf_id)
            FROM workshop_craftsdwarves wc
            WHERE wc.workshop_id = w.workshop_id
        ),
        'project_ids', (
            SELECT JSON_ARRAYAGG(p.project_id)
            FROM projects p
            WHERE p.workshop_id = w.workshop_id
        ),
        'input_material_ids', (
            SELECT JSON_ARRAYAGG(wm.material_id)
            FROM workshop_materials wm
            WHERE wm.workshop_id = w.workshop_id
            AND wm.is_input = 1
        ),
        'output_product_ids', (
            SELECT JSON_ARRAYAGG(wp.product_id)
            FROM workshop_products wp
            WHERE wp.workshop_id = w.workshop_id
        )
    ) AS related_entities
FROM
    workshops w;

-- 4. Данные о военном отряде с составом и операциями
SELECT 
    ms.squad_id,
    ms.name,
    ms.formation_type,
    ms.leader_id,
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
        'operation_ids', (
            SELECT JSON_ARRAYAGG(so.operation_id)
            FROM squad_operations so
            WHERE so.squad_id = ms.squad_id
        ),
        'training_schedule_ids', (
            SELECT JSON_ARRAYAGG(st.schedule_id)
            FROM squad_training st
            WHERE st.squad_id = ms.squad_id
        ),
        'battle_report_ids', (
            SELECT JSON_ARRAYAGG(sb.report_id)
            FROM squad_battles sb
            WHERE sb.squad_id = ms.squad_id
        )
    ) AS related_entities
FROM
    military_squads ms;
