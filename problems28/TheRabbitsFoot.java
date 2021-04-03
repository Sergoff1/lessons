import java.util.*;

public class Level1
{
    public static String TheRabbitsFoot(String s, boolean encode)
      {
          String res = "";
          int cnt = 0;                                           //Переменная для заноса символов строки в двумерный массив, на случай если символов в строке меньше произведения строк и столбцов
          int N = s.replaceAll("\s", "").length();
          int rows = (int)Math.floor(Math.sqrt(N));
          int columns = (int)Math.ceil(Math.sqrt(N));
          while (rows * columns  < N) {
              rows++;
          }
          if (encode) {
            s = s.replaceAll("\s", "");

            Character [][] arr = new Character[rows][columns];

            for (int r = 0; r < rows; r++) {                       //Перенос строки в массив
                for (int c = 0; c < columns; c++) {
                    if (cnt == N) {
                        break;
                    }
                    arr[r][c] = s.charAt(cnt);
                    cnt++;
                }
            }

            cnt = 0;
            for (int r = 0; r < rows; r++) {                       //Перенос массива в результирующую строку
                for (int c = 0; c < columns; c++) {
                    if (cnt == N) {
                        break;
                    }
                    if (arr[c][r] != null) {
                    res = res.concat(String.valueOf(arr[c][r]));
                    cnt++;
                    }
                }
                res+= " ";
            }

            res = res.trim();
          } else {
            char [][] arr2 = new char[rows][columns];                   // Массив для начального переноса строки

            String [] arrStr = s.split("\s");

            for (int r = 0; r < rows; r++) {                              //Перенос строки в массив
                arr2[r] = arrStr[r].toCharArray();
            }

            for (int r = 0; r < columns; r++) {            // Восстановление строки путём транспонирования массива
                for (int c = 0; c < rows; c++) {
                    if (cnt == N) {
                        break;
                    }
                    res += arr2[c][r];
                    cnt++;
                }
            }
          }
        return res;
      }
}