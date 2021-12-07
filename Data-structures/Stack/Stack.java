import java.util.*;

public class Stack<T>
{
    private int count;
    private LinkedList<T> stack;

      public Stack()
      {
       stack = new LinkedList<T>();
       count = 0;
      } 

      public int size() 
      {	  
       return count;
      }

      public T pop()
      {
       if (stack.peekLast() != null) {
         count--;
       }
       return stack.pollLast();
      }
	  
      public void push(T val)
      {
       stack.addLast(val);
       count++;
      }

      public T peek()
      {
       return stack.peekLast();
      }

      public String showStack(){
        return stack.toString();
      }
}