import java.util.*;

public class Level1
{
    private static int [][] convertTo2DArray(String coordinates, int H, int W) {
        int [][] resultArray = new int [H][W];
        String [] coordinatesArray = coordinates.split(" ");
        char [] digString;

        for (int i = 0; i < H; i++) {
            digString = coordinatesArray[i].toCharArray();
            for (int j = 0; j < W; j++) {
                resultArray [i][j] = digString[j] - '0';
            }
        }

    }

    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) 
      {
        int [][] areaScheme = convertTo2DArray(S1, H1, W1);
        int [][] enemyLocation = convertTo2DArray(S2, H2, W2);
        
        int [][] tempEL = new int [H2][W2];
        for (int i = 0; i < H1; i++) {
            boolean isEnemyInReach = false;
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
                        return true;
                    }
                }
            }
        }
        return false;
      }
}