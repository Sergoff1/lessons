import java.util.*;

public class Deque<T>
{
    private int count;
    private LinkedList<T> deque;

    public Deque()
    {
        deque = new LinkedList<>();
        count = 0;
    }

    public void addFront(T item)
    {
        deque.addFirst(item);
        count++;
    }

    public void addTail(T item)
    {
        deque.addLast(item);
        count++;
    }

    public T removeFront()
    {
        if (count > 0) count--;
        return deque.pollFirst();
    }

    public T removeTail()
    {
        if (count > 0) count--;
        return deque.pollLast();
    }
        
    public int size()
    {
        return count;
    }

    public String showDeque()
    {
        return deque.toString();
    }
}
