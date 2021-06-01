public class DynArrayTest {

    static <T> void showArray (DynArray<T> list) {
        for (int i = 0; i < list.array.length; i++) {
            System.out.print(" " + list.array[i]);
        }
    }

    static <T> void insertTest (DynArray<T> list, T itm, int index) {
        showArray(list);
        System.out.println();
        System.out.println("Capacity: " + list.capacity + ", count: " + list.count);
        System.out.println();
        list.insert(itm, index);
        showArray(list);
        System.out.println();
        System.out.println("Capacity: " + list.capacity + ", count: " + list.count);
    }

    static <T> void removeTest (DynArray<T> list, int index) {
        showArray(list);
        System.out.println();
        System.out.println("Capacity: " + list.capacity + ", count: " + list.count);
        System.out.println();
        list.remove(index);
        showArray(list);
        System.out.println();
        System.out.println("Capacity: " + list.capacity + ", count: " + list.count);
    }

    public static void main(String[] args) {
        final int index = 3;
        final Integer itm = 88;

        DynArray <Integer> smallList = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 8; i++) {
            smallList.append(i);
        }

        DynArray <Integer> largeList = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) {
            largeList.append(i);
        }


        System.out.println("Вставка элемента без превышения размера буфера: ");
        insertTest(smallList, itm, index);
        System.out.println();
        System.out.println("Вставка элемента с превышением размера буфера: ");
        insertTest(largeList, itm, index);
        System.out.println();
        System.out.println("Вставка элемента в недопустимую позицию: ");
        insertTest(smallList, itm, 34);
        System.out.println();
        System.out.println("Вставка элемента в хвост: ");
        insertTest(smallList, itm, smallList.count);
        System.out.println();

        System.out.println("Удаление элемента без уменьшения размера буфера: ");
        removeTest(smallList, index);
        System.out.println();
        System.out.println("Удаление элемента с уменьшением размера буфера: ");
        largeList.remove(largeList.count-1);
        removeTest(largeList, index);
        System.out.println();
        System.out.println("Удаление элемента из недопустимой позиции: ");
        removeTest(smallList, 34);
        System.out.println();
        System.out.println("Попытка получить элемент вне массива: ");
        System.out.println(smallList.getItem(34));
        System.out.println();
        System.out.println("Попытка получить элемент: ");
        System.out.println(smallList.getItem(index));
    }
}
