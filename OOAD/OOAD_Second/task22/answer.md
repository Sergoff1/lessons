Представим, что мы пишем код игры. У нас есть две иерархии: "Тип персонажа"(игровой, неигровой) и "Класс персонажа"(воин, лучник...).
В нашем случае обе этих иерархии важны. Класс задаёт тип урона, различные модификаторы и особые способности. 
А тип персонажа влияет на обзор, скорость передвижения и так далее. Мы хотим сделать так, чтобы персонажи игроков по всем параметрам немного превосходили NPC.  
Подразумевается, что иерархии будут активно комбинироваться. Но Java не поддерживает множественное наследование. Поэтому сделаем "Тип персонажа" первичным признаком.
Итоговая иерархия может выглядеть как-то так:

```java
import java.util.Random;

abstract class GameCharacter {
    private String name;
    private GameClass gameClass;

    public GameCharacter(String name, GameClass gameClass) {
        this.name = name;
        this.gameClass = gameClass;
    }

    //Методы...
}

class PlayerCharacter extends GameCharacter {

    public PlayerCharacter(String name, GameClass gameClass) {
        super(name, gameClass);
    }

    //Методы...
}

class NonPlayerCharacter extends GameCharacter {

    public NonPlayerCharacter(String name, GameClass gameClass) {
        super(name, gameClass);
    }

    //Методы...
}

abstract class GameClass {
    protected static final double BASE_DAMAGE_MODIFIER = 1.0;
    protected Random random = new Random();

    //Методы...
}

class Warrior extends GameClass {
    
    private static final double CLASS_BONUS_DAMAGE_MODIFIER = 1.3;

    private double getDamage() {
        return BASE_DAMAGE_MODIFIER * CLASS_BONUS_DAMAGE_MODIFIER * random.nextInt(10);
    }

    //Методы...
}

class Archer extends GameClass {
    private static final double CLASS_BONUS_DAMAGE_MODIFIER = 0.9;

    private double getDamage() {
        return BASE_DAMAGE_MODIFIER * CLASS_BONUS_DAMAGE_MODIFIER * random.nextInt(10);
    }

    //Методы...
} 
```

Ну а вообще, в ходе прохождения прошлых занятий, я сделал вывод, что лучше не спешить с наследованием и часто можно решить проблемы с помощью композиции. 
Так, обе иерархии можно попробовать выразить в виде полей общего класса.
```java
class GameCharacter {
    private GameClass gameClass;
    private CharacterType type;
}

abstract class GameClass {
    //...
}

class Warrior extends GameClass {
    //...
}

class Archer extends GameClass {
    //...
}

abstract class CharacterType {
    //...
}

class PlayerCharacter extends CharacterType {
    //...
}

class NonPlayerCharacter extends CharacterType {
    //...
}
```