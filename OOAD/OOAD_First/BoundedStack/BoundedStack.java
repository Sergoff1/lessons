package ru.sergoff.BoundedStack;

/* Закомментировал код, чтобы объявить конструктор как полагается в АТД(с типом возвращаемого значения).
public abstract class BoundedStack<T> {

    public static final int DEFAULT_CAPACITY = 32; // ёмкость стека по умолчанию

    public static final int POP_NIL = 0; // pop() ещё не вызывалась
    public static final int POP_OK = 1; // последняя pop() отработала нормально
    public static final int POP_ERR = 2; // стек пуст

    public static final int PEEK_NIL = 0; // peek() ещё не вызывалась
    public static final int PEEK_OK = 1; // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = 2; // стек пуст

    public static final int PUSH_NIL = 0; // push() ещё не вызывалась
    public static final int PUSH_OK = 1; // последняя push() отработала нормально
    public static final int PUSH_ERR = 2; // стек заполнен

    // конструкторы:

    // постусловие: создан новый пустой стек с ёмкостью DEFAULT_CAPACITY
    public abstract BoundedStack<T> BoundedStack();

    // постусловие: создан новый пустой стек с ёмкостью capacity
    public abstract BoundedStack<T> BoundedStack(int capacity);

    // команды:

    // предусловие: в стеке есть свободное место
    // постусловие: в стек добавлено новое значение
    public abstract void push(T value);

    // предусловие: стек не пустой
    // постусловие: из стека удалён верхний элемент
    public abstract void pop();

    // постусловие: из стека удалены все значения
    public abstract void clear();

    // запросы:

    // предусловие: стек не пустой
    public abstract T peek();

    public abstract int size();

    // дополнительные запросы:
    public abstract int get_pop_status(); // возвращает значение POP_*
    public abstract int get_peek_status(); // возвращает значение PEEK_*
    public abstract int get_push_status(); // возвращает значение PUSH_*
}
*/

import java.util.ArrayList;
import java.util.List;

class BoundedStack<T> {
    //Скрытые поля
    private final List<T> stack;
    private final int capacity;
    private int peekStatus;
    private int popStatus;
    private int pushStatus;

    //Интерфейс класса, реализующий АТД BoundedStack
    public static final int DEFAULT_CAPACITY = 32;

    public static final int POP_NIL = 0;
    public static final int POP_OK = 1;
    public static final int POP_ERR = 2;

    public static final int PEEK_NIL = 0;
    public static final int PEEK_OK = 1;
    public static final int PEEK_ERR = 2;

    public static final int PUSH_NIL = 0;
    public static final int PUSH_OK = 1;
    public static final int PUSH_ERR = 2;

    public BoundedStack() {
        stack = new ArrayList<>(DEFAULT_CAPACITY);
        capacity = DEFAULT_CAPACITY;
        clearStatuses();
    }

    public BoundedStack(int capacity) {
        stack = new ArrayList<>(capacity);
        this.capacity = capacity;
        clearStatuses();
    }

    public void push(T value) {
        if (size() < capacity) {
            stack.add(value);
            pushStatus = PUSH_OK;
        } else {
            pushStatus = PUSH_ERR;
        }
    }

    public void pop() {
        if (size() > 0) {
            stack.remove(stack.size() - 1);
            popStatus = POP_OK;
        } else {
            popStatus = POP_ERR;
        }
    }

    public void clear() {
        stack.clear();
        clearStatuses();
    }

    public T peek() {
        T result = null;
        if (size() > 0) {
            result = stack.get(stack.size() - 1);
            peekStatus = PEEK_OK;
        } else {
            peekStatus = PEEK_ERR;
        }
        return result;
    }

    public int size() {
        return stack.size();
    }


    // Запросы статусов
    public int getPopStatus() {
        return popStatus;
    }

    public int getPeekStatus() {
        return peekStatus;
    }

    public int getPushStatus() {
        return pushStatus;
    }

    private void clearStatuses() {
        popStatus = POP_NIL;
        peekStatus = PEEK_NIL;
        pushStatus = PUSH_NIL;
    }
}