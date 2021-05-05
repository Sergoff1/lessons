import java.util.*;

public class Matrix
{
    public static void turn(String Matrix[], int M, int N, int T)
    {
        char[][] matrix2D = new char[M][N];

        for (int i = 0; i < M; i++) {    //Converting a string array to a two-dimensional character array
            for (int j = 0; j < N; j++) {
                matrix2D[i][j] = Matrix[i].charAt(j);
            }
        }

        int temp = 0;
        for (int step = 0; step < T; step++) {     //Number of steps to rotate the matrix
            for (int offset = 0; offset < Math.min(M, N)/2; offset++) {      //Convergence to the middle

                temp = matrix2D[M-1 - offset][N-1 - offset];
                
                for (int i = M - 1- offset; i > 0 + offset; i--) {         //Right
                    matrix2D[i][N-1 - offset] = matrix2D[i-1][N-1 - offset];
                }

                for (int i = N - 1- offset; i > 0 + offset; i--) {         //Up
                    matrix2D[0 + offset][i] = matrix2D[0 + offset][i-1];
                }

                for (int i = 0 + offset; i < M-1 - offset; i++) {          //Left
                    matrix2D[i][0 + offset] = matrix2D[i+1][0 + offset];
                }

                for (int i = 0 + offset; i < N-1 - offset; i++) {          //Down
                    matrix2D[M-1 - offset][i] = matrix2D[M-1 - offset][i+1];
                }

                matrix2D[M-1- offset][N-2 - offset] = (char)temp;
            }
        }

        for (int i = 0; i < M; i++) {        //Converting to a string array
            Matrix[i] = "";
            for (int j = 0; j < N; j++) {
                Matrix[i] += matrix2D[i][j];
            }
        }

    }
}
