public class NativeDictionaryTest {
    public static void main(String[] args) {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        dictionary.put("b", 1);
        dictionary.put("a", 2);
        dictionary.put("c", 3);
        dictionary.put("d", 4);
        dictionary.put("e", 5);

        System.out.println("put test: ");
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.values[i] + " ");
        System.out.println();
        dictionary.put("c", 8);
        dictionary.put("a", 9);
        dictionary.put("z", 8);
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.values[i] + " ");
        System.out.println();
        System.out.println();

        System.out.println("isKey test: ");
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.values[i] + " ");
        System.out.println();
        System.out.println(dictionary.isKey("a"));
        System.out.println();
        System.out.println(dictionary.isKey("z"));
        System.out.println();

        System.out.println("get test: ");
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.values[i] + " ");
        System.out.println();
        System.out.println(dictionary.get("a"));
        System.out.println();
        System.out.println(dictionary.get("z"));
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.values[i] + " ");
        System.out.println();

    }
}
