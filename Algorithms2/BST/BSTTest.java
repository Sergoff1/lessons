public class BSTTest {
    
    public static void main(String[] args) {

        BSTNode<Integer> nodeEight = new BSTNode<Integer>(8, 8, null);
        BSTNode<Integer> nodeFour = new BSTNode<Integer>(4, 4, nodeEight);
        BSTNode<Integer> nodeTwelve = new BSTNode<Integer>(12, 12, nodeEight);
        nodeEight.LeftChild = nodeFour;
        nodeEight.RightChild = nodeTwelve;
        BSTNode<Integer> nodeTwo = new BSTNode<Integer>(2, 2, nodeFour);
        BSTNode<Integer> nodeSix = new BSTNode<Integer>(6, 6, nodeFour);
        BSTNode<Integer> nodeTen = new BSTNode<Integer>(10, 10, nodeTwelve);
        BSTNode<Integer> nodeFourteen = new BSTNode<Integer>(14, 14, nodeTwelve);
        nodeFour.LeftChild = nodeTwo;
        nodeFour.RightChild = nodeSix;
        nodeTwelve.LeftChild = nodeTen;
        nodeTwelve.RightChild = nodeFourteen;

        BST<Integer> bst = new BST<Integer>(nodeEight);
        
        System.out.println("Тест поиска имеющегося ключа: ");
        BSTFind<Integer> foundNode = bst.FindNodeByKey(8);
        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node);
        System.out.println("Тест поиска ключа который должен быть добавлен справа: ");
        foundNode = bst.FindNodeByKey(7);
        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);
        System.out.println("Тест поиска ключа который должен быть добавлен слева: ");
        foundNode = bst.FindNodeByKey(5);
        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);



        System.out.println();
        System.out.println();



        System.out.println("Тест добавления имеющегося ключа: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println("Значение узла с ключом 6 - " + bst.FindNodeByKey(6).Node.NodeValue);
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println("Добавляем узел с ключом 6 и значением 0: ");
        bst.AddKeyValue(6, 0);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println("Значение узла с ключом 6 - " + bst.FindNodeByKey(6).Node.NodeValue);
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println("Тест добавления левого ключа: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println("Добавляем узел с ключом 5: ");
        bst.AddKeyValue(5, 0);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println("Тест добавления правого ключа: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println("Добавляем узел с ключом 7: ");
        bst.AddKeyValue(7, 0);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();


        System.out.println();
        

        System.out.println("Тест с поиском максимального ключа с корня: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(bst.FinMinMax(bst.Root, true));

        System.out.println("Тест с поиском минимального ключа с корня: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(bst.FinMinMax(bst.Root, false));

        System.out.println("Тест с поиском максимального ключа с узла 4: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(bst.FinMinMax(nodeFour, true));

        System.out.println("Тест с поиском минимального ключа с узла 12: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(bst.FinMinMax(nodeTwelve, false));


        System.out.println();
        System.out.println();


        System.out.println("Тест удаления по несуществующему ключу: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Удаляем по ключу 23: ");
        bst.DeleteNodeByKey(23);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();

        System.out.println("Тест удаления по ключу 2: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(2);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println("Тест удаления по ключу 12: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(12);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();

        System.out.println("Количество элементов: " + bst.Count());
    }
}
