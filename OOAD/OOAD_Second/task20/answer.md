### Наследования вариаций

```java
class Sportsman {
    
    public void jump() {
        System.out.println("Sportsman jumped.");
    }
}

class BodyBuilder extends Sportsman {

    //Наследование с функциональной вариацией. Менялась лишь логика.
    @Override
    public void jump() {
        System.out.println("Bodybuilder tried to jump, but he was too heavy and couldn't get off the ground.");
    }
}

class Trampolinist extends Sportsman {

    //Наследование с вариацией типа. Перегрузили родительский метод, изменив его сигнатуру.
    public void jump(Trampoline trampoline) {
        System.out.println("Trampolinist jumped on a " + trampoline.getName());
    }
}
```

### Наследование с конкретизацией

```java
abstract class Bicycle {
    
    public abstract void ride();
}

class MountainBicycle extends Bicycle {

    //Наследование с конкретизацией. Родительский метод абстрактный. 
    @Override
    public void ride() {
        System.out.println("Driving through the mountains");
    }
}
```

### Структурное наследование

```java
interface Summable<T> {
    T sum(T other);
}

class MyInteger implements Summable<MyInteger> {
    private final Integer value;

    public MyInteger(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    //Реализация метода из интерфейса Summable. 
    @Override
    public MyInteger sum(MyInteger other) {
        return new MyInteger(this.value + other.getValue());
    }
}
```
