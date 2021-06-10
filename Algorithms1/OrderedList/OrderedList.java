import java.util.*;


 class Node<T>
  {
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
      value = _value;
      next = null;
      prev = null;
    }

    @Override
    public String toString() {
        return value + "";
    }
  }

 public class OrderedList<T>
  {
    public Node<T> head, tail;
    private boolean _ascending;
    private int count;

    public OrderedList(boolean asc)
    {
      head = null;
      tail = null;
      _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
      return v1.compareTo(v2);
      // -1 если v1 < v2
      // 0 если v1 == v2
      // +1 если v1 > v2
    }

    public void add(T value)
    {
        // автоматическая вставка value 
        // в нужную позицию
        count++;
    }

    public Node<T> find(T val)
    {
        Node node = this.head;
        while (node != null) {
          if (node.value == val) {
            return node;
          } else if (_ascending) {
            if(compare((T)node.value, val) == 1) break;
          } else if (compare((T)node.value, val) == -1) break; 
              
          node = node.next;
        }
        return null;
    }

    public void delete(T val)
    {
        Node node = head;
        while (node != null) {
        if (node.value == _value) {

          if (node == head) {
            head = node.next;

            if (head != null) head.prev = null;

            if(node == tail) {
              tail = node.prev;
            }
            break;
          }

          if (node == tail) {
            tail = node.prev;
            tail.next = null;
            break;
          }

          if (node.prev != null && node.next != null) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            break;
          }
        }

        node = node.next;
      }
        count--;
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
        count = 0;
    }

    public int count()
    {
       return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного 
                           // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
  }