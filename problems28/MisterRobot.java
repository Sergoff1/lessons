import java.util.*;

public class Level1
{
    public static boolean MisterRobot(int N, int [] data) 
      {
        boolean canSorted = true;

        while (true) {
            int bufferVariable = 0;
            for (int i = 0; i <= N - 3; i++) {
                while (data[i] > data[i+1] || data[i] > data[i+2]) {
                    bufferVariable = data[i];
                    data[i] = data[i+1];
                    data[i+1] = data[i+2];
                    data[i+2] = bufferVariable;
                }
            }
            if (bufferVariable == 0 && data[N-1] > data[N-2]) {
                break;
            } else if (bufferVariable == 0 && data[N-1] < data[N-2]){
                canSorted = false;
                break;
            }
        }
        return canSorted;
      }
}