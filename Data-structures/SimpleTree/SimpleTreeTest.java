public class SimpleTreeTest {

    public static void main(String[] args) {

        SimpleTreeNode<Integer> nodeOne = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> nodeTwo = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> nodeThree = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> nodeEight = new SimpleTreeNode<Integer>(8, null);
        SimpleTreeNode<Integer> nodeSix = new SimpleTreeNode<Integer>(6, null);

        SimpleTree<Integer> tree = new SimpleTree<Integer>(nodeOne);

        tree.AddChild(nodeOne, nodeTwo);
        tree.AddChild(nodeOne, nodeThree);
        tree.AddChild(nodeOne, nodeSix);
        tree.AddChild(nodeTwo, new SimpleTreeNode<Integer>(5, null));
        tree.AddChild(nodeTwo, new SimpleTreeNode<Integer>(7, null));
        tree.AddChild(nodeThree, new SimpleTreeNode<Integer>(4, null));
        tree.AddChild(nodeSix, nodeEight);
        tree.AddChild(nodeEight, new SimpleTreeNode<Integer>(9, null));
        tree.AddChild(nodeEight, new SimpleTreeNode<Integer>(10, null));
        


        System.out.println("Текущее состояние дерева:");
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();

        System.out.println("Список узлов, связи между которыми нужно разорвать:");
        System.out.println(tree.EvenTrees());



        System.out.println("Тест расстановки уровней узлов:");
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();
        System.out.println("Проставляем уровни:");
        tree.SetNodeLevels(tree.Root, 0);
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node.nodeLevel+" ");
        }
        System.out.println();

        System.out.println("Тест добавления узла:");
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();
        System.out.println("Добавляем узел со значением 2, родитель - узел 6:");
        SimpleTreeNode<Integer> addedNode = new SimpleTreeNode<Integer>(2, null);
        tree.AddChild(nodeSix, addedNode);
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();
        System.out.println("Родитель добавленного узла: " + addedNode.Parent + ", дети родительского узла: " + nodeSix.Children);

        System.out.println("Количество узлов: " + tree.Count());
        System.out.println("Количество листьев: " + tree.LeafCount());
        System.out.println();


        System.out.println("Тест поиска узлов со значением 2:");
        System.out.println(tree.FindNodesByValue(2));
        System.out.println();


        System.out.println("Тест переноса узла:");
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();
        System.out.println("Дети первого узла: " + nodeOne.Children);
        System.out.println("Дети третьего узла: " + nodeThree.Children);
        System.out.println("Количество узлов: " + tree.Count());
        System.out.println("Количество листьев: " + tree.LeafCount());
        System.out.println("Переносим второй узел: ");
        tree.MoveNode(nodeTwo, nodeThree);
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();
        System.out.println("Дети первого узла: " + nodeOne.Children);
        System.out.println("Дети третьего узла: " + nodeThree.Children);
        System.out.println("Количество узлов: " + tree.Count());
        System.out.println("Количество листьев: " + tree.LeafCount());
        System.out.println();


        System.out.println("Тест удаления узла:");
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();
        System.out.println("Удаляем второй узел: ");
        tree.DeleteNode(nodeTwo);
        for(SimpleTreeNode<Integer> node : tree.GetAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();

        System.out.println("Количество узлов: " + tree.Count());
        System.out.println("Количество листьев: " + tree.LeafCount());
        System.out.println();
    }
    
}
