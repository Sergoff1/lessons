import java.util.*;

public class Level1
{
    public static String TheRabbitsFoot(String s, boolean encode)
    {
          
          int numOfTransferChars = 0;                                           //Переменная для заноса символов строки в двумерный массив, на случай если символов в строке меньше произведения строк и столбцов
          int nonSpaceStringLength = s.replaceAll("\s", "").length();
          int rows = (int)Math.floor(Math.sqrt(nonSpaceStringLength));
          int columns = (int)Math.ceil(Math.sqrt(nonSpaceStringLength));
          while (rows * columns  < nonSpaceStringLength) {
              rows++;
          }

        String convertedString = "";
        if (encode) {
            s = s.replaceAll("\s", "");

            Character [][] arr = new Character[rows][columns];

            for (int r = 0; r < rows; r++) {                       //Перенос строки в массив
                for (int c = 0; c < columns; c++) {
                    if (numOfTransferChars == nonSpaceStringLength) {
                        break;
                    }
                    arr[r][c] = s.charAt(numOfTransferChars);
                    numOfTransferChars++;
                }
            }

            
            numOfTransferChars = 0;
            for (int r = 0; r < rows; r++) {                       //Перенос массива в результирующую строку
                for (int c = 0; c < columns; c++) {
                    if (numOfTransferChars == nonSpaceStringLength) {
                        break;
                    }
                    if (arr[c][r] != null) {
                    convertedString = convertedString.concat(String.valueOf(arr[c][r]));
                    numOfTransferChars++;
                    }
                }
                convertedString+= " ";
            }

            convertedString = convertedString.trim();
        } else {
            char [][] arr2 = new char[rows][columns];                   // Массив для начального переноса строки

            String [] arrStr = s.split("\s");

            for (int r = 0; r < rows; r++) {                              //Перенос строки в массив
                arr2[r] = arrStr[r].toCharArray();
            }

            for (int r = 0; r < columns; r++) {            // Восстановление строки путём транспонирования массива
                for (int c = 0; c < rows; c++) {
                    if (numOfTransferChars == nonSpaceStringLength) {
                        break;
                    }
                    convertedString += arr2[c][r];
                    numOfTransferChars++;
                }
            }
        }
        return convertedString;
    }
}