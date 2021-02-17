import java.util.*;

public class Level1
{
    public static int squirrel(int N)
      {
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result = result * i;	
	    }
	String str = Integer.toString(result);
	char[] chArray = str.toCharArray();
        return chArray[0];
      }
}
