import java.util.*;

public class LinkedList2
{
     public Node head;
     public Node tail;

     public LinkedList2()
     {
       head = null;
       tail = null;
     }

     public void addInTail(Node _item)
     {
       if (head == null) {
        this.head = _item;
        this.head.next = null;
        this.head.prev = null;
       } else {
        this.tail.next = _item;
        _item.prev = tail;
       }
       this.tail = _item;
     }

     public Node find(int _value)
     {
        Node node = this.head;
        while (node != null) {
          if (node.value == _value)
              return node;
          node = node.next;
        }
       return null;
     }

     public ArrayList<Node> findAll(int _value)
     {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
          if (node.value == _value)
              nodes.add(node);
          node = node.next;
        }
        return nodes;
     }

     public boolean remove(int _value)
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

              return true;
            }

            if (node == tail) {
              tail = node.prev;
              tail.next = null;
              return true;
            }

            node.next.prev = node.prev;
            node.prev.next = node.next;
            return true;
          }

          node = node.next;
        }
        return false; // если узел не был удалён
     }

     public void removeAll(int _value)
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
            }

            if (node == tail) {
              tail = node.prev;
              tail.next = null;
            }

            if (node.prev != null && node.next != null) {
              node.next.prev = node.prev;
              node.prev.next = node.next;
            }
          }

          node = node.next;
        }
     }

     public void clear()
     {
        head = null;
        tail = null;
     }

     public int count()
     {
        int nodesCount = 0;
        Node node = this.head;
        while (node != null) {
            nodesCount++;
            node = node.next;
        }
        return nodesCount;
     }

     public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
     {
        if (_nodeAfter == null) {
          _nodeToInsert.next = head;

          if (head != null) {
            head.prev = _nodeToInsert;
          }
          
          head = _nodeToInsert;

          if (head.next == null){
            tail = _nodeToInsert;
          }

        } else if (_nodeAfter.next == null) {
          _nodeAfter.next = _nodeToInsert;
          _nodeToInsert.prev = _nodeAfter;
          tail = _nodeToInsert;
        } else {
          _nodeToInsert.next = _nodeAfter.next;
          _nodeToInsert.prev = _nodeAfter;
          _nodeAfter.next.prev = _nodeToInsert;
          _nodeAfter.next = _nodeToInsert;
        }
     }
}

class Node
{
     public int value;
     public Node next;
     public Node prev;

     public Node(int _value) 
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