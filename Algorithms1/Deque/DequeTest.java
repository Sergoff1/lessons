public class DequeTest {
    
    static <T> void addFrontTest(Deque<T> deq, T item) {
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());
        deq.addFront(item);
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());
    }

    static <T> void addTailTest(Deque<T> deq, T item) {
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());
        deq.addTail(item);
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());

    }

    static <T> void removeFrontTest(Deque<T> deq) {
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());
        deq.removeFront();
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());
    }

    static <T> void removeTailTest(Deque<T> deq) {
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());
        deq.removeTail();
        System.out.println(deq.showDeque());
        System.out.println("Deque size: " + deq.size());
    }

    public static void main(String[] args) {
        final Integer item = 88;
        Deque<Integer> deq = new Deque<>();
        Deque<Integer> emptyDeq = new Deque<>();

        for (int i = 0; i < 6; i++) {
            deq.addFront(i);
        }

        System.out.println("addFront Test: ");
        addFrontTest(deq, item);
        System.out.println();

        System.out.println("addTail Test: ");
        addTailTest(deq, item);
        System.out.println();

        System.out.println("removeFront Test: ");
        removeFrontTest(deq);
        System.out.println();
        
        System.out.println("removeTail Test: ");
        removeTailTest(deq);
        System.out.println();

        System.out.println("removeTail Test from empty deque: ");
        removeTailTest(emptyDeq);
        System.out.println();

        System.out.println("removeFront Test from empty deque: ");
        removeFrontTest(emptyDeq);
        System.out.println();

        System.out.println(PalindromeDetector.checkForPalindrome("А роза упала на лапу азора"));
    }
}
