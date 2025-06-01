package DynArray;

import java.util.ArrayList;
import java.util.List;

abstract class DynArray<T> {

    public static final int INSERT_OK = 1; // последняя insert() отработала нормально
    public static final int INSERT_ERR = 2; // индекс выходит за границы допустимого диапазона

    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // индекс выходит за границы допустимого диапазона

    public static final int GET_OK = 1; // последняя get() отработала нормально
    public static final int GET_ERR = 2; // индекс выходит за границы допустимого диапазона

    //Конструктор
    //постусловие: создан пустой динамический массив
    //public DynArray<T> DynArray();


    //Команды

    //постусловие: в конец массива добавлен новый элемент
    public abstract void append(T value);

    //предусловие: индекс находится в допустимом диапазоне (i >= 0 && i <= size())
    //постусловие: при наличии, элементы справа от текущей позиции(включая элемент на этой позиции) сдвинулись на один шаг вправо,
    //             в указанную позицию вставлен переданный элемент
    public abstract void insert(T value, int index);

    //предусловие: индекс находится в допустимом диапазоне (i >= 0 && i < size())
    //постусловие: из указанной позиции удалён элемент,
    //             элементы справа от удалённого сдвинулись на один шаг влево, если такие есть
    public abstract void remove(int index);

    //постусловие: Из массива удалены все элементы
    public abstract void clear();


    //Запросы

    //предусловие: индекс находится в допустимом диапазоне (i >= 0 && i < size())
    public abstract T get(int index);

    public abstract int size();


    //запросы статусов
    public abstract int getInsertStatus();
    public abstract int getRemoveStatus();
    public abstract int getGetStatus();
}

class DynArrayImpl<T> extends DynArray<T> {

    private final List<T> array;

    public DynArrayImpl() {
        array = new ArrayList<T>();
    }

    public int insertStatus;
    public int removeStatus;
    public int getStatus;

    @Override
    public void append(T value) {
        array.add(value);
    }

    @Override
    public void insert(T value, int index) {
        if (index >= 0 && index <= array.size()) {
            array.add(index, value);
            insertStatus = INSERT_OK;
        } else {
            insertStatus = INSERT_ERR;
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < array.size()) {
            array.remove(index);
            removeStatus = REMOVE_OK;
        } else {
            removeStatus = REMOVE_ERR;
        }
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public T get(int index) {
        T result = null;
        if (index >= 0 && index < array.size()) {
            result = array.get(index);
            getStatus = GET_OK;
        } else {
            getStatus = GET_ERR;
        }
        return result;
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public int getInsertStatus() {
        return insertStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    @Override
    public int getGetStatus() {
        return getStatus;
    }
}
