import java.util.*;

public class Level1
{
    public static String Keymaker(int k) {
        int dividersNum = 0;
        String status = "";
        if (k==1) {
            return "1";
        }

        for (int i = k; i > 0; i--) {
            if (k % i == 0) {
                dividersNum++;
            }
        }

        if (dividersNum % 2 == 0) {
            status = "0";
        } else {
            status = "1";
        }
        return Keymaker(k-1) + status;
    }
}
