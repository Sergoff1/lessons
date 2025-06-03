package Dequeue;

abstract class ParentQueue<T> {

    public static final int GET_HEAD_OK = 1; // последняя getHead() отработала нормально
    public static final int GET_HEAD_ERR = 2; // очередь пуста

    public static final int REMOVE_HEAD_OK = 1; // последняя removeHead() отработала нормально
    public static final int REMOVE_HEAD_ERR = 2; // очередь пуста

    //Конструктор
    //постусловие: создана пустая очередь
    //public ParentQueue<T> ParentQueue();

    //Команды

    //постусловие: в хвост очереди добавлен новый элемент
    public abstract void addTail(T value); //Добавить элемент в хвост очереди

    //предусловие: очередь не пустая
    //постусловие: из головы очереди удалён один элемент
    public abstract void removeHead(); //Удалить элемент в голове очереди


    //Запросы

    //предусловие: очередь не пустая
    public abstract T getHead(); //Получить элемент из головы очереди

    public abstract int size();


    //Запросы статусов
    public abstract int getGetHeadStatus();
    public abstract int getRemoveHeadStatus();
}

abstract class Queue<T> extends ParentQueue<T> {

    //Конструктор
    //постусловие: создана пустая очередь
    //public Queue<T> Queue();
}

abstract class Dequeue<T> extends ParentQueue<T> {

    public static final int GET_TAIL_OK = 1; // последняя getTail() отработала нормально
    public static final int GET_TAIL_ERR = 2; // очередь пуста

    public static final int REMOVE_TAIL_OK = 1; // последняя removeTail() отработала нормально
    public static final int REMOVE_TAIL_ERR = 2; // очередь пуста

    //Конструктор
    //постусловие: создана пустая очередь
    //public Dequeue<T> Dequeue();

    //Команды

    //постусловие: в голову очереди добавлен новый элемент
    public abstract void addHead(T value); //Добавить элемент в голову очереди

    //предусловие: очередь не пустая
    //постусловие: из хвоста очереди удалён один элемент
    public abstract void removeTail(T value); //Удалить элемент из хвоста очереди

    //Запросы

    //предусловие: очередь не пустая
    public abstract T getTail(); //Получить элемент из хвоста очереди

    //Запросы статусов
    public abstract int getGetTailStatus();
    public abstract int getRemoveTailStatus();
}
