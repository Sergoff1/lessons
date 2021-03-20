import java.util.*;

public class Level1
{
    public static String BiggerGreater(String input) {
        int temp = 0;
        int firstIndexForSwap = input.length()-1;
        int secondIndexForSwap = 0;
        boolean unaltered = true;
        char[] arrChar = input.toCharArray();

        for (int i = arrChar.length -1; i > 0; i--){          //Проверка на возможность преобразования
            if (arrChar[i] > arrChar[i-1]) {
                unaltered = false;
                break;
            }
        }

        if (unaltered) {
            return "";
        }

        do {                                       //Ищем индекс первого элемента для перестановки
            firstIndexForSwap--;
        } while (arrChar[firstIndexForSwap] >= arrChar[firstIndexForSwap+1]);

        secondIndexForSwap = firstIndexForSwap + 1;                                         //Первичное значение индекса второго элемента
        for (int i = firstIndexForSwap + 1; i < input.length(); i++) {                      //Ищем индекс второго элемента
            if (arrChar[firstIndexForSwap] - arrChar[i] < 0 && arrChar[firstIndexForSwap] - arrChar[i] > temp) {
                temp = arrChar[firstIndexForSwap] - arrChar[i];
                secondIndexForSwap = i;
            }
        }

        temp = arrChar[firstIndexForSwap];                                    //Перестановка
        arrChar[firstIndexForSwap] = arrChar[secondIndexForSwap];
        arrChar[secondIndexForSwap] = (char)temp;

        if (input.length()- firstIndexForSwap > 2) {                         //Если переставляли не два последних элемента
            boolean sorted = false;
            while(!sorted) {                                                 //Сортируем оставшиеся элементы по возрастанию
                sorted = true;
                for (int i = firstIndexForSwap+1; i < input.length() - 1; i++) {
                    if (arrChar[i] > arrChar[i+1]) {
                        temp = arrChar[i];
                        arrChar[i] = arrChar[i+1];
                        arrChar[i+1] = (char)temp;
                        sorted = false;
                    }
                }
            }
        }
        
        return String.valueOf(arrChar);
    }
}
