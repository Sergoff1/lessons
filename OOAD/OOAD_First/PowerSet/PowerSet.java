package PowerSet;

import HashTable.HashTable;

import java.lang.reflect.Field;
import java.util.Objects;

abstract class PowerSet<T> extends HashTable<T> {

    //Конструктор
    //постусловие: создано пустое множество с заданной ёмкостью
    //public PowerSet<T> PowerSet(int maxSize);


    //Запросы

    public abstract PowerSet<T> intersection(PowerSet<T> anotherSet); //Пересечение множеств

    public abstract PowerSet<T> union(PowerSet<T> anotherSet); //Объединение множеств

    public abstract PowerSet<T> difference(PowerSet<T> anotherSet); //Разность множеств

    public abstract boolean isSubSet(PowerSet<T> anotherSet); //Является параметр подмножеством текущего множества

}

class PowerSetImpl<T> extends PowerSet<T> {

    private T[] set;
    private int size;
    private int maxSize;

    private int putStatus;
    private int removeStatus;

    public PowerSetImpl(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        set = (T[]) new Object[maxSize];
    }

    @Override
    public void put(T value) {
        int slot = seekSlot(value);
        if (slot >= 0 && set[slot] == null) {
            set[slot] = value;
            size++;
            putStatus = PUT_OK;
        } else {
            putStatus = PUT_ERR;
        }
    }

    @Override
    public void remove(T value) {
        int slot = find(value);
        if (slot >= 0) {
            set[slot] = null;
            size--;
            removeStatus = REMOVE_OK;
        } else {
            removeStatus = REMOVE_ERR;
        }
    }

    @Override
    public boolean contains(T value) {
        return find(value) >= 0;
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

    @Override
    public PowerSet<T> intersection(PowerSet<T> anotherSet) {
        PowerSet<T> resultSet = new PowerSetImpl<T>(this.size());
        for(T value : set) {
            if(value != null && anotherSet.contains(value)) {
                resultSet.put(value);
            }
        }
        return resultSet;
    }

    @Override
    public PowerSet<T> union(PowerSet<T> anotherSet) {
        PowerSet<T> resultSet = new PowerSetImpl<T>(this.size() + anotherSet.size());
        for(T value : set) {
            resultSet.put(value);
        }

        Field setField;
        T[] array;
        try {
            setField = anotherSet.getClass().getDeclaredField("set");
            setField.setAccessible(true);
            array = (T[]) setField.get(anotherSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for(T value : array) {
            resultSet.put(value);
        }
        return resultSet;
    }

    @Override
    public PowerSet<T> difference(PowerSet<T> anotherSet) {
        PowerSet<T> resultSet = new PowerSetImpl<T>(this.size());
        for(T value : set) {
            if(value != null && !anotherSet.contains(value)) {
                resultSet.put(value);
            }
        }
        return resultSet;
    }

    @Override
    public boolean isSubSet(PowerSet<T> anotherSet) {
        Field setField;
        T[] array;
        try {
            setField = anotherSet.getClass().getDeclaredField("set");
            setField.setAccessible(true);
            array = (T[]) setField.get(anotherSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (T value : array) {
            if (value != null && !this.contains(value)) {
                return false;
            }
        }
        return true;
    }

    private int hashFunc(T value) {
        return Math.abs(value.hashCode() % maxSize);
    }

    private int seekSlot(T value) {
        int baseSlot = hashFunc(value);

        if(set[baseSlot] == null) {
            return baseSlot;
        }

        for (int i = baseSlot; i < baseSlot + maxSize; i++)
        {
            if (set[i].equals(value)) {
                return i;
            }

            if (set[i % maxSize] == null) {
                return i % maxSize;
            }
        }

        return -1;
    }

    private int find(T value) {
        int slot = seekSlot(value);
        if (slot == -1 || !Objects.equals(set[slot], value)) {
            return -1;
        } else {
            return slot;
        }
    }

}
