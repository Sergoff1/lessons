**Запрос 1:**  
Запрос верный, но я использовал `*` для получения всей информации из таблиц. После ознакомления с эталонным решением, пришла мысль, что такой подход не очень хорош, так как можно выдать лишние данные, которые мы бы не хотели показывать. Возможно они просто не нужны, а может их даже вредно показывать. Даже если в моменте ничего страшного нет, то в будущем это может навредить, когда мы расширим схему таблиц какими-нибудь чувствительными данными и забудем о `*`. Стоит сразу вырабатывать рефлекс делать как положено, не смотря на то, учебное задание или нет. В будущем следует явно перечислять необходимые данные.

**Запрос 2:**  
Запрос выполняет свою работу, но тут тоже используется `*` для получения информации, а значит для него справедливы рассуждения из рефлексии по первому запросу.

**Запрос 3:**  
Тут тоже `*`, о которой рассуждал выше. Также сам запрос написан неверно, так как я не указал статус задачи в подзапросе на получение максимального приоритета. Кажется, я не так понял задание и искал задачи с наивысшим приоритетом (независимо от статуса), а потом среди них смотрел задачи в статусе pending. В эталоне же извлекаются задачи с приоритетом максимальным для задач в статусе pending. Тут я могу посоветовать себе внимательнее изучать формулировки заданий.

**Запрос 4:**  
В эталоне возвращается больше информации о гномах: имя и профессия. В моём запросе -- только идентификатор. При решении задания думал над тем какие поля гнома возвращать и решил остановиться на идентификаторе, так как явных требований не было. Также в эталоне используется COUNT(имя_колонки), а в моём запросе COUNT(*). В первом случае при подсчёте не учитываются записи со значением NULL в указанной колонке. Если в БД есть предметы без ID (кажется так быть не должно, однако в схеме БД никаких ограничений на этот счёт не указано), то запросы могут вернуть разное количество вещей у гнома.

**Запрос 5:**  
Запрос возвращает нужные данные, но размышления по четвёртому запросу подходят и сюда.

**Запрос 6:**  
Моё решение неверное. Тут я долго думал что конкретно нужно вернуть и по итогу выбрал неправильный путь. Изначально я рассматривал вариант который приведён в эталоне (вернуть общее количество незавершённых задач у гномов каждой профессии). Но в задании меня смутило слово "наибольшим", раз оно есть, то нужно использовать функцию `max`, подумал я. Думал что же максимального тут искать (было ощущение, что что-то то не так, но я сильно привязался к слову "наибольшим" и функции `max`) и в итоге решил вернуть наибольшее число задач, которое висит на одном гноме каждой профессии (Например среди шахтёров больше всего незавершённых задач висит на Олафе, значит вернём "шахтёры <количество задач у Олафа>"). Итог: задача оказалась проще, а я перемудрил. Что можно пожелать себе на будущее: иногда задача проще чем кажется, думай, не придумал ли ты чего-то лишнего. Может всё проще?

**Запрос 7:**  
Почти совпадает с эталоном. Только в моём решении не переопределено имя столбца type. Для человека, который видит лишь результат запроса будет несколько труднее понять, а что за type имеется в виду.

**Запрос 8:**  
Запрос делает своё дело, но тут тоже используется `*`, о которой я рассуждал в начале. Также я использовал другой подход к поиску гномов, которые не владеют предметами. Решил использовать `NOT EXISTS`, а в эталоне `NOT IN`. Вариант из эталона мне понравился больше, так как он более лаконичен и, кажется, проще воспринимается.