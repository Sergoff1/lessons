public class StackTest {

    static <T> void pushTest(Stack<T> st, T item) {
        System.out.println(st.showStack());
        st.push(item);
        System.out.println(st.showStack());
        System.out.println("stack size: " + st.size());
        System.out.println();
    }

    static <T> void popTest(Stack<T> st) {
        System.out.println(st.showStack());
        System.out.println(st.pop() + " was removed");
        System.out.println(st.showStack());  
        System.out.println("stack size: " + st.size());
        System.out.println();
    }

    static <T> void peekTest(Stack<T> st) {
        System.out.println(st.showStack());
        System.out.println(st.peek());
        System.out.println(st.showStack());
        System.out.println("stack size: " + st.size());
        System.out.println();
    }
    
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> emptyStack = new Stack<>();

        for (Integer i = 1; i <= 5; i++){
            st.push(i);
        }

        System.out.println("Push Test:");
        pushTest(st, 88);
        System.out.println();
        System.out.println("Pop Test:");
        popTest(st);
        popTest(st);
        popTest(st);
        System.out.println();
        System.out.println("Peek Test:");
        peekTest(st);
        System.out.println();
        System.out.println("Pop Test with empty stack:");
        popTest(emptyStack);
        System.out.println();
        System.out.println("Peek Test with empty stack:");
        peekTest(emptyStack);
        System.out.println();
        System.out.println("Push Test with empty stack:");
        pushTest(emptyStack, 88);
    }
}
