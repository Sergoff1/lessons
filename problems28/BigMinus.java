import java.util.*;

public class Level1
{
    public static String getDifferenceOfNums(String s1, String s2)
      {
        int currentRankFromLeft = 0;
        boolean firstBigger = false;                             // Принимает true если первое число больше второго, помогает определить максимальное число
        int capacitySmallerNum = 0;                              // Разрядность меньшего числа

        if (s1.matches("\\D")) {
            System.out.println("Первый аргумент содержит не числовые символы");
        }

        if (s2.matches("\\D")) {
            System.out.println("Второй аргумент содержит не числовые символы");
        }

        if (s1.length() > s2.length()) {                         // Решаем из какого числа будем вычитать
            capacitySmallerNum = s2.length();
            firstBigger = true;

        } else if (s1.length() == s2.length()) {
            while (Character.getNumericValue(s1.charAt(currentRankFromLeft)) == Character.getNumericValue(s2.charAt(currentRankFromLeft)) && currentRankFromLeft < s1.length()-1) {
                currentRankFromLeft++;
            }
            if (Character.getNumericValue(s1.charAt(currentRankFromLeft)) > Character.getNumericValue(s2.charAt(currentRankFromLeft))) {
                capacitySmallerNum = s2.length();
                firstBigger = true;

            } else {
                capacitySmallerNum = s1.length();
            }

        } else {
            capacitySmallerNum = s1.length();
        }
        currentRankFromLeft = 0;
        char [] num1 = s1.toCharArray();
        char [] num2 = s2.toCharArray();
        int dig1 = 0, dig2 = 0;                                  // Переменные для облегчения восприятия кода в цикле
        String diff = "";
        final int NOTATION = 10;

        if (firstBigger) {
            for (int i = 0; i < capacitySmallerNum; i++) {
                dig1 = Character.getNumericValue(num1[num1.length - 1 -i]);
                dig2 = Character.getNumericValue(num2[num2.length - 1 -i]);
                if (dig2 > dig1) {
                    while (num1[num1.length - 1 - currentRankFromLeft -i] == '0')
                    {
                        currentRankFromLeft++;
                        if (num1[num1.length - 1 - currentRankFromLeft -i] !='0') {
                            num1[num1.length - 1 - currentRankFromLeft -i] = (char)(num1[num1.length - 1 - currentRankFromLeft -i] - '\1');
                        }
                        num1[num1.length - currentRankFromLeft -i] = '9';
                    }
                    dig1 += 10;
                    num1[num1.length - 1 -i] = Character.forDigit(dig1 - dig2 ,NOTATION);
                } else {
                    num1[num1.length - 1 -i] = Character.forDigit(dig1 - dig2 ,NOTATION);
                }
            }
            diff = new String (num1);
        } else {
            for (int i = 0; i < capacitySmallerNum; i++) {
                dig1 = Character.getNumericValue(num2[num2.length - 1 -i]);
                dig2 = Character.getNumericValue(num1[num1.length - 1 -i]);
                if (dig2 > dig1) {
                    while (num2[num2.length - 1 - currentRankFromLeft -i] == '0')
                    {
                        currentRankFromLeft++;
                        if (num2[num2.length - 1 - currentRankFromLeft -i] !='0') {
                            num2[num2.length - 1 - currentRankFromLeft -i] = (char)(num2[num2.length - 1 - currentRankFromLeft -i] - '\1');
                        }
                        num2[num2.length - currentRankFromLeft -i] = '9';
                    }
                    dig1 += 10;
                    num2[num2.length - 1 -i] = Character.forDigit(dig1 - dig2 ,NOTATION);
                } else {
                    num2[num2.length - 1 -i] = Character.forDigit(dig1 - dig2 ,NOTATION);
                }
            }
            diff = new String (num2);
        }

        if (diff.replaceFirst("0*", "") == "") {
            diff = "0";
        } else {
            diff = diff.replaceFirst("0*", "");
        }
        return diff;
      }
}
