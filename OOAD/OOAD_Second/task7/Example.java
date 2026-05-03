package OOAD_Second.task7;

import java.util.List;

abstract class Vehicle {

    public abstract void beep();
}

class Car extends Vehicle {

    @Override
    public void beep() {
        System.out.println("Чахлый гудок");
    }
}

class Truck extends Vehicle {

    @Override
    public void beep() {
        System.out.println("Уважаемое басистое гудение");
    }
}

public class Example {

    public static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();

        List<Vehicle> vehicles = List.of(car, truck);

        //Вот тут применяется динамическое связывание.
        //Обращаемся с каждым объектом как с автомобилем. Но при вызове метода beep
        // будем получать разные звуки, так как каждый из потомков Vehicle задаёт своё поведение.
        vehicles.forEach(Vehicle::beep);
    }
}
