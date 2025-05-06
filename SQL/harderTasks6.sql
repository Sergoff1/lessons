-- 1. Найдите все отряды, у которых нет лидера. 
SELECT name
FROM Squads
WHERE leader_id IS NULL;

-- 2. Получите список всех гномов старше 150 лет, у которых профессия "Warrior". 
SELECT name
FROM Dwarves
WHERE age > 150
AND profession = 'Warrior';

-- 3. Найдите гномов, у которых есть хотя бы один предмет типа "weapon".
SELECT name
FROM Dwarves d
JOIN Items i ON i.owner_id = d.dwarf_id
WHERE i.type = 'weapon';

-- 4. Получите количество задач для каждого гнома, сгруппировав их по статусу.
SELECT d.dwarf_id dwarfId,
       d.name dwarfName,
       t.status taskStatus,
       count(*) tasksCount
FROM Dwarves d
JOIN Tasks t ON t.assigned_to = d.dwarf_id
GROUP BY d.dwarf_id, d.name, t.status;

-- 5. Найдите все задачи, которые были назначены гномам из отряда с именем "Guardians".
SELECT t.description,
       t.status
FROM Tasks t
JOIN Dwarves d ON d.dwarf_id = t.assigned_to
JOIN Squads s ON s.squad_id = d.squad_id
WHERE s.name = 'Guardians';

-- 6. Выведите всех гномов и их ближайших родственников, указав тип родственных отношений. 
SELECT d.name dwarfName,
       rd.name relativeName,
       r.relationship
FROM Dwarves d
JOIN Relationships r ON r.dwarf_id = d.dwarf_id
JOIN Dwarves rd ON rd.dwarf_id = r.related_to;
