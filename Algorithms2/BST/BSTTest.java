import java.util.ArrayList;

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

        BST<Integer> emptybst = new BST<Integer>(new BSTNode<Integer>(0, 0, null));

       /* System.out.println("Тест удаления по ключу 0: ");
        for (BSTNode<Integer> i : emptybst.GetAllNodes(emptybst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + emptybst.Count());*/
        emptybst.DeleteNodeByKey(0);/*
        if (emptybst.Root != null)
        for (BSTNode<Integer> i : emptybst.GetAllNodes(emptybst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + emptybst.Count());

        System.out.println();


        System.out.println("Тест добавления ключа в пустое дерево: ");
        if (emptybst.Root != null)
        for (BSTNode<Integer> i : bst.GetAllNodes(emptybst.Root))
        {
            System.out.print(i);
        }
        System.out.println("Количество элементов: " + emptybst.Count());
        System.out.println("Добавляем узел с ключом 88: ");
        emptybst.AddKeyValue(88, 88);
        for (BSTNode<Integer> i : emptybst.GetAllNodes(emptybst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + emptybst.Count());
        emptybst.DeleteNodeByKey(88);
        System.out.println();
        System.out.println();


        
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
        System.out.println("Добавляем узел с ключом 5: ");*/
        bst.AddKeyValue(5, 0);/*
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
        System.out.println("Добавляем узел с ключом 7: ");*/
        bst.AddKeyValue(7, 0);/*
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


        System.out.println("Тест поиска ключа 8: ");
        foundNode = bst.FindNodeByKey(8);
        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node+ ", Слева:" + foundNode.ToLeft);
        System.out.println("Тест поиска удалённого ключа: ");
        foundNode = bst.FindNodeByKey(6);
        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);
        System.out.println("Тест поиска удалённого ключа: ");
        foundNode = bst.FindNodeByKey(7);
        System.out.println( "HasKey: " + foundNode.NodeHasKey + ", ключ - " + foundNode.Node + ", Слева:" + foundNode.ToLeft);



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

        System.out.println("Тест удаления по ключу 6: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(6);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println("Тест удаления по ключу 7: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(7);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();

        System.out.println("Количество элементов: " + bst.Count());

        System.out.println();
        
        System.out.println("Тест удаления по ключу 4: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(4);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println();
        
        System.out.println("Тест удаления по ключу 8: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(8);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println();
        
        System.out.println("Тест удаления по ключу 14: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(14);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();


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
        System.out.println();

        System.out.println();
        
        System.out.println("Тест удаления по ключу 10: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(10);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println("Тест удаления по ключу 5: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(5);
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();

        System.out.println("Тест удаления по ключу 2: ");
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        bst.DeleteNodeByKey(2);
        if (bst.Root != null)
        for (BSTNode<Integer> i : bst.GetAllNodes(bst.Root))
        {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Количество элементов: " + bst.Count());
        System.out.println();
        */

        

        System.out.println("Тест обхода в ширину: ");
        ArrayList<BSTNode<Integer>> wideList = new ArrayList<>();
        wideList.add(nodeEight);
        wideList.add(nodeFour);
        wideList.add(nodeTwelve);
        wideList.add(nodeTwo);
        wideList.add(nodeSix);
        wideList.add(nodeTen);
        wideList.add(nodeFourteen);
        wideList.add(bst.FindNodeByKey(5).Node);
        wideList.add(bst.FindNodeByKey(7).Node);

        assert wideList.equals(bst.WideAllNodes()) : "Некорректная работа обхода в ширину";

        System.out.println();

        System.out.println("Как должно быть:");
        for (BSTNode<Integer> node : wideList)
        {
            System.out.print(node);
        }
        System.out.println();

        System.out.println("Как есть: ");
        for (BSTNode<Integer> node : bst.WideAllNodes())
        {
            System.out.print(node);
        }
        System.out.println();



        System.out.println();
        System.out.println();



        System.out.println("Тест обхода в глубину in-order: ");
        ArrayList<BSTNode<Integer>> DeepInList = new ArrayList<>();
        DeepInList.add(nodeTwo);
        DeepInList.add(nodeFour);
        DeepInList.add(bst.FindNodeByKey(5).Node);
        DeepInList.add(nodeSix);
        DeepInList.add(bst.FindNodeByKey(7).Node);
        DeepInList.add(nodeEight);
        DeepInList.add(nodeTen);
        DeepInList.add(nodeTwelve);
        DeepInList.add(nodeFourteen);

        assert DeepInList.equals(bst.DeepAllNodes(0)) : "Некорректная работа обхода в глубину in-order";

        System.out.println();

        System.out.println("Как должно быть:");
        for (BSTNode<Integer> node : DeepInList)
        {
            System.out.print(node);
        }
        System.out.println();

        System.out.println("Как есть: ");
        for (BSTNode<Integer> node : bst.DeepAllNodes(0))
        {
            System.out.print(node);
        }
        System.out.println();



        System.out.println();
        System.out.println();

        

        System.out.println("Тест обхода в глубину post-order: ");
        ArrayList<BSTNode<Integer>> DeepPostList = new ArrayList<>();
        DeepPostList.add(nodeTwo);
        DeepPostList.add(bst.FindNodeByKey(5).Node);
        DeepPostList.add(bst.FindNodeByKey(7).Node);
        DeepPostList.add(nodeSix);
        DeepPostList.add(nodeFour);
        DeepPostList.add(nodeTen);
        DeepPostList.add(nodeFourteen);
        DeepPostList.add(nodeTwelve);
        DeepPostList.add(nodeEight);

        assert DeepPostList.equals(bst.DeepAllNodes(1)) : "Некорректная работа обхода в глубину post-order";

        System.out.println();

        System.out.println("Как должно быть:");
        for (BSTNode<Integer> node : DeepPostList)
        {
            System.out.print(node);
        }
        System.out.println();

        System.out.println("Как есть: ");
        for (BSTNode<Integer> node : bst.DeepAllNodes(1))
        {
            System.out.print(node);
        }
        System.out.println();



        System.out.println();
        System.out.println();

        

        System.out.println("Тест обхода в глубину pre-order: ");
        ArrayList<BSTNode<Integer>> DeepPreList = new ArrayList<>();
        DeepPreList.add(nodeEight);
        DeepPreList.add(nodeFour);
        DeepPreList.add(nodeTwo);
        DeepPreList.add(nodeSix);
        DeepPreList.add(bst.FindNodeByKey(5).Node);
        DeepPreList.add(bst.FindNodeByKey(7).Node);
        DeepPreList.add(nodeTwelve);
        DeepPreList.add(nodeTen);
        DeepPreList.add(nodeFourteen);

        assert DeepPreList.equals(bst.DeepAllNodes(2)) : "Некорректная работа обхода в глубину pre-order";

        System.out.println();

        System.out.println("Как должно быть:");
        for (BSTNode<Integer> node : DeepPreList)
        {
            System.out.print(node);
        }
        System.out.println();

        System.out.println("Как есть: ");
        for (BSTNode<Integer> node : bst.DeepAllNodes(2))
        {
            System.out.print(node);
        }
        System.out.println();


        System.out.println("Тест работы с пустым списком: ");
        System.out.println(emptybst.WideAllNodes());
        System.out.println(emptybst.DeepAllNodes(0));
    }
}
