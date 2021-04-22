import java.util.*;

public class Level1
{
    public static int MaximumDiscount(int N, int [] price)
      {
        final int ITEMS_FOR_DISCOUNT = 3;
        int maxDiscount = 0;
        int countOfItems = 0;
        Arrays.sort(price);
        for (int i = price.length - 1; i >= price.length % ITEMS_FOR_DISCOUNT; i--) {
            if (countOfItems == ITEMS_FOR_DISCOUNT - 1) {
                maxDiscount += price[i];
                countOfItems = 0;
                continue;
            }
            countOfItems++;
        }
        return maxDiscount;
      }
}