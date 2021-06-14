public class HashTableTest {

    public static void main(String[] args) {
        HashTable table = new HashTable(19, 3);
        table.put("банан");

        System.out.println("HashFun test: ");
        for (int i = 0; i < table.slots.length; i++)
        System.out.print(table.slots[i] + " ");
        System.out.println();
        System.out.println(table.hashFun("123"));
        System.out.println();

        System.out.println("seekSlot test: ");
        for (int i = 0; i < table.slots.length; i++)
        System.out.print(table.slots[i] + " ");
        System.out.println();
        System.out.println(table.seekSlot("банан"));
        System.out.println();

        System.out.println("put test: ");
        for (int i = 0; i < table.slots.length; i++)
        System.out.print(table.slots[i] + " ");
        System.out.println();
        /*for (int i = 0; i < table.size; i++)
        System.out.println(table.put("apple"));*/
        System.out.println(table.put("apple"));
        for (int i = 0; i < table.slots.length; i++)
        System.out.print(table.slots[i] + " ");
        System.out.println();
        System.out.println();

        System.out.println("find test: ");
        for (int i = 0; i < table.slots.length; i++)
        System.out.print(table.slots[i] + " ");
        System.out.println();
        System.out.println(table.find("123"));
        System.out.println();
    }
}
