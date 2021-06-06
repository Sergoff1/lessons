import java.util.*;

public class Queue<T>
{
    private int count;
    private LinkedList<T> queue;

    public Queue()
    {
       queue = new LinkedList<T>();
       count = 0;
    } 

    public void enqueue(T item)
    {
        queue.addFirst(item);
        count++;
    }

    public T dequeue()
    {
        if (queue.peekLast() != null) {
            count--;
        }
        return queue.pollLast();
    }

    public int size()
    {
        return count;
    }

    public String showQueue()
    {
        return queue.toString();
    }

}
