import java.util.*;

public class Level1
{
    public static int squirrel(int N)
      {
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result = result * i;	
	    }
        return Integer.valueOf(Integer.toString(result).substring(0,1));
      }
}
