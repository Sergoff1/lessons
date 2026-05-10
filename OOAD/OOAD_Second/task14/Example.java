package OOAD_Second.task14;

import java.io.Serializable;
import java.util.List;
import java.util.stream.IntStream;

interface Summable<T> {
    T sum(T other);
}

class General implements Serializable {
    //...
}

class MyInteger extends General implements Summable<MyInteger> {
    private final Integer value;

    public MyInteger(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public MyInteger sum(MyInteger other) {
        return new MyInteger(this.value + other.getValue());
    }
}

class Vector<T extends General & Summable<T>> extends General implements Summable<Vector<T>> {

    private final List<T> elements;

    public Vector(List<T> elements) {
        this.elements = elements;
    }

    public T get(int index) {
        return elements.get(index);
    }

    public int getSize() {
        return elements.size();
    }

    public Vector<T> sum(Vector<T> other) {
        if (this.getSize() != other.getSize()) {
            return null;
        }

        List<T> result = IntStream.range(0, elements.size())
                .mapToObj(i -> elements.get(i).sum(other.get(i)))
                .toList();

        return new Vector<>(result);
    }
}

public class Example {
    public static void main(String[] args) {
        //Проверим работу с векторами первого уровня
        Vector<MyInteger> v1 = new Vector<>(List.of(new MyInteger(1)));
        Vector<MyInteger> v2 = new Vector<>(List.of(new MyInteger(2)));

        Vector<MyInteger> sumVector = v1.sum(v2);
        System.out.println(sumVector.get(0).getValue());

        //Проверим работу с векторами второго уровня
        Vector<Vector<MyInteger>> vv1 = new Vector<>(List.of(v1));
        Vector<Vector<MyInteger>> vv2 = new Vector<>(List.of(v2));

        Vector<Vector<MyInteger>> sum2DVector = vv1.sum(vv2);
        System.out.println(sum2DVector.get(0).get(0).getValue());

        //Проверим работу с векторами третьего уровня
        Vector<Vector<Vector<MyInteger>>> vvv1 = new Vector<>(List.of(vv1));
        Vector<Vector<Vector<MyInteger>>> vvv2 = new Vector<>(List.of(vv2));

        Vector<Vector<Vector<MyInteger>>> sum3DVector = vvv1.sum(vvv2);
        System.out.println(sum3DVector.get(0).get(0).get(0).getValue());
    }
}
