public class aBSTTest {
    public static void main(String[] args) {
        aBST bst = new aBST(3);
        assert bst.Tree.length == 15 : "wrong Tree length";

        bst.Tree[0] = 8;
        bst.Tree[1] = 4;
        bst.Tree[2] = 12;
        bst.Tree[4] = 6;
        bst.Tree[5] = 10;
        bst.Tree[6] = 14;
        bst.Tree[9] = 5;
        bst.Tree[10] = 7;
        bst.Tree[11] = 9;
        bst.Tree[14] = 15;

        System.out.println("Тест поиска места для отсутствующего узла 2: ");
        assert bst.FindKeyIndex(2) == -3 : "Missing key searching failed";
        for (Integer i : bst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println(bst.FindKeyIndex(2));
        System.out.println();

        System.out.println("Тест поиска индекса присутствующего узла 14: ");
        assert bst.FindKeyIndex(14) == 6 : "Existing key searching failed";
        for (Integer i : bst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println(bst.FindKeyIndex(14));
        System.out.println();

        System.out.println("Тест вставки узла 2: ");
        assert bst.AddKey(2) == 3 : "Missing key add failed";
        for (Integer i : bst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println(bst.AddKey(2));
        for (Integer i : bst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println();

        bst.AddKey(3);
        bst.AddKey(1);
        bst.AddKey(11);
        bst.AddKey(13);

        System.out.println("Тест поиска места для узла 20 в заполненном дереве: ");
        assert bst.FindKeyIndex(20) == null : "Missing key searching in the filled tree failed";
        for (Integer i : bst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println(bst.FindKeyIndex(20));
        System.out.println();
        
        System.out.println("Тест вставки узла 21 в заполненное дерево: ");
        assert bst.AddKey(21) == -1 : "Missing key add in the filled tree failed";
        for (Integer i : bst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println(bst.AddKey(21));
        System.out.println();

        aBST emptyBst = new aBST(3);

        System.out.println("Тест поиска места для узла 50 в пустом дереве: ");
        assert emptyBst.FindKeyIndex(50) == 0 : "Missing key add in the filled tree failed";
        for (Integer i : emptyBst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println(emptyBst.FindKeyIndex(50));
        System.out.println();
        
        System.out.println("Тест вставки узла 50 в пустое дерево: ");
        assert emptyBst.AddKey(50) == 0 : "Missing key add in the filled tree failed";
        System.out.println(emptyBst.AddKey(50));
        for (Integer i : emptyBst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println();

        System.out.println("Тест вставки узла 75 в дерево: ");
        System.out.println(emptyBst.AddKey(75));
        for (Integer i : emptyBst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println();

        System.out.println("Тест вставки узла 85 в дерево: ");
        System.out.println(emptyBst.AddKey(85));
        for (Integer i : emptyBst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println();

        System.out.println("Тест вставки узла 90 в дерево: ");
        System.out.println(emptyBst.AddKey(90));
        for (Integer i : emptyBst.Tree) System.out.print(i + " ");
        System.out.println();
        System.out.println();

        System.out.println("Тест вставки узла 95 в дерево: ");
        System.out.println(emptyBst.AddKey(95));
        for (Integer i : emptyBst.Tree) System.out.print(i + " ");
        System.out.println();
    }
}
