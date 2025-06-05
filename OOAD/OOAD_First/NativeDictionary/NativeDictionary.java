package NativeDictionary;

import java.util.Vector;

abstract class NativeDictionary<T> {

    public static final int PUT_INS = 1; // последняя put() создала новую запись
    public static final int PUT_UPD = 2; // последняя put() обновила значение существующей записи

    public static final int GET_OK = 1; // последняя get() отработала нормально
    public static final int GET_ERR = 2; // в словаре не было записи с переданным ключом

    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // в словаре не было записи с переданным ключом


    //Конструкторы
    //постусловие: создан новый пустой словарь
    //public NativeDictionary<T> NativeDictionary();

    //Команды

    //постусловие: в словарь добавлена новая запись или обновлена старая, если переданный ключ уже был там
    public abstract void put(String key, T value);

    //предусловие: в словаре есть запись с переданным ключом
    //постусловие: из словаря удалена запись с переданным ключом
    public abstract void remove(String key);

    //Запросы

    //предусловие: в словаре есть запись с переданным ключом
    public abstract T get(String key);

    public abstract boolean contains(String key); //Есть ли запись с переданным ключом в словаре

    public abstract int size();


    //Запросы статусов
    public abstract int getPutStatus();
    public abstract int getGetStatus();
    public abstract int getRemoveStatus();
}

class NativeDictionaryImpl<T> extends NativeDictionary<T> {

    private Vector<String> keys;
    private Vector<T> values;

    private int putStatus;
    private int getStatus;
    private int removeStatus;

    public NativeDictionaryImpl() {
        keys = new Vector<>();
        values = new Vector<>();
        keys.setSize(10);
        values.setSize(10);
    }

    @Override
    public void put(String key, T value) {
        int slot = seekSlot(key);
        if (slot > keys.capacity()) {
            keys.setSize(slot);
            values.setSize(slot);
        }

        if (keys.get(slot) == null) {
            keys.add(slot, key);
            putStatus = PUT_INS;
        } else {
            putStatus = PUT_UPD;
        }
        values.add(slot, value);
    }

    @Override
    public void remove(String key) {
        int slot = seekSlot(key);
        if (slot > keys.capacity()) {
            removeStatus = REMOVE_ERR;
        }
        if (keys.get(slot) != null) {
            keys.remove(slot);
            values.remove(slot);
            removeStatus = REMOVE_OK;
        } else {
            removeStatus = REMOVE_ERR;
        }
    }

    @Override
    public T get(String key) {
        int slot = seekSlot(key);
        if (slot > keys.capacity()) {
            getStatus = GET_ERR;
            return null;
        }
        if (keys.get(slot) != null) {
            getStatus = GET_OK;
            return values.get(slot);
        }
        return null;
    }

    @Override
    public boolean contains(String key) {
        int slot = seekSlot(key);
        if (slot > keys.capacity()) {
            return false;
        }
        return key.equals(keys.get(slot));
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public int getPutStatus() {
        return putStatus;
    }

    @Override
    public int getGetStatus() {
        return getStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    private int hashFunc(String key) {
        return Math.abs(key.hashCode() % keys.capacity());
    }

    private int seekSlot(String key) {
        int baseSlot = hashFunc(key);

        if(keys.get(baseSlot) == null) {
            return baseSlot;
        }

        for (int i = baseSlot; i < baseSlot + keys.capacity(); i++) {
            if (keys.get(i).equals(key)) {
                return i;
            }

            if (keys.get(i % keys.capacity()) == null) {
                return i % keys.capacity();
            }
        }

        return keys.capacity() + 1;
    }
}
