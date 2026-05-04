package OOAD_Second.task8;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {

        //В общем случае Дженерики в Java инвариантны:
        // Список Integer не является потомком списка Numbers.
        // Но при использовании wildcards можно выразить ковариантность и контравариантность.

        //Это ковариантность. Список Integer является потомком списка Number.
        //Здесь используется ключевое слово extends в <>.
        //Ограничение такого подхода: в список с extends нельзя добавлять элементы.
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        List<? extends Number> numbers = integers;
        Number a = numbers.getFirst();
        System.out.println(a);

        //Это контравариантность. Список Number является потомком списка Integer.
        //Здесь используется ключевое слово super в <>.
        //Ограничение такого подхода: из списка с super можно считывать значения лишь типа Object.
        List<Number> nums = new ArrayList<>();
        nums.add(1);
        List<? super Integer> ints = nums;
        ints.add(2);
        Object b = ints.getFirst();
        System.out.println(b);
    }
}
