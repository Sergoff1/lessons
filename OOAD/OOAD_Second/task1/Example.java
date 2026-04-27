package OOAD_Second.task1;

import java.util.List;

class Engine {

    //Объём двигателя
    private Double displacementLiters;

    public Engine(Double displacementLiters) {
        this.displacementLiters = displacementLiters;
    }
    //Прочие поля и методы...
}

abstract class Vehicle {
    //Пример композиции. Автомобиль содержит двигатель.
    private Engine engine;

    private String color;

    public Vehicle(Engine engine, String color) {
        this.engine = engine;
        this.color = color;
    }

    public abstract void beep();

    //Геттеры/Сеттеры и прочие методы...
}

//Пример наследования. Легковушка является Автомобилем.
class Car extends Vehicle {

    public Car(Engine engine, String color) {
        super(engine, color);
    }

    @Override
    public void beep() {
        System.out.println("Чахлый гудок");
    }

    //Геттеры/Сеттеры и прочее...
}

//Пример наследования. Грузовик является Автомобилем.
class Truck extends Vehicle {

    //Грузоподъёмность, атрибут актуальный(в нашем случае) только для грузовиков.
    private int loadCapacityKg;

    public Truck(Engine engine, String color, int loadCapacityKg) {
        super(engine, color);
        this.loadCapacityKg = loadCapacityKg;
    }

    @Override
    public void beep() {
        System.out.println("Уважаемое басистое гудение");
    }

    //Геттеры/Сеттеры и прочее...
}

public class Example {

    public static void main(String[] args) {
        Engine engine = new Engine(2.5);
        Car car = new Car(engine, "red");
        Truck truck = new Truck(engine, "black", 5000);

        //Пример полиморфизма. Обращаемся с каждым объектом как с автомобилем. Но при вызове метода beep
        // будем получать разные звуки, так как каждый из подклассов Vehicle задаёт своё поведение.
        List<Vehicle> vehicles = List.of(car, truck);
        vehicles.forEach(Vehicle::beep);
    }
}
