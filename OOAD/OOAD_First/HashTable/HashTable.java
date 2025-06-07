package HashTable;

import java.util.Arrays;

public abstract class HashTable<T> {

    public static final int PUT_OK = 1; // последняя put() отработала нормально
    public static final int PUT_ERR = 2; // таблица заполнена

    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // элемент отсутствует в таблице

    //Конструктор
    //public HashTable<T> HashTable(int maxSize);

    //Команды

    //предусловие: в таблице есть свободное место
    //постусловие: в таблицу добавлен новый элемент
    public abstract void put(T value);

    //предусловие: в таблице есть переданный элемент
    //постусловие: из таблицы удалён переданный элемент
    public abstract void remove(T value);

    //Запросы

    public abstract boolean contains(T value); //Содержится ли элемент в таблице

    public abstract int size();

    public abstract int maxSize();

    //Запросы статусов

    public abstract int getPutStatus();
    public abstract int getRemoveStatus();
}

class HashTableImpl<T> extends HashTable<T> {

    private T[] slots;
    private int size;
    private int maxSize;

    private int putStatus;
    private int removeStatus;

    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        slots = (T[]) new Object[maxSize];
        Arrays.fill(slots, null);
        size = 0;
    }

    @Override
    public void put(T value) {
        int slot = seekSlot(value);
        if (slot >= 0) {
            slots[slot] = value;
            size++;
            putStatus = PUT_OK;
        } else {
            putStatus = PUT_ERR;
        }
    }

    @Override
    public void remove(T value) {
        if(contains(value)) {
            slots[seekSlot(value)] = null;
            size--;
            removeStatus = REMOVE_OK;
        } else {
            removeStatus = REMOVE_ERR;
        }
    }

    @Override
    public boolean contains(T value) {
        int slot = seekSlot(value);
        return slot != -1 && slots[slot] != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int maxSize() {
        return maxSize;
    }

    @Override
    public int getPutStatus() {
        return putStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    private int hashFunc(T value) {
        return Math.abs(value.hashCode()) % maxSize;
    }

    private int seekSlot(T value) {
        int baseSlot = hashFunc(value);

        if(slots[baseSlot] == null) {
            return baseSlot;
        }

        for (int i = baseSlot; i < baseSlot + maxSize; i++)
        {
            if (slots[i].equals(value)) {
                return i;
            }

            if (slots[i % maxSize] == null) {
                return i % maxSize;
            }
        }

        return -1;
    }
}
