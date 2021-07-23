import java.util.*;

public class AlgorithmsDataStructures2
{

    private static int[] arrayToABST(int[] aBST, int[] a, int i)
    {
        if (a.length == 0)
        {
            return aBST;
        } 
        aBST[i] = (a[a.length/2]);
        arrayToABST(aBST, Arrays.copyOfRange(a, 0, a.length/2), 2*i+1);
        arrayToABST(aBST, Arrays.copyOfRange(a, a.length/2 + 1, a.length), 2*i+2);
        return aBST;
    }

    public static int[] GenerateBBSTArray(int[] a)
    {
        Arrays.sort(a);

        int[] bstArray = new int[a.length];

        return arrayToABST(bstArray, a, 0);
    }
}