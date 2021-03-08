import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) 
      {
        boolean result = false;
        int [][] map = new int [H1][W1];                 //Инициализируем массивы
        int [][] enemyLocation = new int [H2][W2];
        int [][] tempEL = new int [H2][W2];              //Промежуточный массив, в него будем заносить подмассив из map, способный удовлетворить условиям задачи
        String [] s1Arr = S1.split(" ");                 //Массив строк для map
        String [] s2Arr = S2.split(" ");                 //Массив строк для enemyLocation
        char [] digString;                               //Строка разбитая на символы для заполнения столбцов наших массивов
        
        for (int i = 0; i < H1; i++) {                   //Заполняем первый массив
            digString = s1Arr[i].toCharArray();
            for (int j = 0; j < W1; j++) {
                map [i][j] = digString[j] - '0';
            }
        }

        for (int i = 0; i < H2; i++) {                  //Заполняем второй массив
            digString = s2Arr[i].toCharArray();
            for (int j = 0; j < W2; j++) {
                enemyLocation [i][j] = digString[j] - '0';
            }
        }

        for (int i = 0; i < H1; i++) {                                                //Ходим по массиву в поисках совпадений
            for (int j = 0; j < W1; j++) {
                if (map[i][j] == enemyLocation[0][0] && i + H2 <= H1 && j + W2 <= W1) //Если нашли совпадение,которое не противоречит условиям
                {
                    for (int c = 0; c < H2; c++) {                                    //Записываем подмассив в промежуточный массив
                        for (int k = 0; k < W2; k++) {
                            tempEL[c][k] = map[i+c][j+k];
                        }
                    }
                    result = Arrays.deepEquals(enemyLocation, tempEL);                //Сравним второй массив с подмассивом, если равны, значит условие выполнено
                }
            }
        }
        return result;
                             // Ссылка на задачу в блоге https://vk.com/wall-203096474_4
      }
}