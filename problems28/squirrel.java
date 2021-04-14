import java.util.*;

public class Level1
{
    public static int squirrel(int N)
      {
        int firstFactorialDigit = 1;
        for (int i = 1; i <= N; i++) {
            firstFactorialDigit = firstFactorialDigit * i;	
	    }
        return Integer.valueOf(Integer.toString(firstFactorialDigit).substring(0,1));
      }
}
