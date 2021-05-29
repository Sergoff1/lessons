import java.util.*;

public class DummyNodeLinkedList
{
    private Nodes dummyHead;
    private Nodes dummyTail;
    private int nodesCount;

    public DummyNodeLinkedList()
    {
       dummyHead = new Nodes();
       dummyTail = new Nodes();

       dummyHead.next = dummyTail;
       dummyTail.prev = dummyHead;

       nodesCount = 0;
    }

    public void addInTail(Nodes _item)
    {
      dummyTail.prev.next = _item;
      _item.prev = dummyTail.prev;
      dummyTail.prev = _item;
      _item.next = dummyTail;

      nodesCount++;
    }

    public Nodes find(int _value)
    {
      Nodes node = this.dummyHead.next;
      while (node != dummyTail) {

        if (node.value == _value) {
            return node;
        }

        node = node.next;
      }
       return null;
    }

    public ArrayList<Nodes> findAll(int _value)
    {
       ArrayList<Nodes> nodes = new ArrayList<Nodes>();
       Nodes node = this.dummyHead.next;
       while (node != dummyTail) {

         if (node.value == _value){
             nodes.add(node);
         }

         node = node.next;
       }
       return nodes;
    }

    public boolean remove(int _value)
    {
      Nodes node = dummyHead.next;
      while (node != dummyTail) {

        if (node.value == _value) {
          node.next.prev = node.prev;
          node.prev.next = node.next;
          nodesCount--;
          return true;
        }

        node = node.next;
      }
      return false; // если узел не был удалён
    }

    public void removeAll(int _value)
    {
      Nodes node = dummyHead.next;
      while (node != dummyTail) {

        if (node.value == _value) {
          node.next.prev = node.prev;
          node.prev.next = node.next;
          nodesCount--;
        }

        node = node.next;
      }
    }

    public void clear()
    {
      dummyHead.next = dummyTail;
      dummyTail.prev = dummyHead;

      nodesCount = 0;
    }

    public int count()
    {
      return nodesCount;
    }

    public void insertAfter(Nodes _nodeAfter, Nodes _nodeToInsert)
    {
       if (_nodeAfter == null) {
        _nodeToInsert.next = dummyHead.next;
        dummyHead.next.prev = _nodeToInsert;
        dummyHead.next = _nodeToInsert;
        _nodeToInsert.prev = dummyHead;
       } else {
        _nodeToInsert.next = _nodeAfter.next;
        _nodeToInsert.prev = _nodeAfter;
        _nodeAfter.next.prev = _nodeToInsert;
        _nodeAfter.next = _nodeToInsert;
       }
       nodesCount++;
    }
}



class Nodes
{
    public int value;
    public Nodes next;
    public Nodes prev;

    public Nodes(int _value) 
    { 
       value = _value; 
       next = null;
       prev = null;
    }

    public Nodes() 
    {  
       next = null;
       prev = null;
    }
}