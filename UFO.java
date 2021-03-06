import java.util.*;

public class Level1
{
    public static int [] UFO(int N, int [] data, boolean octal)
      {
        int [] result = new int [N];
        for (int i =0; i < data.length; i++) {
            int[] number = new int[Integer.toString(data[i]).length()];      //Создаем массив размером с число

            for (int tmp = number.length - 1; tmp >= 0; tmp--) {             //Переводим число в массив
                number[tmp] = data[i] % 10;
                data[i] /= 10;
            }
            
            if (octal) {                                                     //Переводим число в десятичную систему счисления
                for (int j = 0; j < number.length; j++) {
                    result[i] += number[j] * Math.pow(8,number.length - 1 - j);
                }
            } else {
                for (int j = 0; j < number.length; j++) {
                    result[i] += number[j] * Math.pow(16,number.length - 1 - j);
                }
            }
        }
        return result;
      }
}
