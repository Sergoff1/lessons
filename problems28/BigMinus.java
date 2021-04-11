import java.util.*;

public class Level1
{
    public static String BigMinus(String s1, String s2)
      {
        String result = "";
        int digitCapacityOfASmallerNumber = 0;                   // Разрядность меньшего числа
        int numberOfTheCurrentDischargeFromLeft = 0;
        boolean firstBigger = false;                             // Принимает true если первое число больше второго, помогает определить максимальное число
        char [] num1 = s1.toCharArray();
        char [] num2 = s2.toCharArray();
        int dig1 = 0, dig2 = 0;                                  // Переменные для облегчения восприятия кода в цикле

        if (s1.length() > s2.length()) {                         // Решаем из какого числа будем вычитать
            digitCapacityOfASmallerNumber = s2.length();
            firstBigger = true;

        } else if (s1.length() == s2.length()) {
            while (Character.getNumericValue(s1.charAt(numberOfTheCurrentDischargeFromLeft)) == Character.getNumericValue(s2.charAt(numberOfTheCurrentDischargeFromLeft)) && numberOfTheCurrentDischargeFromLeft < s1.length()-1) {
                numberOfTheCurrentDischargeFromLeft++;
            }
            if (Character.getNumericValue(s1.charAt(numberOfTheCurrentDischargeFromLeft)) > Character.getNumericValue(s2.charAt(numberOfTheCurrentDischargeFromLeft))) {
                digitCapacityOfASmallerNumber = s2.length();
                firstBigger = true;

            } else {
                digitCapacityOfASmallerNumber = s1.length();
            }

        } else {
            digitCapacityOfASmallerNumber = s1.length();
        }
        numberOfTheCurrentDischargeFromLeft = 0;

        if (firstBigger) {
            for (int i = 0; i < digitCapacityOfASmallerNumber; i++) {
                dig1 = Character.getNumericValue(num1[num1.length - 1 -i]);
                dig2 = Character.getNumericValue(num2[num2.length - 1 -i]);
                if (dig2 > dig1) {
                    while (num1[num1.length - 1 - numberOfTheCurrentDischargeFromLeft -i] == '0')
                    {
                        numberOfTheCurrentDischargeFromLeft++;
                        if (num1[num1.length - 1 - numberOfTheCurrentDischargeFromLeft -i] !='0') {
                            num1[num1.length - 1 - numberOfTheCurrentDischargeFromLeft -i] = (char)(num1[num1.length - 1 - numberOfTheCurrentDischargeFromLeft -i] - '\1');
                        }
                        num1[num1.length - numberOfTheCurrentDischargeFromLeft -i] = '9';
                    }
                    dig1 += 10;
                    num1[num1.length - 1 -i] = Character.forDigit(dig1 - dig2 ,10);
                } else {
                    num1[num1.length - 1 -i] = Character.forDigit(dig1 - dig2 ,10);
                }
            }
            result = new String (num1);
        } else {
            for (int i = 0; i < digitCapacityOfASmallerNumber; i++) {
                dig1 = Character.getNumericValue(num2[num2.length - 1 -i]);
                dig2 = Character.getNumericValue(num1[num1.length - 1 -i]);
                if (dig2 > dig1) {
                    while (num2[num2.length - 1 - numberOfTheCurrentDischargeFromLeft -i] == '0')
                    {
                        numberOfTheCurrentDischargeFromLeft++;
                        if (num2[num2.length - 1 - numberOfTheCurrentDischargeFromLeft -i] !='0') {
                            num2[num2.length - 1 - numberOfTheCurrentDischargeFromLeft -i] = (char)(num2[num2.length - 1 - numberOfTheCurrentDischargeFromLeft -i] - '\1');
                        }
                        num2[num2.length - numberOfTheCurrentDischargeFromLeft -i] = '9';
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
