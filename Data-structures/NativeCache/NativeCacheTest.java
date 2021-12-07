public class NativeCacheTest {
    public static void main(String[] args) {
        NativeCache<Integer> cache = new NativeCache<>(10, Integer.class);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);
        cache.put("e", 5);
        cache.put("f", 6);
        cache.put("g", 7);
        cache.put("h", 8);
        cache.put("i", 9);
        cache.put("j", 10);


        System.out.println("isKey test: ");
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.values[i] + " ");
        System.out.println();
        System.out.println("a - " + cache.isKey("a"));
        System.out.println();
        System.out.println("z - " + cache.isKey("z"));
        System.out.println();

        System.out.println("get test: ");
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.values[i] + " ");
        System.out.println();
        System.out.println();
        System.out.println(cache.get("b"));
        System.out.println(cache.get("c"));
        System.out.println(cache.get("d"));
        System.out.println(cache.get("e"));
        System.out.println(cache.get("f"));
        System.out.println(cache.get("g"));
        System.out.println(cache.get("h"));
        System.out.println(cache.get("i"));
        System.out.println(cache.get("j"));
        System.out.println(cache.get("z"));
        System.out.println();
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.values[i] + " ");
        System.out.println();
        System.out.println();


        System.out.println("put test: ");
        System.out.print("Keys: ");
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.slots[i] + " ");
        System.out.println();
        System.out.print("values: ");
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.values[i] + " ");
        System.out.println();
        cache.get("d");
        System.out.print("hits: ");
        for (int i = 0; i < cache.hits.length; i++)
        System.out.print(cache.hits[i] + " ");
        System.out.println();
        cache.put("c", 8);
        cache.put("a", 9);
        cache.put("z", 8);
        cache.put("newKey", 100);
        cache.get("newKey");
        
        cache.put("anotherKey", 200);
        System.out.println();
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.slots[i] + " ");
        System.out.println();
        for (int i = 0; i < cache.slots.length; i++)
        System.out.print(cache.values[i] + " ");
        System.out.println();
        System.out.println();
    }
}
