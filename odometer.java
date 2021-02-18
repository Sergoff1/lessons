import java.util.*;

public class Level1
{
    public static int odometer(int[] oksana)
      {
        int result = 0,var = 0;
        for (int j = 0; j < oksana.length - 1; j+=2) {
            for (int i = 0; i < 2; i++){
                if (oksana[j+1] < 2) {
                var = oksana[j] * oksana[j+1];
                } else { 
                    var = oksana[j] * (oksana[j+1] - oksana[j-1]);
                }
            }
           result += var;
        }
        return result;
      }
}