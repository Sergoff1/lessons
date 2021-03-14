import java.util.*;

public class Level1
{
    public static String [] ShopOLAP(int N, String [] items)  
      {
        String [] result;
        Integer quantity;
        String temp = "";

        for (int i = 0; i < items.length; i++) { //Объединяем записи по одинаковым товарам
            for (int j = 0; j < items.length; j++) {
                if (items[j] != "") {
                    if (i != j && items[i].contains(items[j].substring(0, items[j].indexOf("\s")))) { //Есть совпадение товаров в массиве
                        quantity = Integer.valueOf(items[i].substring(items[i].indexOf("\s")+1, items[i].length())); //Число продаж в первой записи
                        quantity += Integer.valueOf(items[j].substring(items[j].indexOf("\s")+1, items[j].length())); //Суммируем с числом продаж из второй записи
                        items[i] = items[i].replaceAll("\\s\\d+", " " + quantity.toString()); //Меняем значение продаж первой записи
                        items[j] = ""; //Удаляем вторую запись
                    }
                }
            }
        }
        N = 0;
        for (String i: items) {// Считаем сколько элементов осталось в массиве после слияния одинаковых записей
            if (i != "") N++;
        }

        result = new String[N]; //Создаём массив с уникальными записями товаров

        for (int i = 0,c = 0; i < N; i++) {//Заполняем его
            if (items[i] != "") {
                result[i] = items[i+c];
            } else {
                c++;
                result[i] = items[i+c];
            }
        }

        for (int i = 0; i < N-1; i++) {//Сортируем результирующий массив по числу продаж
            for (int j = 0; j < N-1; j++) {
                int count = 0;
                Integer firstValue = Integer.valueOf(result[j].substring(result[j].indexOf("\s")+1, result[j].length()));//Число продаж первого элемента
                Integer secondValue = Integer.valueOf(result[j+1].substring(result[j+1].indexOf("\s")+1, result[j+1].length()));//Число продаж второго элемента
                if (firstValue < secondValue) {
                    temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                } else if (firstValue == secondValue) { //Если число продаж одинаково меняем места элементов в порядке лексикографического возрастания
                    while (result[j].charAt(count) == result[j+1].charAt(count)) {
                        count++;
                    }
                    if (result[j].charAt(count) > result[j+1].charAt(count)) {
                        temp = result[j];
                        result[j] = result[j+1];
                        result[j+1] = temp;
                    }
                }
            }
        }
        return result;
      }
}