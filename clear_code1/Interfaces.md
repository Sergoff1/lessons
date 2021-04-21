##### Задание 3.1:
У меня в коде не создаются объекты моих классов, потому переводим тумблер отвечающий за фантазию в положение "Вкл" :)

[Класс Squirrel.](https://github.com/Sergoff1/lessons/blob/main/problems28/Squirrel.java)
Сделал целочисленное поле, означающее количество орехов, и 2 статических метода-фабрики, которые заполняли значение поля:
1. Squirrel squirrel = Squirrel.IntegerNumberOfNuts();
1. Squirrel squirrel = Squirrel.RealNumberOfNuts();

Второй метод, перед записью количества орехов, округлял введённое значение до целого числа.

Класс Analysis (*содержит метод lineAnalysis*).
Представил, что у нас есть поле хранящее строку, которая затем проверяется на корректность шаблона. Тогда создадим пару методов-фабрик:
1. Analysis analysis = Analysis.FromString("\*.\*\*.\*");
1. Analysis analysis = Analysis.FromIntegerNumber(101101);

Второй метод переведёт число в строку вида "\*.\*\*.\*".

Класс VehicleDashboard (*содержит метод odometer*).
Представил, что у нас есть поле, представляющее собой массив, хранящее скорости и время(раньше мы передавали его методу odometer). Чтобы заполнить это массив можно передать конструктору не только массив, но и строку с нужными значениями:
1. VehicleDashboard dashboard = VehicleDashboard.SpeedTimeFromArray(speedTimeArray);
1. VehicleDashboard dashboard = VehicleDashboard.SpeedTimeFromString("10,1,20,2");

Второй метод переведёт строку в целочисленный массив.

##### Задание 3.2:
Не использовал интерфейсы и абстрактные классы.
