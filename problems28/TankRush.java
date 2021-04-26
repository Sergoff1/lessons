import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) 
      {
        int [][] areaScheme = new int [H1][W1];
        int [][] enemyLocation = new int [H2][W2];

        String [] s1Arr = S1.split(" ");
        String [] s2Arr = S2.split(" ");
        char [] digString;
        
        for (int i = 0; i < H1; i++) {
            digString = s1Arr[i].toCharArray();
            for (int j = 0; j < W1; j++) {
                areaScheme [i][j] = digString[j] - '0';
            }
        }

        for (int i = 0; i < H2; i++) {
            digString = s2Arr[i].toCharArray();
            for (int j = 0; j < W2; j++) {
                enemyLocation [i][j] = digString[j] - '0';
            }
        }
        
        boolean isEnemyInReach = false;
        int [][] tempEL = new int [H2][W2];
        for (int i = 0; i < H1; i++) {
            for (int j = 0; j < W1; j++) {
                boolean topLeftCornerMatch = ( areaScheme[i][j] == enemyLocation[0][0] );
                boolean enemyWithinBorder = ( i + H2 <= H1 && j + W2 <= W1 );
                if (topLeftCornerMatch && enemyWithinBorder){
                
                    for (int c = 0; c < H2; c++) {
                        for (int k = 0; k < W2; k++) {
                            tempEL[c][k] = areaScheme[i+c][j+k];
                        }
                    }
                    isEnemyInReach = Arrays.deepEquals(enemyLocation, tempEL);
                    if (isEnemyInReach) {
                        i = H1;
                        j = W1;
                    }
                }
            }
        }
        return isEnemyInReach;
      }
}