import java.util.Arrays;

public class AlgorithmsDataStructures2Test {
    public static void main(String[] args) {

        int[] balancedTree = new int[15];

        balancedTree[0] = 8;
        balancedTree[1] = 4;
        balancedTree[2] = 12;
        balancedTree[3] = 2;
        balancedTree[4] = 6;
        balancedTree[5] = 10;
        balancedTree[6] = 14;
        balancedTree[7] = 1;
        balancedTree[8] = 3;
        balancedTree[9] = 5;
        balancedTree[10] = 7;
        balancedTree[11] = 9;
        balancedTree[12] = 11;
        balancedTree[13] = 13;
        balancedTree[14] = 15;

        int[] array = new int[15];

        for (int i = 0; i < 15; i++)
        {
            array[i] = 15 - i;
        }

        assert Arrays.equals(balancedTree, AlgorithmsDataStructures2.GenerateBBSTArray(array)) : "arrays not equal";

        int[] rootTree = new int[1];

        rootTree[0] = 8;

        assert Arrays.equals(rootTree, AlgorithmsDataStructures2.GenerateBBSTArray(rootTree)) : "root arrays not equal";
    }
}
