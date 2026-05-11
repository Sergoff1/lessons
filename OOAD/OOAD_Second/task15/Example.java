package OOAD_Second.task15;

import java.util.List;


/*
Допустим у нас есть класс, который обозначает услугу. Она может быть бонусной или обычной, от этого зависит логика активации.
Вместо введения булевой переменной isBonus, сделаем иерархию классов, под каждое значение isBonus.
 */
abstract class Service {
    //Поля услуги...

    public abstract void activate();

    //Прочие методы...
}

class BonusService extends Service {

    @Override
    public void activate() {
        System.out.println("Activating Bonus Service");
    }
}

class DefaultService extends Service {

    @Override
    public void activate() {
        System.out.println("Activating Default Service");
    }
}

public class Example {
    public static void main(String[] args) {
        List<Service> services = List.of(new BonusService(), new DefaultService());
        services.forEach(Service::activate);
    }
}