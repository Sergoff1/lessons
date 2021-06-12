public class OrderedListTest {
    
    static boolean ascending = true;

    static String showNodeValues(OrderedList list){
        String nodeValues = "";
        Node node = list.head;
        while (node != null) {
            nodeValues += node.value + " ";
            node = node.next;
        }
        return nodeValues;
    }

    static OrderedList createEmptyList(){
        return new OrderedList(ascending);
    }

    static OrderedList createSingleNodeList(){
        OrderedList list = new OrderedList(ascending);
        list.add(1);
        return list;
    }

    static OrderedList createTwoNodeList(){
        OrderedList list = new OrderedList(ascending);
        list.add(1);
        list.add(5);
        return list;
    }

    static OrderedList createList(){
        OrderedList list = new OrderedList(ascending);
        list.add(2);
        list.add(6);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(9);
        list.add(8);
        return list;
    }

    static OrderedList createIdenticalNodeList(){
        OrderedList list = new OrderedList(ascending);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        return list;
    }



    static void deleteTest(){
        System.out.println("Удаление элемента из пустого списка: ");
        OrderedList emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + emptyList.count());
        emptyList.delete(1);
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + emptyList.count());

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из одного элемента: ");
        OrderedList singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + singleNodeList.count());
        singleNodeList.delete(1);
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + singleNodeList.count());
        System.out.println("head: " + singleNodeList.head + ", tail: " + singleNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из двух элементов: ");
        OrderedList twoNodeList = createTwoNodeList();
        System.out.println(showNodeValues(twoNodeList));
        System.out.println("count: " + twoNodeList.count());
        twoNodeList.delete(1);
        System.out.println(showNodeValues(twoNodeList));
        System.out.println("count: " + twoNodeList.count());
        System.out.println("head: " + twoNodeList.head + ", tail: " + twoNodeList.tail);
        System.out.println("prev: " +  twoNodeList.find(5).prev);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из элементов с одним значением: ");
        OrderedList identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("count: " + identicalNodeList.count());
        identicalNodeList.delete(1);
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("count: " + identicalNodeList.count());
        System.out.println("head: " + identicalNodeList.head + ", tail: " + identicalNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из нескольких элементов: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        list.delete(8);
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        System.out.println("head: " + list.head + ", tail: " + list.tail);
    }



    static void addTest(){

        System.out.println("Вставка узла в пустом списке: ");
        OrderedList emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + emptyList.count());
        emptyList.add(7);
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + emptyList.count());
        System.out.println("head: " + emptyList.head + ", tail: " + emptyList.tail);
        System.out.println("prev: " + emptyList.find(7).prev + ", next: " + emptyList.find(7).next);

        System.out.println("");

        System.out.println("Вставка узла в конец списка, состоящего из одного элемента: ");
        OrderedList singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + singleNodeList.count());
        singleNodeList.add(7);
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + singleNodeList.count());
        System.out.println("head: " + singleNodeList.head + ", tail: " + singleNodeList.tail);

        System.out.println("");

        System.out.println("Вставка узла в начало списка, состоящего из одного элемента: ");
        OrderedList singleNodeList1 = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList1));
        System.out.println("count: " + singleNodeList1.count());
        singleNodeList1.add(0);
        System.out.println(showNodeValues(singleNodeList1));
        System.out.println("count: " + singleNodeList1.count());
        System.out.println("head: " + singleNodeList1.head + ", tail: " + singleNodeList1.tail);

        System.out.println("");

        System.out.println("Вставка узла в списке, состоящем из нескольких элементов: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        list.add(7);
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
        System.out.println("prev for 7: " +  list.find(7).prev + ", next for 8: " + list.find(8).next);

        System.out.println("");

        System.out.println("Вставка узла в начало списка, состоящего из нескольких элементов: ");
        OrderedList list1 = createList();
        System.out.println(showNodeValues(list1));
        list1.add(0);
        System.out.println(showNodeValues(list1));
        System.out.println("head: " + list1.head + ", tail: " + list1.tail);

        System.out.println("");

        System.out.println("Вставка узла в конец списка, состоящего из нескольких элементов: ");
        OrderedList list2 = createList();
        System.out.println(showNodeValues(list2));
        list2.add(10);
        System.out.println(showNodeValues(list2));
        System.out.println("head: " + list2.head + ", tail: " + list2.tail);

    }

    static void clearTest() {
        System.out.println("Очистка списка: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        list.clear(false);
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
        System.out.println("count: " + list.count());
    }

    static void findTest() {
        System.out.println("Поиск элемента в списке: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        System.out.println(list.find(8));
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
        System.out.println("count: " + list.count());

        System.out.println("Поиск несуществующего элемента в списке: ");
        OrderedList list2 = createList();
        System.out.println(showNodeValues(list2));
        System.out.println("count: " + list2.count());
        System.out.println(list2.find(5));
        System.out.println(showNodeValues(list2));
        System.out.println("head: " + list2.head + ", tail: " + list2.tail);
        System.out.println("count: " + list2.count());
    }

    public static void main(String[] args) {
        deleteTest();
        System.out.println("");
        clearTest();
        System.out.println("");
        addTest();
        System.out.println("");
        findTest();

        OrderedList<String> list = new OrderedList(false);

        for (int i = 1; i < 10; i++) {
            list.add("a" + i);
        }
        System.out.println(showNodeValues(list));

    }
}
