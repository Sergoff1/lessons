import java.util.*;

public class Queue<T>
{
    private int count;
    private List<T> queue;

    public Queue()
    {
       queue = new ArrayList<T>();
       count = 0;
    } 

    public void enqueue(T item)
    {
        queue.add(0,item);
        count++;
    }

    public T dequeue()
    {
        if (count > 0) {
            count--;
            T firstElement = queue.get(count);
            queue.remove(count);
            return firstElement;
        } else return null;
    }

    public int size()
    {
        return count;
    }

    public String showQueue()
    {
        return queue.toString();
    }

    public void rotateQueueOn(int offset) 
    {
        if (offset > count) {
            offset %= count;
        }

        List<T> bufferList = new ArrayList<>();
        bufferList = queue.subList(0, count - offset);
        queue = queue.subList(count-offset, count);
        queue.addAll(bufferList);
    }

}
