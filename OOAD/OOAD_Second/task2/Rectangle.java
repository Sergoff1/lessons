package OOAD_Second.task2;

//Базовый класс, который будем сужать и расширять.
public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Double getArea() {
        return (double) (length * width);
    }

    //Прочие методы...
}

//Пример специализации класса-родителя. Квадрат является частым случаем прямоугольника.
class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }
}

//Пример расширения класса-родителя. Параллелограмм является общим случаем прямоугольника.
// В этом классе появляются дополнительные поля и меняются некоторые методы, таким образом, чтобы они работали для большего количества случаев.
// Класс параллелограмма можно использовать и для задания прямоугольника.
class Parallelogram extends Rectangle {

    private double leftDownAngle;

    public Parallelogram(int length, int width, double leftDownAngle) {
        super(length, width);
        this.leftDownAngle = leftDownAngle;
    }

    @Override
    public Double getArea() {
        return super.getArea() * Math.sin(leftDownAngle);
    }
}
