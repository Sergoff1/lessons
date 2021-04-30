import java.util.*;

public class Level1
{
    public static String Keymaker(int k) {
        String status = "";
        final String OPEN_DOOR = "1";
        if (k==1) {
            return OPEN_DOOR;
        }

        if (Math.sqrt(k) % 1 == 0) {
            status = OPEN_DOOR;
        } else {
            status = "0";
        }
        return Keymaker(k-1) + status;
    }
}
