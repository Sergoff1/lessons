public class DLLTest {
    
    static String showNodeValues(LinkedList2 list){
        String nodeValues = "";
        Node node = list.head;
        while (node != null) {
            nodeValues += node.value + " ";
            node = node.next;
        }
        return nodeValues;
    }

    static LinkedList2 createEmptyList(){
        return new LinkedList2();
    }

    static LinkedList2 createSingleNodeList(){
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        return list;
    }

    static LinkedList2 createTwoNodeList(){
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(5));
        return list;
    }

    static LinkedList2 createList(){
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));
        list.addInTail(new Node(1));
        list.addInTail(new Node(4));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(8));
        return list;
    }

    static LinkedList2 createIdenticalNodeList(){
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        return list;
    }



    static void removeTest(){
        System.out.println("Удаление элемента из пустого списка: ");
        LinkedList2 emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        emptyList.remove(1);
        System.out.println(showNodeValues(emptyList));

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из одного элемента: ");
        LinkedList2 singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        singleNodeList.remove(1);
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("head: " + singleNodeList.head + ", tail: " + singleNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из двух элементов: ");
        LinkedList2 twoNodeList = createTwoNodeList();
        System.out.println(showNodeValues(twoNodeList));
        twoNodeList.remove(1);
        System.out.println(showNodeValues(twoNodeList));
        System.out.println("head: " + twoNodeList.head + ", tail: " + twoNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из элементов с одним значением: ");
        LinkedList2 identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        identicalNodeList.remove(1);
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("head: " + identicalNodeList.head + ", tail: " + identicalNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из нескольких элементов: ");
        LinkedList2 list = createList();
        System.out.println(showNodeValues(list));
        list.remove(8);
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
    }



    static void removeAllTest(){
        System.out.println("Удаление одинаковых элементов из пустого списка: ");
        LinkedList2 emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        emptyList.removeAll(1);
        System.out.println(showNodeValues(emptyList));

        System.out.println("");

        System.out.println("Удаление одинаковых элементов из списка, состоящего из одного элемента: ");
        LinkedList2 singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        singleNodeList.removeAll(1);
        System.out.println(showNodeValues(singleNodeList));
        System.out.println("head: " + singleNodeList.head + ", tail: " + singleNodeList.tail);

        System.out.println("");

        System.out.println("Удаление элемента из списка, состоящего из двух элементов: ");
        LinkedList2 twoNodeList = createTwoNodeList();
        System.out.println(showNodeValues(twoNodeList));
        twoNodeList.removeAll(5);
        System.out.println(showNodeValues(twoNodeList));
        System.out.println("head: " + twoNodeList.head + ", tail: " + twoNodeList.tail);

        System.out.println("");

        System.out.println("Удаление одинаковых элементов из списка, состоящего из элементов с одним значением: ");
        LinkedList2 identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        identicalNodeList.removeAll(1);
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println("head: " + identicalNodeList.head + ", tail: " + identicalNodeList.tail);

        System.out.println("");

        System.out.println("Удаление одинаковых элементов из списка, состоящего из нескольких элементов: ");
        LinkedList2 list = createList();
        System.out.println(showNodeValues(list));
        list.removeAll(1);
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
    }



    static void findAllTest(){
        System.out.println("Поиск всех элементов с заданным значением в пустом списке: ");
        LinkedList2 emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        System.out.println(emptyList.findAll(1));

        System.out.println("");

        System.out.println("Поиск всех элементов с заданным значением в списке, состоящем из одного элемента: ");
        LinkedList2 singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        System.out.println(singleNodeList.findAll(1));

        System.out.println("");

        System.out.println("Поиск всех элементов с заданным значением в списке, значения элементов которого одинаковы: ");
        LinkedList2 identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println(identicalNodeList.findAll(1));

        System.out.println("");

        System.out.println("Поиск всех элементов с заданным значением в обычном списке: ");
        LinkedList2 list = createList();
        System.out.println(showNodeValues(list));
        System.out.println(list.findAll(1));
        System.out.println("head: " + list.head + ", tail: " + list.tail);

    }



    static void clearTest(){
        System.out.println("Удаление всех элементов из пустого списка: ");
        LinkedList2 emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        emptyList.clear();
        System.out.println(showNodeValues(emptyList));

        System.out.println("");

        System.out.println("Удаление всех элементов из списка, состоящего из одного элемента: ");
        LinkedList2 singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        singleNodeList.clear();
        System.out.println(showNodeValues(singleNodeList));

        System.out.println("");

        System.out.println("Удаление всех элементов из списка, состоящего из элементов с одним значением: ");
        LinkedList2 identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        identicalNodeList.clear();
        System.out.println(showNodeValues(identicalNodeList));

        System.out.println("");

        System.out.println("Удаление всех элементов из списка, состоящего из нескольких элементов: ");
        LinkedList2 list = createList();
        System.out.println(showNodeValues(list));
        list.clear();
        System.out.println(showNodeValues(list));
    }



    static void countTest(){
        System.out.println("Подсчёт длины пустого списка: ");
        LinkedList2 emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        System.out.println(emptyList.count());

        System.out.println("");

        System.out.println("Подсчёт длины списка, состоящего из одного элемента: ");
        LinkedList2 singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        System.out.println(singleNodeList.count());

        System.out.println("");

        System.out.println("Подсчёт длины списка, значения элементов которого одинаковы: ");
        LinkedList2 identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        System.out.println(identicalNodeList.count());

        System.out.println("");

        System.out.println("Подсчёт длины обычного списка: ");
        LinkedList2 list = createList();
        System.out.println(showNodeValues(list));
        System.out.println(list.count());

    }



    static void insertAfterTest(){
        Node nodeToInsert = new Node(7);

        System.out.println("Вставка узла после заданного узла в пустом списке: ");
        LinkedList2 emptyList = createEmptyList();
        System.out.println(showNodeValues(emptyList));
        emptyList.insertAfter(null, nodeToInsert);
        System.out.println(showNodeValues(emptyList));

        System.out.println("");

        System.out.println("Вставка узла после заданного узла в списке, состоящем из одного элемента: ");
        LinkedList2 singleNodeList = createSingleNodeList();
        System.out.println(showNodeValues(singleNodeList));
        singleNodeList.insertAfter(singleNodeList.find(1),nodeToInsert);
        System.out.println(showNodeValues(singleNodeList));

        System.out.println("");

        System.out.println("Вставка узла после первого узла в списке, состоящем из элементов с одним значением: ");
        LinkedList2 identicalNodeList = createIdenticalNodeList();
        System.out.println(showNodeValues(identicalNodeList));
        identicalNodeList.insertAfter(identicalNodeList.find(1), nodeToInsert);
        System.out.println(showNodeValues(identicalNodeList));

        System.out.println("");

        System.out.println("Вставка узла после заданного узла в списке, состоящем из элементов с одним значением: ");
        LinkedList2 identicNodeList = createIdenticalNodeList();
        Node n = new Node(1);
        identicNodeList.addInTail(n);
        identicNodeList.addInTail(new Node(1));
        identicNodeList.addInTail(new Node(1));
        System.out.println(showNodeValues(identicNodeList));
        identicNodeList.insertAfter(n, nodeToInsert);
        System.out.println(showNodeValues(identicNodeList));

        System.out.println("");

        System.out.println("Вставка узла после заданного узла в списке, состоящем из нескольких элементов: ");
        LinkedList2 list = createList();
        System.out.println(showNodeValues(list));
        list.insertAfter(list.find(8), nodeToInsert);
        System.out.println(showNodeValues(list));
        System.out.println("head: " + list.head + ", tail: " + list.tail);
        System.out.println("prev: " +  list.find(7).prev + ", count: " + list.count());

        System.out.println("");

        System.out.println("Вставка узла в начало списка, состоящего из нескольких элементов: ");
        LinkedList2 testList = createList();
        System.out.println(showNodeValues(testList));
        testList.insertAfter(null, nodeToInsert);
        System.out.println(showNodeValues(testList));
        System.out.println("head: " + testList.head + ", tail: " + testList.tail);
        System.out.println("prev: " + testList.find(2).prev);
    }

    public static void main(String[] args) {
        removeTest();
        System.out.println("");
        removeAllTest();
        System.out.println("");
        findAllTest();
        System.out.println("");
        clearTest();
        System.out.println("");
        countTest();
        System.out.println("");
        insertAfterTest();
    }
}
