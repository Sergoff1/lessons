### Структура версии 1
Задание 1

Таблица Dwarves

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| dwarf_id     | INT          | Уникальный идентификатор гнома            |
| name         | VARCHAR(100) | Имя гнома                                 |
| age          | INT          | Возраст гнома                             |
| profession   | VARCHAR(100) | Профессия гнома                           |
| squad_id     | INT          | Идентификатор отряда (NULL, если не в отряде)|

Таблица Squads

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| squad_id     | INT          | Уникальный идентификатор отряда           |
| name         | VARCHAR(100) | Название отряда                           |
| mission      | VARCHAR(100) | Текущая миссия отряда                     |

Таблица Tasks

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| task_id      | INT          | Уникальный идентификатор задачи           |
| description  | VARCHAR(255) | Описание задачи                           |
| priority     | INT          | Приоритет задачи                          |
| assigned_to  | INT          | Идентификатор гнома, ответственного за задачу (NULL, если не назначена)|
| status       | VARCHAR(50)  | Статус задачи (например, 'pending', 'in_progress', 'completed')|

Таблица Items

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| item_id      | INT          | Уникальный идентификатор предмета         |
| name         | VARCHAR(100) | Название предмета                         |
| type         | VARCHAR(100) | Тип предмета(например, 'weapon', 'armor', 'tool')|
| owner_id     | INT          | Идентификатор гнома-владельца (NULL, если предмет общий)|

---

### Структура версии 2
Задание 2

Таблица Dwarves

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| dwarf_id     | INT          | Уникальный идентификатор гнома            |
| name         | VARCHAR(100) | Имя гнома                                 |
| age          | INT          | Возраст гнома                             |
| profession   | VARCHAR(100) | Профессия гнома                           |
| squad_id     | INT          | Идентификатор отряда (NULL, если не в отряде)|

Таблица Squads

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| squad_id     | INT          | Уникальный идентификатор отряда           |
| name         | VARCHAR(100) | Название отряда                           |
| leader_id    | INT          | Идентификатор лидера отряда (ссылка на dwarf_id из таблицы Dwarves)|

Таблица Tasks

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| task_id      | INT          | Уникальный идентификатор задачи           |
| description  | TEXT         | Описание задачи                           |
| assigned_to  | INT          | Идентификатор гнома, ответственного за задачу (NULL, если не назначена)|
| status       | VARCHAR(50)  | Статус задачи (например, 'pending', 'in_progress', 'completed')|

Таблица Items

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| item_id      | INT          | Уникальный идентификатор предмета         |
| name         | VARCHAR(100) | Название предмета                         |
| type         | VARCHAR(50)  | Тип предмета (например, 'weapon', 'armor', 'tool')|
| owner_id     | INT          | Идентификатор гнома-владельца (ссылка на dwarf_id из таблицы Dwarves, или NULL если не присвоено)|

Таблица Relationships


| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| dwarf_id     | INT          | Уникальный идентификатор гнома (ссылка на dwarf_id)|
| related_to   | INT          | Идентификатор другого гнома (ссылка на dwarf_id)|
| relationship | VARCHAR(50)  | Тип отношения (например, 'Друг', 'Супруг', 'Родитель')|

---

