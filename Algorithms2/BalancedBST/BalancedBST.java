import java.util.*;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок	
    public int     Level; // глубина узла
	
    public BSTNode(int key, BSTNode parent)
     {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
      }


      @Override
      public String toString() {
          return  /*NodeKey + " ";*/"k-" + NodeKey + " l-"+ Level + ", ";
      }
}	

class BalancedBST
{
	  public BSTNode Root; // корень дерева
		
	  public BalancedBST() 
	  { 
		  Root = null;
	  }
		
	  public void GenerateTree(int[] a) 
	  {  // создаём дерево с нуля из неотсортированного массива a
      Arrays.sort(a);
      Root = recGenTree(a, 0, a.length - 1, null, 0);

	  }

    private BSTNode recGenTree(int[] a, int aStart, int aEnd, BSTNode parent, int nodeLevel)
    {

      if (aEnd - aStart < 0) return null;
      
      BSTNode node = new BSTNode(a[(aStart + aEnd) / 2], parent);
      node.Level = nodeLevel;

      BSTNode leftNode = recGenTree(a, aStart, (aStart + aEnd) / 2 - 1, node, nodeLevel + 1);

      if(leftNode != null)
      if (node.NodeKey > leftNode.NodeKey)
      node.LeftChild = leftNode;
      else 
      {
        node.RightChild = leftNode;
        BSTNode lastNode = node.RightChild; //Последний узел с ключом равным родительскому
        while (lastNode.RightChild != null)
        {
          lastNode = lastNode.RightChild;
        }
        BSTNode rightNode = recGenTree(a, (aStart + aEnd) / 2 + 1, aEnd, node, lastNode.Level + 1);
        lastNode.RightChild = rightNode;
        return node; 
      }

      BSTNode rightNode = recGenTree(a, (aStart + aEnd) / 2 + 1, aEnd, node, nodeLevel + 1);

      node.RightChild = rightNode;

      return node;
    }

	  public boolean IsBalanced(BSTNode root_node) 
	  {  
	  	return false; // сбалансировано ли дерево с корнем root_node
	  }

    public List<BSTNode> GetAllNodes(BSTNode node)
    {
      if (Root == null) return null;
      List<BSTNode> nodeList = new ArrayList<BSTNode>();
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
}