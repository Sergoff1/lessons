public class BalancedBSTTest {
    public static void main(String[] args) {
        
        int[] array = new int[15];

        for (int i = 0; i < 15; i++)
        {
            array[i] = 15 - i;
        }

        
        BalancedBST bst = new BalancedBST();

        bst.GenerateTree(array);

        System.out.println("Сгенерированное дерево: ");
        for (BSTNode i : bst.GetAllNodes(bst.Root))
        System.out.print(i);

        System.out.println();
        System.out.println("Дерево сбалансированно: " + bst.IsBalanced(bst.Root));
        System.out.println();
        
        array[8] = 8;
        array[9] = 8;
        array[10] = 8;
        array[11] = 8;

        bst.GenerateTree(array);

        System.out.println("Сгенерированное дерево, с тремя одинаковыми ключами: ");
        for (BSTNode i : bst.GetAllNodes(bst.Root))
        System.out.print(i);

        System.out.println();
        System.out.println("Дерево сбалансированно: " + bst.IsBalanced(bst.Root));
        System.out.println();

        int[] sArray = new int[5];

        sArray[0] = 1;
        sArray[1] = 1;
        sArray[2] = 1;
        sArray[3] = 2;
        sArray[4] = 3;

        bst.GenerateTree(sArray);

        System.out.println("Сгенерированное малое дерево: ");
        for (BSTNode i : bst.GetAllNodes(bst.Root))
        System.out.print(i);

        System.out.println();
        System.out.println("Дерево сбалансированно: " + bst.IsBalanced(bst.Root));
        System.out.println();
    }
}
