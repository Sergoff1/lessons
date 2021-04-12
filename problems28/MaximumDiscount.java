import java.util.*;

public class Level1
{
    public static int MaximumDiscount(int N, int [] price)
      {
        int maxDiscount = 0;
        int count = 0;
        Arrays.sort(price);
        for (int i = price.length - 1; i >= price.length % 3; i--) {
            if (count == 2) {
                maxDiscount += price[i];
                count = 0;
                continue;
            }
            count++;
        }
        return maxDiscount;
      }
}