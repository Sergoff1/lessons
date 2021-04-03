import java.util.*;

public class Level1
{
    public static String BigMinus(String s1, String s2)
      {
        String result = "";
        int N = 0;                                               // Принимает размер меньшего числа
        int c = 0;
        boolean firstBigger = false;                                  // Принимает true если первое число больше второго, помогает определить максимальное число
        char [] num1 = s1.toCharArray();
        char [] num2 = s2.toCharArray();
        int dig1 = 0, dig2 = 0;                                  // Переменные для облегчения восприятия кода в цикле

        if (s1.length() > s2.length()) {                         // Решаем из какого числа будем вычитать
            N = s2.length();
            firstBigger = true;

        } else if (s1.length() == s2.length()) {
            while (Character.getNumericValue(s1.charAt(c)) == Character.getNumericValue(s2.charAt(c)) && c < s1.length()-1) {
                c++;
            }
            if (Character.getNumericValue(s1.charAt(c)) > Character.getNumericValue(s2.charAt(c))) {
                N = s2.length();
                firstBigger = true;

            } else {
                N = s1.length();
            }

        } else {
            N = s1.length();
        }
        c = 0;

        if (firstBigger) {
            for (int i = 0; i < N; i++) {
                dig1 = Character.getNumericValue(num1[num1.length - 1 -i]);
                dig2 = Character.getNumericValue(num2[num2.length - 1 -i]);
                if (dig2 > dig1) {
                    while (num1[num1.length - 1 -c -i] == '0')
                    {
                        c++;
                        if (num1[num1.length - 1 -c -i] !='0') {
                            num1[num1.length - 1 -c -i] = (char)(num1[num1.length - 1 -c -i] - '\1');
                        }
                        num1[num1.length -c -i] = '9';
                    }
                    dig1 += 10;
                    num1[num1.length - 1 -i] = Character.forDigit(dig1 - dig2 ,10);
                } else {
                    num1[num1.length - 1 -i] = Character.forDigit(dig1 - dig2 ,10);
                }
            }
            result = new String (num1);
        } else {
            for (int i = 0; i < N; i++) {
                dig1 = Character.getNumericValue(num2[num2.length - 1 -i]);
                dig2 = Character.getNumericValue(num1[num1.length - 1 -i]);
                if (dig2 > dig1) {
                    while (num2[num2.length - 1 -c -i] == '0')
                    {
                        c++;
                        if (num2[num2.length - 1 -c -i] !='0') {
                            num2[num2.length - 1 -c -i] = (char)(num2[num2.length - 1 -c -i] - '\1');
                        }
                        num2[num2.length -c -i] = '9';
                    }
                    dig1 += 10;
                    num2[num2.length - 1 -i] = Character.forDigit(dig1 - dig2 ,10);
                } else {
                    num2[num2.length - 1 -i] = Character.forDigit(dig1 - dig2 ,10);
                }
            }
            result = new String (num2);
        }

        if (result.replaceFirst("0*", "") == "") {
            result = "0";
        } else {
            result = result.replaceFirst("0*", "");
        }
        return result;
      }
}
