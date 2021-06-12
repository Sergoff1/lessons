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
      // -1 если v1 < v2
      // 0 если v1 == v2
      // +1 если v1 > v2

      if (v1 instanceof String) {
        String str1 = ((String)v1).trim();
        String str2 = ((String)v2).trim();

        if (str1.compareTo(str2) == 0) {
          return 0;
        } else if (str1.compareTo(str2) > 0) {
          return 1;
        } else return -1;
      }

      if (v1 instanceof Integer) {
        return Integer.compare((int)v1, (int)v2);
      }

      return -100;
    }

    public void add(T value)
    {
        Node nodeToAdd = new Node(value);
        if (count == 0) {
          head = nodeToAdd;
          tail = nodeToAdd;
          count++;
          return;
        }

        
        if (_ascending) {

          if (compare(value, (T)head.value) <= 0) { // Вставка элемента в начало списка
            head.prev = nodeToAdd;
            nodeToAdd.next = head;
            head = nodeToAdd;
            count++;
            return;
          }

          if (compare(value, (T)tail.value) >= 0) { // Вставка элемента в конец списка
            tail.next = nodeToAdd;
            nodeToAdd.prev = tail;
            tail = nodeToAdd;
            count++;
            return;
          }

          Node firstNode = head;
          Node secondNode = head.next;
          while (secondNode != null) {  //Вставка элемента в середину списка
            if (compare(value, (T)firstNode.value) >= 0 && compare(value, (T)secondNode.value) <= 0) {
              firstNode.next = nodeToAdd;
              nodeToAdd.prev = firstNode;
              secondNode.prev = nodeToAdd;
              nodeToAdd.next = secondNode;
              break;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
          }
        } else {

          if (compare(value, (T)head.value) >= 0) { // Вставка элемента в начало списка
            head.prev = nodeToAdd;
            nodeToAdd.next = head;
            head = nodeToAdd;
            count++;
            return;
          }

          if (compare(value, (T)tail.value) <= 0) { // Вставка элемента в конец списка
            tail.next = nodeToAdd;
            nodeToAdd.prev = tail;
            tail = nodeToAdd;
            count++;
            return;
          }

          Node firstNode = head;
          Node secondNode = head.next;
          while (secondNode != null) {  //Вставка элемента в середину списка
            if (compare(value, (T)firstNode.value) <= 0 && compare(value, (T)secondNode.value) >= 0) {
              firstNode.next = nodeToAdd;
              nodeToAdd.prev = firstNode;
              secondNode.prev = nodeToAdd;
              nodeToAdd.next = secondNode;
              break;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
          }
        }

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
        if (node.value == val) {

          if (node == head) {
            head = node.next;

            if (head != null) head.prev = null;

            if(node == tail) {
              tail = node.prev;
            }
            count--;
            break;
          }

          if (node == tail) {
            tail = node.prev;
            tail.next = null;
            count--;
            break;
          }

          if (node.prev != null && node.next != null) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            count--;
            break;
          }
        }

        node = node.next;
      }
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
