import java.util.*;

public class Level1
{
    public static boolean LineAnalysis(String line)
      {
        boolean isCorrectPattern = true;
        final char EDGE_ELEMENT = '*';

        if (line.charAt(0) == EDGE_ELEMENT && line.charAt(line.length()-1) == EDGE_ELEMENT) {
            for (int i = 1; i < line.length()/2; i++) {
                if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
                    isCorrectPattern = false;
                    break;
                }
            }
        } else isCorrectPattern = false;

        return isCorrectPattern;
      }
}