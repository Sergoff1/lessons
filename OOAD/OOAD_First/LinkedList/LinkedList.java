abstract class LinkedList<T> {
    //Для краткости буду называть связный список просто списком.
    public static final int HEAD_NIL = 0; // head() ещё не вызывалась
    public static final int HEAD_OK = 1; // последняя head() отработала нормально
    public static final int HEAD_ERR = 2; // список пуст

    public static final int TAIL_NIL = 0; // tail() ещё не вызывалась
    public static final int TAIL_OK = 1; // последняя tail() отработала нормально
    public static final int TAIL_ERR = 2; // список пуст

    public static final int RIGHT_NIL = 0; // right() ещё не вызывалась
    public static final int RIGHT_OK = 1; // последняя right() отработала нормально
    public static final int RIGHT_ERR = 2; // список пуст

    public static final int ADD_TO_EMPTY_NIL = 0; // addToEmpty() ещё не вызывалась
    public static final int ADD_TO_EMPTY_OK = 1; // последняя addToEmpty() отработала нормально
    public static final int ADD_TO_EMPTY_ERR = 2; // список не пустой

    public static final int PUT_RIGHT_NIL = 0; // putRight() ещё не вызывалась
    public static final int PUT_RIGHT_OK = 1; // последняя putRight() отработала нормально
    public static final int PUT_RIGHT_ERR = 2; // список пуст

    public static final int PUT_LEFT_NIL = 0; // putLeft() ещё не вызывалась
    public static final int PUT_LEFT_OK = 1; // последняя putLeft() отработала нормально
    public static final int PUT_LEFT_ERR = 2; // список пуст

    public static final int REMOVE_NIL = 0; // remove() ещё не вызывалась
    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // список пуст

    public static final int REPLACE_NIL = 0; // replace() ещё не вызывалась
    public static final int REPLACE_OK = 1; // последняя replace() отработала нормально
    public static final int REPLACE_ERR = 2; // список пуст

    public static final int FIND_NIL = 0; // find() ещё не вызывалась
    public static final int FIND_OK = 1; // последняя find() отработала нормально
    public static final int FIND_ERR = 2; // запрашиваемое значение не найдено

    public static final int GET_NIL = 0; // get() ещё не вызывалась
    public static final int GET_OK = 1; // последняя get() отработала нормально
    public static final int GET_ERR = 2; // список пуст


    //Конструкторы

    //постусловие: создан новый пустой связный список
    public abstract LinkedList(); //Тип возвращаемого значения LinkedList<T>, не стал указывать в коде, так как реализую АТД по правилам Java, а вообще в спецификации АТД это делать нужно.

    //Команды

    //предусловие: список не пустой
    //постусловие: курсор указывает на первый узел в списке
    public abstract void head(); //установить курсор на первый узел в списке

    //предусловие: список не пустой
    //постусловие: курсор указывает на последний узел в списке
    public abstract void tail(); //установить курсор на последний узел в списке

    //предусловие: список не пустой и курсор указывает не на последний узел списка
    //постусловие: курсор указывает на узел справа от изначального
    public abstract void right(); //сдвинуть курсор на один узел вправо

    //предусловие: список не пустой
    //постусловие: в список добавлен новый узел справа от узла, на который указывает курсор
    public abstract void putRight(T value); //вставить следом за текущим узлом новый узел с заданным значением

    //предусловие: список не пустой
    //постусловие: в список добавлен новый узел, слева от узла, на который указывает курсор
    public abstract void putLeft(T value); //вставить перед текущим узлом новый узел с заданным значением

    //предусловие: список не пустой
    //постусловие: из списка удалён узел, положение курсора изменилось
    public abstract void remove(); //удалить текущий узел (курсор смещается к правому соседу, если он есть, в противном случае курсор смещается к левому соседу, если он есть)

    //постусловие: из списка удалены все узлы
    public abstract void clear(); //очистить список

    //предусловие: список пуст
    //постусловие: в списке появился один узел
    public abstract void addToEmpty(T value); //добавить новый узел в пустой список

    //постусловие: в хвост списка добавлен новый узел
    public abstract void addTail(T value); //добавить новый узел в хвост списка

    //предусловие: список не пустой
    //постусловие: в списке изменилось значение текущего узла
    public abstract void replace(T value); //заменить значение текущего узла на заданное

    //постусловие: курсор указывает на следующий узел с искомым значение
    public abstract void find(T value); //установить курсор на следующий узел с искомым значением (по отношению к текущему узлу)

    //постусловие: из списка удалены все узлы с указанным значением, если такие были
    public abstract void remove_all(T value); //удалить в списке все узлы с заданным значением

    //Запросы

    //предусловие: список не пустой
    public abstract T get(); //получить значение текущего узла

    public abstract int size(); //посчитать количество узлов в списке

    public abstract boolean isHead(); //находится ли курсор в начале списка

    public abstract boolean isTail(); //находится ли курсор в конце списка

    public abstract boolean isValue(); //установлен ли курсор на какой-либо узел в списке

    //Дополнительные запросы
    public abstract int getHeadStatus(); // возвращает значение HEAD_*
    public abstract int getTailStatus(); // возвращает значение TAIL_*
    public abstract int getRightStatus(); // возвращает значение RIGHT_*
    public abstract int getAddToEmptyStatus(); // возвращает значение ADD_TO_EMPTY_*
    public abstract int getPutRightStatus(); // возвращает значение PUT_RIGHT_*
    public abstract int getPutLeftStatus(); // возвращает значение PUT_LEFT_*
    public abstract int getRemoveStatus(); // возвращает значение REMOVE_*
    public abstract int getReplaceStatus(); // возвращает значение REPLACE_*
    public abstract int getFindStatus(); // возвращает значение FIND_*
    public abstract int getGetStatus(); // возвращает значение GET_*
}

/*
2.2. Почему операция tail не сводима к другим операциям (если исходить из эффективной реализации)?
В эффективной реализации у хвоста должен быть свой указатель, что позволит обращаться к нему за O(1), иначе пришлось бы каждый раз добираться до хвоста от головы за O(n).

2.3. Операция поиска всех узлов с заданным значением, выдающая список таких узлов, уже не нужна. Почему?
Мы можем получить все узлы с заданными значением с помощью повторения других операций (find(T value) и get()).
 */