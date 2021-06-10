public class OrderedListTest {

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
        return new OrderedList();
    }

    static OrderedList createSingleNodeList(){
        OrderedList list = new OrderedList();
        list.add(new Node(1));
        return list;
    }

    static OrderedList createTwoNodeList(){
        OrderedList list = new OrderedList();
        list.add(new Node(1));
        list.add(new Node(5));
        return list;
    }

    static OrderedList createList(){
        OrderedList list = new OrderedList();
        list.add(new Node(2));
        list.add(new Node(9));
        list.add(new Node(3));
        list.add(new Node(1));
        list.add(new Node(4));
        list.add(new Node(1));
        list.add(new Node(9));
        list.add(new Node(8));
        return list;
    }

    static OrderedList createIdenticalNodeList(){
        OrderedList list = new OrderedList();
        list.add(new Node(1));
        list.add(new Node(1));
        list.add(new Node(1));
        list.add(new Node(1));
        return list;
    }



    static void removeTest(){
        System.out.println("Удаление элемента из пустого списка: ");
        OrderedList emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + list.count());
        emptyList.remove(1);
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + list.count());

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из одного элемента: ");
        OrderedList singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + list.count());
        singleNodeList.remove(1);
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + list.count());
        System.out.println("head: " + singleNodeList.head + ", tail: " + singleNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из двух элементов: ");
        OrderedList twoNodeList = createTwoNodeList();
        System.out.println(showNodeValues(twoNodeList));
        System.out.println("count: " + list.count());
        twoNodeList.remove(1);
        System.out.println(showNodeValues(twoNodeList));
        System.out.println("count: " + list.count());
        System.out.println("head: " + twoNodeList.head + ", tail: " + twoNodeList.tail);
        System.out.println("prev: " +  twoNodeList.find(5).prev);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из элементов с одним значением: ");
        OrderedList identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("count: " + list.count());
        identicalNodeList.remove(1);
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("count: " + list.count());
        System.out.println("head: " + identicalNodeList.head + ", tail: " + identicalNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из нескольких элементов: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        list.remove(8);
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        System.out.println("head: " + list.head + ", tail: " + list.tail);
    }



    static void addTest(){
        Node nodeToInsert = new Node(7);

        System.out.println("Вставка узла в пустом списке: ");
        OrderedList emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + list.count());
        emptyList.add(nodeToInsert);
        System.out.println(showNodeValues(emptyList));
        System.out.println("count: " + list.count());
        System.out.println("head: " + emptyList.head + ", tail: " + emptyList.tail);
        System.out.println("prev: " + emptyList.find(7).prev + ", next: " + emptyList.find(7).next);

        System.out.println("");

        System.out.println("Вставка узла в списке, состоящем из одного элемента: ");
        OrderedList singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + list.count());
        singleNodeList.add(nodeToInsert);
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("count: " + list.count());
        System.out.println("head: " + singleNodeList.head + ", tail: " + singleNodeList.tail);
        System.out.println("prev: " + singleNodeList.find(7).prev + ", next: " + singleNodeList.find(7).next);

        System.out.println("");

        System.out.println("Вставка узла в списке, состоящем из элементов с одним значением: ");
        OrderedList identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("count: " + list.count());
        identicalNodeList.add(nodeToInsert);
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("count: " + list.count());
        System.out.println("head: " + identicalNodeList.head + ", tail: " + identicalNodeList.tail);
        System.out.println("prev: " + identicalNodeList.find(7).prev + ", next: " + identicalNodeList.find(7).next);

        System.out.println("");

        System.out.println("Вставка узла в списке, состоящем из элементов с одним значением: ");
        OrderedList identicNodeList = createIdenticalNodeList();
        Node n = new Node(1);
        identicNodeList.add(n);
        identicNodeList.add(new Node(1));
        identicNodeList.add(new Node(1));
        System.out.println(showNodeValues(identicNodeList));
        System.out.println("count: " + list.count());
        identicNodeList.add(new Node(7));
        System.out.println(showNodeValues(identicNodeList));
        System.out.println("count: " + list.count());
        System.out.println("head: " + identicNodeList.head + ", tail: " + identicNodeList.tail);
        System.out.println("prev: " + identicNodeList.find(7).prev + ", next: " + identicNodeList.find(7).next);

        System.out.println("");

        System.out.println("Вставка узла в списке, состоящем из нескольких элементов: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        list.add(new Node(7));
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
        System.out.println("prev for 7: " +  list.find(7).prev + ", next for 8: " + list.find(8).next);

        System.out.println("");

    }

    static void clearTest() {
        System.out.println("Очистка списка: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        list.clear(true);
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
        System.out.println("count: " + list.count());
    }

    static void findTest() {
        System.out.println("Поиск элемента в списке: ");
        OrderedList list = createList();
        System.out.println(showNodeValues(list));
        System.out.println("count: " + list.count());
        list.find(8);
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
        System.out.println("count: " + list.count());

        System.out.println("Поиск несуществующего элемента в списке: ");
        OrderedList list2 = createList();
        System.out.println(showNodeValues(list2));
        System.out.println("count: " + list2.count());
        list2.find(5);
        System.out.println(showNodeValues(list2));
        System.out.println("head: " + list2.head + ", tail: " + list2.tail);
        System.out.println("count: " + list2.count());
    }

    public static void main(String[] args) {
        removeTest();
        System.out.println("");
        clearTest();
        System.out.println("");
        addTest();
        System.out.println("");
        findTest();
    }
}
