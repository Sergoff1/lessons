package Dequeue;

import java.util.LinkedList;

abstract class ParentQueueImpl<T> {

    public static final int GET_HEAD_OK = 1; // последняя getHead() отработала нормально
    public static final int GET_HEAD_ERR = 2; // очередь пуста

    public static final int REMOVE_HEAD_OK = 1; // последняя removeHead() отработала нормально
    public static final int REMOVE_HEAD_ERR = 2; // очередь пуста

    protected LinkedList<T> queue;

    private int getHeadStatus;
    private int removeHeadStatus;

    //Конструктор
    //постусловие: создана пустая очередь
    public ParentQueueImpl() {
        queue = new LinkedList<>();
    }

    //Команды

    //постусловие: в хвост очереди добавлен новый элемент
    public void addTail(T value) {
        queue.addLast(value);
    }

    //предусловие: очередь не пустая
    //постусловие: из головы очереди удалён один элемент
    public void removeHead() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
            removeHeadStatus = REMOVE_HEAD_OK;
        } else {
            removeHeadStatus = REMOVE_HEAD_ERR;
        }
    }


    //Запросы

    //предусловие: очередь не пустая
    public T getHead() {
        T result = null;
        if (!queue.isEmpty()) {
            result = queue.getFirst();
            getHeadStatus = GET_HEAD_OK;
        } else {
            getHeadStatus = GET_HEAD_ERR;
        }
        return result;
    }

    public int size() {
        return queue.size();
    }


    //Запросы статусов
    public int getGetHeadStatus() {
        return getHeadStatus;
    }

    public int getRemoveHeadStatus() {
        return removeHeadStatus;
    }
}

class QueueImpl<T> extends ParentQueueImpl<T> {

    //Конструктор
    //постусловие: создана пустая очередь
    public QueueImpl() {
        super();
    };
}

class DequeueImpl<T> extends ParentQueueImpl<T> {

    public static final int GET_TAIL_OK = 1; // последняя getTail() отработала нормально
    public static final int GET_TAIL_ERR = 2; // очередь пуста

    public static final int REMOVE_TAIL_OK = 1; // последняя removeTail() отработала нормально
    public static final int REMOVE_TAIL_ERR = 2; // очередь пуста


    private int getTailStatus;
    private int removeTailStatus;

    //Конструктор
    //постусловие: создана пустая очередь
    public DequeueImpl() {
        super();
    }

    //Команды

    //постусловие: в голову очереди добавлен новый элемент
    public void addHead(T value) {
        queue.addFirst(value);
    }

    //предусловие: очередь не пустая
    //постусловие: из хвоста очереди удалён один элемент
    public void removeTail(T value) {
        if (!queue.isEmpty()) {
            queue.removeLast();
            removeTailStatus = REMOVE_TAIL_OK;
        } else {
            removeTailStatus = REMOVE_TAIL_ERR;
        }
    }

    //Запросы

    //предусловие: очередь не пустая
    public T getTail() {
        T result = null;
        if (!queue.isEmpty()) {
            result = queue.getLast();
            getTailStatus = GET_TAIL_OK;
        } else {
            getTailStatus = GET_TAIL_ERR;
        }
        return result;
    }

    //Запросы статусов
    public int getGetTailStatus() {
        return getTailStatus;
    }
    public int getRemoveTailStatus() {
        return removeTailStatus;
    }
}
