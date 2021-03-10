import java.util.*;

public class Level1
{
    public static boolean LineAnalysis(String line)
      {
        boolean result = true;

        if (line.charAt(0) == '*' && line.charAt(line.length()-1) == '*') {
            for (int i = 1; i < line.length()/2; i++) {
                if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
                    result = false;
                }
            }
        } else result = false;

        return result;
      }
}