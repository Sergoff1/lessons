import java.util.*;

public class Level1
{
    public static int SumOfThe(int N, int [] data)
      {
        int sumOfAllOtherNumbers = 0;
        for (int i = 0; i < N; i++) {
            for (int j =0; j < N; j++) {
                if (j != i) {
                    sumOfAllOtherNumbers +=  data[j];
                }
            }
            if (data [i] == sumOfAllOtherNumbers) {
                break;
            }
            sumOfAllOtherNumbers = 0;
        }
        return sumOfAllOtherNumbers;
      }
}