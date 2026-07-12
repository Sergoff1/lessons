package OOAD_Third.task8;

public abstract class Field {

    public static final int SWAP_NIL = 0; // swapCommand() ещё не вызывалась
    public static final int SWAP_OK = 1; //Последняя swapCommand() отработала нормально
    public static final int SWAP_ERR = 2; //Попытка переставить не соседние элементы или отсутствие новой комбинации после перестановки

    public static final int PROCESS_COMBINATIONS_NIL = 0; // processCombinations() ещё не вызывалась
    public static final int PROCESS_COMBINATIONS_OK = 1; //Последняя processCombinations() отработала нормально
    public static final int PROCESS_COMBINATIONS_ERR = 2; //Метод вызван на пустом поле

    //Конструкторы
    //постусловие: создано пустое игровое поле размером 8x8 ячеек и инициализирован издатель, оповещающий подписчиков о событиях на игровом поле
    //public Field Field();

    //Команды

    //Заполнить пустые ячейки поля элементами.
    //Пропуски заполняются вышестоящими элементами, при их наличии, либо случайно сгенерированными.
    //постусловие: На поле нет пустых ячеек
    public abstract void fillGaps();

    //предусловие: поле не пустое
    //постусловие: С игрового поля удалены все комбинации, на месте сложных комбинаций появился особый элемент
    public abstract void processCombinations();

    //предусловие: переставляются соседние элементы
    //постусловие: элементы переставлены и на поле появилась новая комбинация, либо сработал специальный эффект элемента
    public abstract void swapCommand(Coordinate first, Coordinate second);

    //Запросы

    public abstract Element[][] getFieldState();

    public abstract boolean hasPossibleMoves(); //На поле есть возможные ходы

    public abstract boolean hasCombinations(); //На поле есть комбинации

    //Запросы статусов
    public abstract int getSwapStatus();
    public abstract int getProcessCombinationsStatus();

}
