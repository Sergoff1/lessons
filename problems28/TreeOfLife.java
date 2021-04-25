import java.util.*;

public class Level1
{
    public static String [] TreeOfLife(int H, int W, int N, String [] tree) 
    {
        String[] treeState = new String[H];
        char[][] tree2D = new char[H][W];
        int[] neighbors;
        final char AGE_OF_DEATH = '3';
        final char NO_BRANCH = '0';

        for (int i = 0; i < H; i++) {         //Converting a string array to a two-dimensional character array
            for (int j = 0; j < W; j++) {
                if (tree[i].charAt(j) == '+') {
                    tree2D[i][j] = '1';
                } else {
                    tree2D[i][j] = NO_BRANCH;
                }
            }
        }

        for (int year = 0; year < N; year++) {  //Model the development of the tree for several years

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    tree2D[i][j]++;              //Branches age by a year
                }
            }

            if (year%2 == 1) {         //Tree behavior in an odd year
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (tree2D[i][j] >= AGE_OF_DEATH) {  //Death of old branches and their neighbors
                            tree2D[i][j] = NO_BRANCH;
                            neighbors = new int[] {i,i,i+1,i-1,j,j,j+1,j-1};  //Array for processing neighboring elements
                            for (int c = 0; c < 4; c++) {      //Processing neighboring elements
                                try {
                                    if (tree2D[neighbors[c]][neighbors[7-c]] < AGE_OF_DEATH){   //We leave the elements that should destroy the neighbors
                                        tree2D[neighbors[c]][neighbors[7-c]] = NO_BRANCH;    //Destroy other elements
                                    }
                                } catch (ArrayIndexOutOfBoundsException e){
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {    //Converting a two-dimensional array of characters back to a string array
            treeState[i] = "";
            for (int j = 0; j < W; j++) {
                if (tree2D[i][j] > NO_BRANCH) {
                    treeState[i] += "+";
                } else {
                    treeState[i] += ".";
                }
            }
        }
        return treeState;
    }
}
