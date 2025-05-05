-- 1. Получить информацию о всех гномах, которые входят в какой-либо отряд, вместе с информацией об их отрядах.
SELECT * 
FROM Dwarves 
JOIN Squads USING (squad_id);

-- 2. Найти всех гномов с профессией "miner", которые не состоят ни в одном отряде.
SELECT * 
FROM Dwarves 
WHERE profession = 'miner' AND squad_id IS NULL;

-- 3. Получить все задачи с наивысшим приоритетом, которые находятся в статусе "pending".
SELECT * 
FROM Tasks 
WHERE status = 'pending' AND priority = (SELECT max(priority) FROM Tasks);

-- 4. Для каждого гнома, который владеет хотя бы одним предметом, получить количество предметов, которыми он владеет.
SELECT dw.dwarf_id, 
       count(*) items_number 
FROM Items it 
JOIN Dwarves dw ON it.owner_id = dw.dwarf_id 
GROUP BY dw.dwarf_id;

-- 5. Получить список всех отрядов и количество гномов в каждом отряде. Также включите в выдачу отряды без гномов.
SELECT sq.squad_id,
       count(*) dwarfs_number
FROM Squads sq
LEFT JOIN Dwarves dw ON sq.squad_id = dw.squad_id
GROUP BY sq.squad_id;

-- 6. Получить список профессий с наибольшим количеством незавершённых задач ("pending" и "in_progress") у гномов этих профессий.
WITH unfinished_tasks_by_profs AS (
    SELECT dw.profession, dw.dwarf_id, count(*) unfinished_tasks
    FROM Dwarves dw
    JOIN Tasks ts ON ts.assigned_to = dw.dwarf_id
    WHERE ts.status IN ('pending', 'in_progress')
    GROUP BY dw.profession, dw.dwarf_id
)
SELECT utbp.profession, max(utbp.unfinished_tasks)
FROM unfinished_tasks_by_profs utbp
GROUP BY utbp.profession;

-- 7. Для каждого типа предметов узнать средний возраст гномов, владеющих этими предметами.
SELECT it.type, avg(dw.age) owners_average_age
FROM Items it 
JOIN Dwarves dw ON it.owner_id = dw.dwarf_id
GROUP BY it.type;

-- 8. Найти всех гномов старше среднего возраста (по всем гномам в базе), которые не владеют никакими предметами. 
SELECT dw.*
FROM Dwarves dw
WHERE dw.age > (SELECT avg(age) FROM Dwarves)
AND NOT EXISTS(SELECT 1 FROM Items WHERE owner_id = dw.dwarf_id);