### Структура версии 3
```
+---------------------+        +---------------------+        +---------------------+
| FORTRESSES          |        | DWARVES             |        | DWARF_SKILLS        |
+---------------------+        +---------------------+        +---------------------+
| fortress_id (PK)    |<---+   | dwarf_id (PK)       |<---+   | dwarf_id (FK)       |
| name                |    |   | name                |    |   | skill_id (FK)       |
| location            |    |   | age                 |    |   | level               |
| founded_year        |    |   | profession          |    |   | experience          |
| depth               |    |   | fortress_id (FK)    |    |   | date                |
| population          |    |   +---------------------+    |   +---------------------+
+---------------------+    |                              |
                           |                              |   +---------------------+
                           |                              |   | SKILLS              |
                           |                              |   +---------------------+
+---------------------+    |   +---------------------+    |   | skill_id (PK)       |
| WORKSHOPS           |    |   | DWARF_ASSIGNMENTS   |    |   | name                |
+---------------------+    |   +---------------------+    |   | category            |
| workshop_id (PK)    |<---+   | assignment_id (PK)  |    |   | description         |
| name                |    |   | dwarf_id (FK)       |----+   | skill_type          |
| type                |    |   | assignment_type     |        +---------------------+
| quality             |    |   | start_date          |
| fortress_id (FK)    |----+   | end_date            |        +---------------------+
+---------------------+        +---------------------+        | DWARF_EQUIPMENT     |
                                                              | dwarf_id (FK)       |
+---------------------+        +---------------------+        | equipment_id (FK)   |
| WORKSHOP_CRAFTSDWARVES|      | MILITARY_SQUADS     |        | quality             |
+---------------------+        +---------------------+        | equipped_date       |
| workshop_id (FK)    |        | squad_id (PK)       |<---+   +---------------------+
| dwarf_id (FK)       |        | name                |    |
| assignment_date     |        | formation_type      |    |   +---------------------+
| role                |        | leader_id (FK)      |----+   | EQUIPMENT           |
+---------------------+        | fortress_id (FK)    |----+   +---------------------+
                               +---------------------+        | equipment_id (PK)   |
+---------------------+                                       | name                |
| WORKSHOP_MATERIALS  |        +---------------------+        | type                |
+---------------------+        | SQUAD_MEMBERS       |        | material_id (FK)    |
| workshop_id (FK)    |        +---------------------+        | quality             |
| material_id (FK)    |        | squad_id (FK)       |----+   +---------------------+
| is_input            |        | dwarf_id (FK)       |----+
| quantity            |        | join_date           |        +---------------------+
+---------------------+        | role                |        | SQUAD_EQUIPMENT     |
                               | exit_date           |        +---------------------+
                               | exit_reason         |        | squad_id (FK)       |
                               +---------------------+        | equipment_id (FK)   |
                                                              | quantity            |
+---------------------+        +---------------------+        | issued_date         |
| WORKSHOP_PRODUCTS   |        | SQUAD_OPERATIONS    |        +---------------------+
+---------------------+        +---------------------+
| workshop_id (FK)    |        | operation_id (PK)   |
| product_id (FK)     |        | squad_id (FK)       |----+
| production_date     |        | type                |    |   +---------------------+
| quantity            |        | start_date          |    |   | SQUAD_TRAINING      |
+---------------------+        | end_date            |    |   +---------------------+
                               | status              |    |   | schedule_id (PK)    |
+---------------------+        +---------------------+    |   | squad_id (FK)       |
| PRODUCTS            |                                   |   | type                |
+---------------------+        +---------------------+    |   | frequency           |
| product_id (PK)     |        | SQUAD_BATTLES       |    |   | location_id (FK)    |
| name                |        +---------------------+    |   | effectiveness       |
| type                |        | report_id (PK)      |    |   | duration_hours      |
| quality             |        | squad_id (FK)       |----+   | date                |
| material_id (FK)    |        | date                |        +---------------------+
| value               |        | outcome             |
| created_by          |        | enemy_type          |
| workshop_id         |        | casualties          |        +---------------------+
+---------------------+        | enemy_casualties    |        | RESOURCES           |
                               +---------------------+        +---------------------+
                                                              | resource_id (PK)    |
+---------------------+        +---------------------+        | name                |
| PROJECTS            |        | EXTRACTION_SITES    |        | type                |
+---------------------+        +---------------------+        | rarity              |
| project_id (PK)     |        | site_id (PK)        |        | description         |
| name                |        | name                |        +---------------------+
| type                |        | type                |
| status              |        | resource_id (FK)    |----+
| priority            |        | depth               |    |   +---------------------+
| workshop_id (FK)    |        | accessibility       |    |   | FORTRESS_RESOURCES  |
+---------------------+        +---------------------+    |   +---------------------+
                                                          |   | fortress_id (FK)    |
+---------------------+        +---------------------+    |   | resource_id (FK)    |
| PROJECT_WORKERS     |        | PROJECT_MATERIALS   |    |   | quantity            |
+---------------------+        +---------------------+    |   | discovery_date      |
| project_id (FK)     |        | project_id (FK)     |    |   +---------------------+
| dwarf_id (FK)       |        | material_id (FK)    |----+
| assignment_date     |        | quantity_required   |
| role                |        | quantity_available  |        +---------------------+
+---------------------+        +---------------------+        | STOCKPILE_CONTENTS  |
                                                             +---------------------+
+---------------------+        +---------------------+        | stockpile_id (PK)   |
| PROJECT_DEPENDENCIES |       | PROJECT_ZONES       |        | resource_id (FK)    |
+---------------------+        +---------------------+        | quantity            |
| project_id (FK)     |        | project_id (FK)     |        | quality             |
| dependent_project_id |       | zone_id (PK)        |        +---------------------+
| dependency_type     |        | area                |
+---------------------+        | purpose             |
                               +---------------------+        +---------------------+
+---------------------+                                       | CARAVANS            |<----+
| ORDERS              |        +---------------------+        +---------------------+     |
+---------------------+        | TRADERS             |        | caravan_id (PK)     |     |
| order_id (PK)       |        +---------------------+        | arrival_date        |     |
| project_id (FK)     |        | trader_id (PK)      |        | departure_date      |     |
| description         |        | name                |        | civilization_type   |     |
| creation_date       |        | race                |        | fortress_id (FK)    |     |
| priority            |        | caravan_id (FK)     |--------+---------------------+     |
| status              |        | specialty           |                                    |
+---------------------+        +---------------------+        +---------------------+     |
                                                              | CARAVAN_GOODS       |     |
+---------------------+        +---------------------+        +---------------------+     |
| TRADE_TRANSACTIONS  |        | DWARF_INTERESTS     |        | goods_id (PK)       |     |
+---------------------+        +---------------------+        | caravan_id (FK)     |-----+
| transaction_id (PK) |        | dwarf_id (FK)       |        | name                |     |
| caravan_id (FK)     |--------| goods_type          |        | type                |     |
| date                |        | interest_level      |        | quantity            |     |
| fortress_items      |        +---------------------+        | value               |     |
| caravan_items       |                                       | material_type       |     |
| value               |        +---------------------+        | price_fluctuation   |     |
| balance_direction   |        | CREATURES           |        | original_product_id |     |
+---------------------+        +---------------------+        +---------------------+     |
                               | creature_id (PK)    |                                    |
+---------------------+        | name                |        +---------------------+     |
| EXPEDITIONS         |        | type                |        | DIPLOMATIC_EVENTS   |     |
+---------------------+        | threat_level        |        +---------------------+     |
| expedition_id (PK)  |        | active              |        | event_id (PK)       |     |
| destination         |        | estimated_population |       | caravan_id (FK)     |-----+
| departure_date      |        +---------------------+        | type                |
| return_date         |                                       | outcome             |
| status              |        +---------------------+        | date                |
+---------------------+        | CREATURE_SIGHTINGS  |        | relationship_change |
                               +---------------------+        | civilization_type   |
+---------------------+        | sighting_id (PK)    |        +---------------------+
| EXPEDITION_SITES    |        | creature_id (FK)    |
+---------------------+        | location            |        +---------------------+
| expedition_id (FK)  |        | date                |        | EXPEDITION_MEMBERS  |
| site_id (FK)        |        | witness_id (FK)     |        +---------------------+
| discovery_date      |        +---------------------+        | expedition_id (FK)  |
| notes               |                                       | dwarf_id (FK)       |
+---------------------+        +---------------------+        | role                |
                               | CREATURE_ATTACKS    |        | survived            |
+---------------------+        +---------------------+        +---------------------+
| EXPEDITION_CREATURES |       | attack_id (PK)      |
+---------------------+        | creature_id (FK)    |        +---------------------+
| expedition_id (FK)  |        | date                |        | EXPEDITION_ARTIFACTS |
| creature_id (FK)    |        | casualties          |        +---------------------+
| encounter_date      |        | enemy_casualties    |        | expedition_id (FK)  |
| outcome             |        | location_id         |        | artifact_id (PK)    |
+---------------------+        | outcome             |        | discovery_date      |
                               | defense_structures_used |    | value               |
+---------------------+        | military_response_time_minutes | +-----------------+
| EXPEDITION_EQUIPMENT |       +---------------------+
+---------------------+                                       +---------------------+
| expedition_id (FK)  |        +---------------------+        | EXPEDITION_REPORTS  |
| equipment_id (FK)   |        | CREATURE_TERRITORIES |       +---------------------+
| quantity            |        +---------------------+        | report_id (PK)      |
| return_condition    |        | territory_id (PK)   |        | expedition_id (FK)  |
+---------------------+        | creature_id (FK)    |        | author_id (FK)      |
                               | area                |        | title               |
+---------------------+        | danger_level        |        | content             |
| LOCATIONS           |        | distance_to_fortress |       | creation_date       |
+---------------------+        +---------------------+        +---------------------+
| location_id (PK)    |
| zone_id             |
| name                |
| zone_type           |
| depth               |
| access_points       |
| fortification_level |
| wall_integrity      |
| trap_density        |
| choke_points        |
+---------------------+
```