###### Задание 3.1:

`//If the number of sales is the same we change the places of the elements in lexicographic ascending order`
`... } else if (numOfSoldFirstItem == numOfSoldSecondItem) { ...`
После этой строки следует цикл, сортирующий элементы так, как указано в комментарии.

`//Дважды трансформируем входящий массив`
`B = Transformer(Transformer(A).stream().mapToInt(i->i).toArray());`
Метод Transformer возвращает список, а на входе требует массив, потому здесь использован поток.

`//Branches age by a year`
`...tree2D[i][j]++;...`
Ветви стареют на год.

`//Переводим число в массив цифр`
`for (int j = number.length - 1; j >= 0; j--) {...`
Комментарий дан к блоку кода из 3-х строк, включающего и объявление цикла.

`//Checking for conversion capability`
`if (arrChar[i] > arrChar[i-1]) {...`
Проверка на возможность преобразования порядка символов.

`//Высадка десанта и захват точек`
`...battleField[battalion[i]-1][battalion[i+1]-1] = 1;`
Единственное действие цикла.

`//there is an opportunity to improve player placement`
`return Arrays.equals(F, sortedF);`
Есть ли возможность улучшить расстановку игроков?


###### Задание 3.2:

`//list with combinations of parentheses`
`ArrayList<String> comboOfParentheses = new ArrayList<String>();` 
Убрал комментарий, так как изменил название списка в одном из прошлых заданий курса и надобность в нём отпала.

`//Разрядность меньшего числа`
`int capacitySmallerNum = 0;`
Убрал комментарий, так как изменил название переменной в одном из прошлых заданий курса.

`//double работал неадекватно, писал, что 0,1 != 0,1; Потому привел значения к float, этот тип оказался адекватнее :)`
`if ((int)f != (int)s && (float)(f%1) != (float)(s%1)) ...`
Сверху первоначальная версия кода, до прохождения этого курса.
Снизу та же строка, но после правок. От вещественного типа вообще избавился. Описание правки [здесь](https://github.com/Sergoff1/lessons/blob/main/clear_code1/DataTypes.md) в 3 и 4 абзацах.
`if (isTheSameRow || isTheSameColumn)`

`//Если сейчас горит зелёный`
`if (isGreen) { ...`
Убрал комментарий, так как изменил название переменной в одном из прошлых заданий курса.

`// Принимает true если первое число больше второго, помогает определить максимальное число`
`boolean firstBigger = false;`
Убрал комментарий, так как изменил название переменной в одном из прошлых заданий курса.