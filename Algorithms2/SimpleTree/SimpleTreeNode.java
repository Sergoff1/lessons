import java.util.*;

import javax.swing.tree.TreeNode;

public class SimpleTreeNode<T>
{
    public int nodeLevel; //уровень узла в дереве
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null
	
    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }

    @Override
    public String toString() {
        return NodeValue + " ";
    }
}
	
class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void SetNodeLevels(SimpleTreeNode<T> currentNode, int currentLevel)
    {
        currentNode.nodeLevel = currentLevel;
        if (currentNode.Children == null) return;
        for (SimpleTreeNode<T> node : currentNode.Children)
        {
            SetNodeLevels(node, currentLevel + 1);
        }
    }
	
    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        // код добавления нового дочернего узла существующему ParentNode
        if (ParentNode.Children == null) ParentNode.Children = new ArrayList<SimpleTreeNode<T>>();
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        // код удаления существующего узла NodeToDelete
        try 
        {
            NodeToDelete.Parent.Children.remove(NodeToDelete);
        } catch (NullPointerException e)
        {
            return;
        }
    }

    private ArrayList<SimpleTreeNode<T>> getNodes(SimpleTreeNode<T> rootNode)
    {
        ArrayList<SimpleTreeNode<T>> treeNodes = new ArrayList<SimpleTreeNode<T>>();
        if (rootNode.Children == null)
        {
            treeNodes.add(rootNode);
            return treeNodes;
        } 
        treeNodes.add(rootNode);
        for (SimpleTreeNode<T> node : rootNode.Children) 
        {
            treeNodes.addAll(getNodes(node));
        }
        return treeNodes;
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        // код выдачи всех узлов дерева в определённом порядке
        return getNodes(Root);
    }
	
    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        // код поиска узлов по значению
        List<SimpleTreeNode<T>> findedNodes = new ArrayList<SimpleTreeNode<T>>();
        for(SimpleTreeNode<T> node : getNodes(Root))
        {
            if (node.NodeValue == val) findedNodes.add(node);
        }
        return findedNodes;
    }
   
    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        // код перемещения узла вместе с его поддеревом -- 
	    // в качестве дочернего для узла NewParent
        DeleteNode(OriginalNode);
        AddChild(NewParent, OriginalNode);
    }
   
    public int Count()
    {
        // количество всех узлов в дереве
	    return getNodes(Root).size();
    }

    public int LeafCount()
    {
        // количество листьев в дереве
        int leafCount = 0;
        for (SimpleTreeNode<T> node : getNodes(Root))
        {
            if (node.Children == null || node.Children.size() == 0) leafCount++;
        }
	    return leafCount;
    }

    public ArrayList<T> EvenTrees()
    {
        ArrayList<T> edgesToDelete = new ArrayList<>();
        LinkedList<SimpleTreeNode<T>> queue = new LinkedList<>();
        SimpleTreeNode<T> node = Root;
        queue.add(node);
        while (!queue.isEmpty())
        {
            node = queue.pollFirst();
            SimpleTree<T> tree = new SimpleTree<>(node);
            if (tree.Count() % 2 == 0)
            {
                if (node.Parent != null)
                {
                    edgesToDelete.add(node.Parent.NodeValue);
                    edgesToDelete.add(node.NodeValue);
                }
                
                queue.addAll(node.Children);
            }
        }
        return edgesToDelete;
    }

}
