В методе Squirrel получал первую цифру факториала путём преобразования его в строку, извлечения первого символа и обратного преобразования в числовой тип. Теперь получение первой цифры факториала происходит благодаря делению числа на 10 некоторое количество раз. Избавился от 2 изменений типа данных.

В методе ConquestCampaign ввёл 3 логических переменных для повышения читабельности программы. Они обозначают строку с которой идёт работа (*isMiddleRow*, *isTopRow*, *isBottomRow*). Раньше в конструкции *if* использовались условия типа `battleField[i][j] == 1 && i !=0 && i != battleField.length - 1`.

В методе PatternUnlock ввёл 2 логических переменных для повышения читабельности программы. *isTheSameRow*, *isTheSameColumn* показывают одни и те же ли столбцы/строки используются в двух соседних символах вводимой последовательности.

Избавился от 2 вещественных чисел и их сравнения в методе PatternUnlock. Я использовал вещественные числа для обозначения индекса элемента в двумерном массиве (целая часть показывала индекс строки, а дробная - столбца). Также приходилось сравнивать части этих чисел для определения того, что для доступа к следующему элементу разблокировки не нужно делать диагональное движение. Вместо вещественного числа, для обозначения индекса стал использовать целочисленный массив из 2-х элементов. 1-й элемент - строка, 2-й - столбец. Таким образом, убраны 2 вещественных числа и сравнение их частей.

Ввёл 4 логические переменные, для повышения читабельности программы, в методе WordSearch. *isFirstWord*,*isLastWord*, *isMiddleWord*, *isSingleWord* показывают какое место слово занимает в строке.

Ввёл логическую переменную *isGreen* в методе Unmanned, обозначающую зелёный сигнал светофора. Это нововведение облегчает читаемость кода.

Избавился от магического символа, введя константу *NO_BRANCH* в методе TreeOfLife, которая означает отсутствие ветки.

Ввёл 2 логические переменные для повышения читабельности кода в методе TankRush. *topLeftCornerMatch* означает совпадение элементов, из левого верхнего угла, нашей и вражеской карты, а *enemyWithinBorder* говорит о том, что силы врага находятся в пределах наших границ. При соблюдении этих условий мы начинаем проверять прочие элементы с карты врага на соответствие элементам нашей карты.

Избавился от магической строки, введя константу *EMPTY_STRING* в методе ShopOLAP, которая означает пустую строку. Константа используется 5 раз.

Предупредил появление ошибки деления на 0 в методе MassVote, введя условную конструкцию *if*, проверяющую не является ли знаменатель нулевым.

Избавился от магического символа, введя константу *EDGE_ELEMENT* в методе LineAnalysis, которая содержит значение крайних элементов, обязательное для передаваемой строки.

Избавился от магической строки, введя константу *OPEN_DOOR* в методе Keynaker, которая означает открытую дверь.