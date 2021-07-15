import java.io.*;
import java.util.*;


class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок	
	
    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }

    @Override
    public String toString() {
        return NodeKey + " ";
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;
	
    // true если узел найден
    public boolean NodeHasKey;
	
    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;
	
    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null
    private int count;
	
    public BST(BSTNode<T> node)
    {
	      Root = node;
    }

    public List<BSTNode<T>> GetAllNodes(BSTNode<T> node)
    {
      if (Root == null) return null;
      List<BSTNode<T>> nodeList = new ArrayList<BSTNode<T>>();
      if (node.LeftChild == null && node.RightChild == null)
      {
        nodeList.add(node);
        return nodeList;
      }
      nodeList.add(node);
      if (node.LeftChild != null)
      {
        nodeList.addAll(GetAllNodes(node.LeftChild));
      }
      if (node.RightChild != null)
      {
        nodeList.addAll(GetAllNodes(node.RightChild));
      }
      return nodeList;
    }

    private BSTFind<T> FindNode(BSTNode<T> node, int key)
    {
        BSTFind<T> foundNode = new BSTFind<T>();

          if (Root == null) return null;

          if (node.NodeKey == key)
          {
              foundNode.Node = node;
              foundNode.NodeHasKey = true;
              return foundNode;
          } else if (node.NodeKey > key) 
          {
              if (node.LeftChild == null)
              {
                foundNode.Node = node;
                foundNode.ToLeft = true;
                return foundNode;
              }
              foundNode = FindNode(node.LeftChild, key);
          } else
          {
              if (node.RightChild == null)
              {
                 foundNode.Node = node;
                 return foundNode;
              }
              foundNode = FindNode(node.RightChild, key);
          }

        return foundNode;
    }
	
    public BSTFind<T> FindNodeByKey(int key)
    {
        // ищем в дереве узел и сопутствующую информацию по ключу
        if (Root == null) return new BSTFind<T>();
        return FindNode(Root, key);
    }
	
    public boolean AddKeyValue(int key, T val)
    {
          // добавляем ключ-значение в дерево
          BSTFind<T> foundNode = FindNode(Root, key);

          if (foundNode == null)
          {
            Root = new BSTNode<T>(key, val, null);
            return true;
          } 

          if (foundNode.Node == null)
          {
            Root = new BSTNode<T>(key, val, null);
          } else if (foundNode.NodeHasKey) return false; // если ключ уже есть

          if (foundNode.ToLeft) 
            foundNode.Node.LeftChild = new BSTNode<T>(key, val, foundNode.Node);
          else foundNode.Node.RightChild = new BSTNode<T>(key, val, foundNode.Node);

          return true;
    }
	
    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        // ищем максимальный/минимальный ключ в поддереве
        BSTNode<T> node = FromNode;

        if (FindMax)
        {
          while (node.RightChild != null)
          {
            node = node.RightChild;
          }
        } else
        {
          while (node.LeftChild != null)
          {
            node = node.LeftChild;
          }
        }
        return node;
    }
	
    public boolean DeleteNodeByKey(int key)
    {
        // удаляем узел по ключу
        BSTFind<T> nodeToDelete = FindNode(Root, key);
  
        if (nodeToDelete.NodeHasKey)
        {
          
          BSTNode<T> replacementNode = null;
          if (nodeToDelete.Node.RightChild != null)
          {
            replacementNode = nodeToDelete.Node.RightChild;
            while (replacementNode.LeftChild != null)
            {
              replacementNode = replacementNode.LeftChild;
            }

            replacementNode.LeftChild = nodeToDelete.Node.LeftChild;
            if (nodeToDelete.Node.RightChild != replacementNode)
            {
              replacementNode.RightChild = nodeToDelete.Node.RightChild;
            }

          } else if (nodeToDelete.Node.LeftChild != null)
          {
            replacementNode = nodeToDelete.Node.LeftChild;
          }

          if (nodeToDelete.Node.Parent != null) 
          {
            if (nodeToDelete.Node.Parent.LeftChild == nodeToDelete.Node)
            {
              nodeToDelete.Node.Parent.LeftChild = replacementNode;
            } else nodeToDelete.Node.Parent.RightChild = replacementNode;
          } else 
          {
            if (nodeToDelete.Node.LeftChild != null || nodeToDelete.Node.RightChild != null)
            {           
              replacementNode.LeftChild = Root.LeftChild;
              replacementNode.RightChild = Root.RightChild;
            }
            Root = replacementNode;
          } 
          
          return true;
        } else return false; // если узел не найден
        
    }

    public int Count()
    {
      if (Root == null) return 0;
      int count = 0;
      Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
      stack.push(Root);
      while (true)
      {
        BSTNode<T> node;
        try{
          node = stack.pop();
        } catch (EmptyStackException e)
        {
          break;
        }
        count++;

        if (node.LeftChild != null) stack.push(node.LeftChild);
        if (node.RightChild != null) stack.push(node.RightChild);
      }
        return count; // количество узлов в дереве
    }
	
}