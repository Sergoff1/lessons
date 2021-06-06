public class QueueTest {

    static <T> void enqueueTest(Queue<T> qu, T item) {
        System.out.println(qu.showQueue());
        qu.enqueue(item);
        System.out.println(qu.showQueue());
        System.out.println("queue size: " + qu.size());
        System.out.println();
    }

    static <T> void dequeueTest(Queue<T> qu) {
        System.out.println(qu.showQueue());
        System.out.println(qu.dequeue() + " was removed");
        System.out.println(qu.showQueue());  
        System.out.println("queue size: " + qu.size());
        System.out.println();
    }

    
    public static void main(String[] args) {
        Queue<Integer> qu = new Queue<>();
        Queue<Integer> emptyQueue = new Queue<>();

        for (Integer i = 1; i <= 5; i++){
            qu.enqueue(i);
        }

        System.out.println("enqueue Test:");
        enqueueTest(qu, 88);
        System.out.println();
        System.out.println("dequeue Test:");
        dequeueTest(qu);
        dequeueTest(qu);
        dequeueTest(qu);
        System.out.println();
        System.out.println("dequeue Test with empty queue:");
        dequeueTest(emptyQueue);
        System.out.println();
        System.out.println("enqueue Test with empty queue:");
        enqueueTest(emptyQueue, 88);
    }
    
}
