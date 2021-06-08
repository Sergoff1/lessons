public class StackQueue<T>
{
    private int count;
    private Stack<T> receivingStack;
    private Stack<T> givingStack;

    public StackQueue()
    {
       receivingStack = new Stack<>();
       givingStack = new Stack<>();
       count = 0;
    } 

    public void enqueue(T item)
    {
        receivingStack.push(item);
        count++;
    }

    public T dequeue()
    {
        if (givingStack.size() == 0) {
        
            while (receivingStack.size() != 0) {
            givingStack.push(receivingStack.pop());
            }
        }
        
        if (givingStack.peek() != null) {
            count--;
        }

        return givingStack.pop();
    }

    public int size()
    {
        return count;
    }

    public String showQueue()
    {
        return "giving: " + givingStack.showStack() + "\nreceiving: " + receivingStack.showStack();
    }

}
