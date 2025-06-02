package Queue;

import java.util.ArrayList;
import java.util.List;

abstract class Queue<T> {

    public static final int DEQUEUE_OK = 1; // последняя dequeue() отработала нормально
    public static final int DEQUEUE_ERR = 2; // очередь пуста

    public static final int GET_OK = 1; // последняя get() отработала нормально
    public static final int GET_ERR = 2; // очередь пуста

    //Конструктор
    //постусловие: создана пустая очередь
    //public Queue<T> Queue();

    //Команды

    //постусловие: в хвост очереди добавлен новый элемент
    public abstract void enqueue(T value); //Добавить элемент в хвост очереди

    //предусловие: очередь не пустая
    //постусловие: из головы очереди удалён один элемент
    public abstract void dequeue(); //Удалить элемент в голове очереди

    //постусловие: из очереди удалены все элементы
    public abstract void clear(); //Очистить очередь


    //Запросы

    //предусловие: очередь не пустая
    public abstract T get(); //Получить элемент из головы очереди

    public abstract int size();


    //Запросы статусов
    public abstract int getDequeueStatus();
    public abstract int getGetStatus();
}

class QueueImpl<T> extends Queue<T> {

    private final List<T> queue;

    private int dequeueStatus;
    private int getStatus;

    public QueueImpl() {
        queue = new ArrayList<>();
    }

    @Override
    public void enqueue(T value) {
        queue.add(value);
    }

    @Override
    public void dequeue() {
        if (!queue.isEmpty()) {
            queue.remove(0);
            dequeueStatus = DEQUEUE_OK;
        } else {
            dequeueStatus = DEQUEUE_ERR;
        }
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public T get() {
        T result = null;
        if(!queue.isEmpty()) {
            result = queue.get(0);
            getStatus = GET_OK;
        } else {
            getStatus = GET_ERR;
        }
        return result;
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public int getDequeueStatus() {
        return dequeueStatus;
    }

    @Override
    public int getGetStatus() {
        return getStatus;
    }
}
