public class AdditionalTask {

    static LinkedList listValuesSum(LinkedList firstList, LinkedList secondList) {
        LinkedList SumValuesList = new LinkedList();

        if (firstList.count() == secondList.count()) {
            Node firstNode = firstList.head;
            Node secondNode = secondList.head;

            while (firstNode != null) {
                SumValuesList.addInTail(new Node(firstNode.value + secondNode.value));
                firstNode = firstNode.next;
                secondNode = secondNode.next;
            }

        } else {
            System.out.println("Списки не совпадают по размеру. Возвращён пустой список.");
        }

        return SumValuesList;
    }

}