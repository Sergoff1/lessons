import java.util.*;

public class Level1
{
    public static int [] UFO(int N, int [] data, boolean octal)
      {
        int [] decimalNumbers = new int [N];
        for (int i =0; i < data.length; i++) {
            int[] number = new int[Integer.toString(data[i]).length()];      //Создаем массив размером с число

            for (int j = number.length - 1; j >= 0; j--) {             //Переводим число в массив
                number[j] = data[i] % 10;
                data[i] /= 10;
            }
            
            if (octal) {                                                     //Переводим число в десятичную систему счисления
                for (int j = 0; j < number.length; j++) {
                    decimalNumbers[i] += number[j] * Math.pow(8,number.length - 1 - j);
                }
            } else {
                for (int j = 0; j < number.length; j++) {
                    decimalNumbers[i] += number[j] * Math.pow(16,number.length - 1 - j);
                }
            }
        }
        return decimalNumbers;
      }
}
