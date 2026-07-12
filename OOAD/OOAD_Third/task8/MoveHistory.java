package OOAD_Third.task8;

public abstract class MoveHistory {

    public static final int POP_NIL = 0; // pop() ещё не вызывалась
    public static final int POP_OK = 1; // последняя pop() отработала нормально
    public static final int POP_ERR = 2; // история пуста

    public static final int PEEK_NIL = 0; // peek() ещё не вызывалась
    public static final int PEEK_OK = 1; // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = 2; // история пуста

    //Конструкторы
    //постусловие: создана структура для хранения истории ходов
    //public MoveHistory MoveHistory();

    //Команды

    //постусловие: координаты хода сохранены в истории ходов
    public abstract void push(Pair<Coordinate> coordinates);

    // предусловие: история не пустая
    // постусловие: из истории удалён последний ход
    public abstract void pop();

    // постусловие: история ходов очищена
    public abstract void clear();

    //Запросы

    // предусловие: история не пустая
    public abstract Pair<Coordinate> peek();

    public abstract int size();

    //Дополнительные запросы:
    public abstract int get_pop_status(); // возвращает значение POP_*
    public abstract int get_peek_status(); // возвращает значение PEEK_*

}
