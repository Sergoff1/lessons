import java.util.*;

public class Level1
{
    public static int SumOfThe(int N, int [] data)
      {
        int sum = 0, res = 0;
        for (int i = 0; i < N; i++) {
            for (int j =0; j < N; j++) {
                if (j != i) {
                    sum +=  data[j];
                }
            }
            if (data [i] == sum) {
                res = sum;
            }
            sum = 0;
        }
        return res;
      }
}