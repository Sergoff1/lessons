public class QueueTest {
    
    static <T> void rotateQueueOn(Queue<T> qu, int offset) {
        for (int i = 0; i < offset; i++){
        qu.enqueue(qu.dequeue);
        }
    }
    
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

        System.out.println();
        System.out.println("Rotate queue on 1:");
        rotateQueueOn(qu,1);
        System.out.println(qu.showQueue());

        System.out.println();
        System.out.println("Rotate queue on 2:");
        rotateQueueOn(qu,2);
        System.out.println(qu.showQueue());

        System.out.println();
        System.out.println("Rotate queue on 5:");
        rotateQueueOn(qu,5);
        System.out.println(qu.showQueue());
    }
    
}
