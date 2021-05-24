import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
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
        Node node = this.head;
        Node nodeToDelete = null;
        while (node != null) {
            if (node.value == _value) {
                nodeToDelete = node;
                break;
            }
            node = node.next;
        }

        node = head;
        
        while (node != null) {
            if (node.next == nodeToDelete) {
                node.next = nodeToDelete.next;
                return true;
            }
            node = node.next;
        }

        return false; // если узел не был удалён
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        ArrayList<Node> nodesToDelete = new ArrayList<Node>();
        while (node != null) {
            if (node.value == _value) {
                nodesToDelete.add(node);
            }
            node = node.next;
        }

        node = head;
        int i = 0;
        while (node != null) {
            if (node.next == nodesToDelete.get(i)) {
                node.next = nodesToDelete.get(i).next;
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
            head = _nodeToInsert;

        } else {                           //Нужен ли поиск по значению?
            Node node = this.head;
            while (node != null) {
                if (node.value == _nodeAfter){
                    _nodeToInsert.next = _nodeAfter.next;
                    _nodeAfter.next = _nodeToInsert;
                    break;
                }
                node = node.next;
            }
       } 
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value) 
    {  
        value = _value;
        next = null;
    }

    @Override
    public String toString() {
        return value + "";
    }
}