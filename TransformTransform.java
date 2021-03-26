import java.util.*;

public class Level1
{
    public static ArrayList<Integer> Transformer(int A[])
    {
        ArrayList<Integer> B = new ArrayList<>();
        int k = 0;
        int max = 0;

        for (int i = 0; i <= A.length-1; i++) {
            for (int j = 0; j <= A.length-i-1; j++) {
                k = i + j;
                for (int c = j; c <= k; c++) {
                    if (A[c] > max) {
                        max = A[c];
                    }
                }
                B.add(max);
            }
        }

        return B;
    }


    public static boolean TransformTransform(int A[], int N)
    {
        int sum = 0;
        ArrayList<Integer> B = new ArrayList<>();
        B = Transformer(Transformer(A).stream().mapToInt(i->i).toArray());  //transform the array and the result of the transformation

        for (int i = 0; i < B.size(); i++) {
            sum += B.get(i);
        }

        return sum%2 == 0;
    }
}
