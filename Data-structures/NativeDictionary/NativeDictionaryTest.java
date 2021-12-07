public class NativeDictionaryTest {
    public static void main(String[] args) {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(11, Integer.class);
        dictionary.put("a", 1);
        dictionary.put("b", 2);
        dictionary.put("c", 3);
        dictionary.put("d", 4);
        dictionary.put("e", 5);
        dictionary.put("f", 6);
        dictionary.put("g", 7);
        dictionary.put("h", 8);
        dictionary.put("i", 9);
        dictionary.put("j", 10);
        dictionary.put("jik", 33);

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
        System.out.println();*/

        System.out.println("get test: ");
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < dictionary.slots.length; i++)
        System.out.print(dictionary.values[i] + " ");
        System.out.println();
        System.out.println();
        System.out.println(dictionary.get("a"));
        System.out.println(dictionary.get("b"));
        System.out.println(dictionary.get("c"));
        System.out.println(dictionary.get("d"));
        System.out.println(dictionary.get("e"));
        System.out.println(dictionary.get("f"));
        System.out.println(dictionary.get("g"));
        System.out.println(dictionary.get("h"));
        System.out.println(dictionary.get("i"));
        System.out.println(dictionary.get("j"));
        System.out.println(dictionary.get("jik"));
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
