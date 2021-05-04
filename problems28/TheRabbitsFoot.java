import java.util.*;

public class Level1
{
    public static String TheRabbitsFoot(String s, boolean encode)
    {
          
          int numOfTransferChars = 0;   //Переменная для заноса символов строки в двумерный массив, на случай если символов в строке меньше произведения строк и столбцов
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

            for (int row = 0; row < rows; row++) {     //Перенос строки в массив
                for (int column = 0; column < columns; column++) {
                    if (numOfTransferChars == nonSpaceStringLength) {
                        break;
                    }
                    arr[row][column] = s.charAt(numOfTransferChars);
                    numOfTransferChars++;
                }
            }

            
            numOfTransferChars = 0;
            for (int row = 0; row < rows; row++) {   //Перенос массива в результирующую строку
                for (int column = 0; column < columns; column++) {
                    if (numOfTransferChars == nonSpaceStringLength) {
                        break;
                    }
                    if (arr[column][row] != null) {
                    convertedString = convertedString.concat(String.valueOf(arr[column][row]));
                    numOfTransferChars++;
                    }
                }
                convertedString+= " ";
            }

            convertedString = convertedString.trim();
        } else {
            char [][] arr2 = new char[rows][columns];    // Массив для начального переноса строки

            String [] arrStr = s.split("\s");

            for (int row = 0; row < rows; row++) {       // Перенос строки в массив
                arr2[row] = arrStr[row].toCharArray();
            }

            for (int row = 0; row < columns; row++) {      // Восстановление строки путём транспонирования массива
                for (int column = 0; column < rows; column++) {
                    if (numOfTransferChars == nonSpaceStringLength) {
                        break;
                    }
                    convertedString += arr2[column][row];
                    numOfTransferChars++;
                }
            }
        }
        return convertedString;
    }
}