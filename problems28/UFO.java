import java.util.*;

public class Level1
{
    public static int [] UFO(int N, int [] data, boolean octal)
      {
        final int FIRST_UFO_NOTATION = 8;
        final int SECOND_UFO_NOTATION = 16;
        int [] decimalNumbers = new int [N];
        for (int i =0; i < data.length; i++) {
            int[] number = new int[Integer.toString(data[i]).length()];      //Создаем массив размером с число

            for (int j = number.length - 1; j >= 0; j--) {             //Переводим число в массив цифр
                number[j] = data[i] % 10;
                data[i] /= 10;
            }
            
            if (octal) {  //Переводим число в десятичную систему счисления, из восьмеричной или шестнадцатеричной
                for (int j = 0; j < number.length; j++) {
                    decimalNumbers[i] += number[j] * Math.pow(FIRST_UFO_NOTATION,number.length - 1 - j);
                }
            } else {
                for (int j = 0; j < number.length; j++) {
                    decimalNumbers[i] += number[j] * Math.pow(SECOND_UFO_NOTATION,number.length - 1 - j);
                }
            }
        }
        return decimalNumbers;
      }
}
