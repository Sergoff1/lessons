import java.util.*;

public class Level1
{
    public static StringBuilder result = new StringBuilder("");            //Основная строка
    public static ArrayList<String> arrUndo = new ArrayList<>();           //Список выполненных операций
    public static ArrayList<Boolean> ifAdd = new ArrayList<>();            //Показывает добавили ли мы текст или удалили
    static int undoCount = 0;                                              //Счётчик возможных возвратов и индекс поледнего изменения
    static int redoCount = 0;                                              //Счётчик возможных отмен возвратов
    static boolean wasUndo = false;                                        //Была ли отмена

    public static String BastShoe(String command) 
    {
        Integer N;
        try {
            switch(command.charAt(0)) { //Выбираем какое действие совершить
            case '1':                                                   //Добавить строку
                result.append(command.substring(2, command.length()));

                if (wasUndo) {                                          //Если была отмена действия, то прошлая цепочка операций обнуляется
                    arrUndo.clear();
                    ifAdd.clear();
                    undoCount = 0;
                    redoCount = 0;
                }

                arrUndo.add(command.substring(2, command.length()));    //Фиксируем изменения для возможности их отмены
                ifAdd.add(true);                                        //Пометка о добавлении текста
                undoCount++;
                break;

            case '2':                                                        //Удалить N последних символов
                N = Integer.valueOf(command.substring(2, command.length())); //Число знаков, которое нужно удалить

                if (wasUndo) {                                               //Если была отмена действия, то прошлая цепочка операций обнуляется
                    arrUndo.clear();
                    ifAdd.clear();
                    undoCount = 0;
                    redoCount = 0;
                }

                if (N > result.length()) {
                    arrUndo.add(result.toString());                          //Фиксируем изменения для возможности их отмены
                    result.delete(0, result.length());
                    ifAdd.add(false);                                        //Пометка об удалении текста
                    undoCount++;
                } else {
                    arrUndo.add(result.substring(result.length() - N, result.length())); //Фиксируем изменения для возможности их отмены
                    result.delete(result.length() - N, result.length());
                    ifAdd.add(false);                                                    //Пометка об удалении текста
                    undoCount++;
                }
                break;

            case '3':                                                        //Вывести символ строки
                N = Integer.valueOf(command.substring(2, command.length())); //Индекс элемента для вывода
                if (N < 0 || N >= result.length()) {
                    return "";
                } else 
                    return result.substring(N, N+1); //Возвращаем элемент в формате строки

            case '4': //Отменить операцию
                if (undoCount == 0) {
                    return result.toString();
                } else {
                    N = arrUndo.get(undoCount -1).length();      //Длина строки для удаления
                    if (ifAdd.get(undoCount -1)) {               //Если эта строка была добавлена, то удаляем её
                        result.delete(result.length() - N, result.length());
                    } else {
                        result.append(arrUndo.get(undoCount -1));  //Иначе вернуть убранную часть
                    }
                    undoCount--;
                }
                redoCount++;
                wasUndo = true;
                break;

            case '5': //Откатить отмену
                if (redoCount == 0) {
                    return result.toString();
                } else {
                    N = arrUndo.get(undoCount).length();      //Длина строки для удаления
                    if (ifAdd.get(undoCount)) {               //Если эта строка была изначально добавлена, то возвращаем её
                        result.append(arrUndo.get(undoCount));
                    } else {
                        result.delete(result.length() - N, result.length());;  //Иначе удалить, то что вернула операция отмены
                    }
                    redoCount--;
                    undoCount++;
                }
                break;

            default:
                return result.toString();
            }
        } catch (Exception e) {
            return result.toString(); //Если входящаяя строка некорректна
        }
        
        return result.toString();
    }
}
