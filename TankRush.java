import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) 
      {
        boolean result = false;
        int [][] map = new int [H1][W1];
        int [][] enemyLocation = new int [H2][W2];
        int [][] tempEL = new int [H2][W2];
        String [] s1Arr = S1.split(" ");
        String [] s2Arr = S2.split(" ");
        char [] digString;
        
        for (int i = 0; i < H1; i++) {
            digString = s1Arr[i].toCharArray();
            for (int j = 0; j < W1; j++) {
                map [i][j] = digString[j] - '0';
            }
        }

        for (int i = 0; i < H2; i++) {
            digString = s2Arr[i].toCharArray();
            for (int j = 0; j < W2; j++) {
                enemyLocation [i][j] = digString[j] - '0';
            }
        }

        for (int i = 0; i < H1; i++) {
            for (int j = 0; j < W1; j++) {
                if (map[i][j] == enemyLocation[0][0] && i + H2 <= H1 && j + W2 <= W1){
                
                    for (int c = 0; c < H2; c++) {
                        for (int k = 0; k < W2; k++) {
                            tempEL[c][k] = map[i+c][j+k];
                        }
                    }
                    result = Arrays.deepEquals(enemyLocation, tempEL);
                }
            }
        }
        return result;
      }
}