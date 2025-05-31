package TwoWayList;

public abstract class ParentListImpl<T> {
    public static final int HEAD_NIL = 0;
    public static final int HEAD_OK = 1;
    public static final int HEAD_ERR = 2;

    public static final int TAIL_NIL = 0;
    public static final int TAIL_OK = 1;
    public static final int TAIL_ERR = 2;

    public static final int RIGHT_NIL = 0;
    public static final int RIGHT_OK = 1;
    public static final int RIGHT_ERR = 2;

    public static final int ADD_TO_EMPTY_NIL = 0;
    public static final int ADD_TO_EMPTY_OK = 1;
    public static final int ADD_TO_EMPTY_ERR = 2;

    public static final int PUT_RIGHT_NIL = 0;
    public static final int PUT_RIGHT_OK = 1;
    public static final int PUT_RIGHT_ERR = 2;

    public static final int PUT_LEFT_NIL = 0;
    public static final int PUT_LEFT_OK = 1;
    public static final int PUT_LEFT_ERR = 2;

    public static final int REMOVE_NIL = 0;
    public static final int REMOVE_OK = 1;
    public static final int REMOVE_ERR = 2;

    public static final int REPLACE_NIL = 0;
    public static final int REPLACE_OK = 1;
    public static final int REPLACE_ERR = 2;

    public static final int FIND_NIL = 0;
    public static final int FIND_OK = 1;
    public static final int FIND_ERR = 2;

    public static final int GET_NIL = 0;
    public static final int GET_OK = 1;
    public static final int GET_ERR = 2;


    //Скрытые поля
    protected Node<T> cursor;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private int headStatus;
    private int tailStatus;
    private int rightStatus;
    private int addToEmptyStatus;
    private int putRightStatus;
    private int putLeftStatus;
    private int removeStatus;
    private int replaceStatus;
    private int findStatus;
    private int getStatus;

    //Конструкторы

    //постусловие: создан новый пустой список
    public ParentListImpl() { //Тип возвращаемого значения ParentList<T>
        clear();
    };

    //Команды

    //предусловие: список не пустой
    //постусловие: курсор указывает на первый узел в списке
    public void head() {
        if (isValue()) {
            cursor = head;
            headStatus = HEAD_OK;
        } else {
            headStatus = HEAD_ERR;
        }
    }

    //предусловие: список не пустой
    //постусловие: курсор указывает на последний узел в списке
    public void tail() {
        if (isValue()) {
            cursor = tail;
            headStatus = TAIL_OK;
        } else {
            headStatus = TAIL_ERR;
        }
    }

    //предусловие: правее курсора есть элемент
    //постусловие: курсор сдвинут на один узел вправо
    public void right() {
        if (isValue() && !isTail()) {
            cursor = cursor.next;
            rightStatus = RIGHT_OK;
        } else {
            rightStatus = RIGHT_ERR;
        }
    }

    //предусловие: список не пустой
    //постусловие: в список добавлен новый узел справа от узла, на который указывает курсор
    public void putRight(T value) {
        if (isValue()) {
            Node<T> node = new Node<>(value);
            node.next = cursor.next;
            node.previous = cursor;
            cursor.next = node;
            if (node.next != null) {
                node.next.previous = node;
            }

            size++;
            putRightStatus = PUT_RIGHT_OK;
        } else {
            putRightStatus = PUT_RIGHT_ERR;
        }
    }

    //предусловие: список не пустой
    //постусловие: в список добавлен новый узел, слева от узла, на который указывает курсор
    public void putLeft(T value) {
        if (isValue()) {
            Node<T> node = new Node<>(value);
            node.next = cursor;
            node.previous = cursor.previous;
            cursor.previous = node;
            if (node.previous != null) {
                node.previous.next = node;
            }

            size++;
            putLeftStatus = PUT_LEFT_OK;
        } else {
            putLeftStatus = PUT_LEFT_ERR;
        }
    }

    //предусловие: список не пустой
    //постусловие: из списка удалён узел, положение курсора изменилось(сместился к правому соседу (при наличии) или к левому (при наличии))
    public void remove() {
        if (isValue()) {
            if (isHead() && isTail()) {
                cursor = null;
                head = null;
                tail = null;
            } else if (isHead()) {
                cursor = cursor.next;
                head = cursor;
                cursor.previous = null;
            } else if (isTail()) {
                cursor = cursor.previous;
                tail = cursor;
                cursor.next = null;
            } else {
                cursor.next.previous = cursor.previous;
                cursor.previous.next = cursor.next;
                cursor = cursor.next;
            }

            size--;
            removeStatus = REMOVE_OK;
        } else {
            removeStatus = REMOVE_ERR;
        }
    }

    //постусловие: из списка удалены все узлы
    public void clear() {
        head = null;
        tail = null;
        cursor = null;
        size = 0;

        headStatus = HEAD_NIL;
        tailStatus = TAIL_NIL;
        rightStatus = RIGHT_NIL;
        addToEmptyStatus = ADD_TO_EMPTY_NIL;
        putRightStatus = PUT_RIGHT_NIL;
        putLeftStatus = PUT_LEFT_NIL;
        removeStatus = REMOVE_NIL;
        replaceStatus = REPLACE_NIL;
        findStatus = FIND_NIL;
        getStatus = GET_NIL;
    }

    //предусловие: список пуст
    //постусловие: в списке появился один узел
    public void addToEmpty(T value) {
        if (!isValue()) {
            cursor = new Node<>(value);
            head = cursor;
            tail = cursor;
            addToEmptyStatus = ADD_TO_EMPTY_OK;
            size = 1;
        } else {
            addToEmptyStatus = ADD_TO_EMPTY_ERR;
        }
    }

    //постусловие: в хвост списка добавлен новый узел
    public void addTail(T value) {
        Node<T> node = new Node<>(value);
        if (!isValue()) {
            cursor = node;
            tail = cursor;
            head = cursor;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //предусловие: список не пустой
    //постусловие: в списке изменилось значение текущего узла
    public void replace(T value) {
        if (isValue()) {
            cursor.value = value;
            replaceStatus = REPLACE_OK;
        } else {
            replaceStatus = REPLACE_ERR;
        }
    }

    //постусловие: курсор указывает на следующий узел с искомым значение
    public void find(T value) {
        findStatus = FIND_ERR;
        if (isValue()) {
            while (cursor != tail) {
                cursor = cursor.next;
                if (cursor.value == value) {
                    findStatus = FIND_OK;
                    break;
                }
            }
        }
    }

    //постусловие: из списка удалены все узлы с указанным значением, если такие были
    public void remove_all(T value) {
        cursor = head;
        while (!isTail()) {
            find(value);
            if (findStatus == FIND_OK) {
                remove();
            } else {
                break;
            }
        }
    }

    //Запросы

    //предусловие: список не пустой
    public T get() {
        T result = null;
        if (isValue()) {
            result = cursor.value;
            getStatus = GET_OK;
        } else {
            getStatus = GET_ERR;
        }
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isHead() {
        return cursor == head;
    }

    public boolean isTail() {
        return cursor == tail;
    }

    public boolean isValue() {
        return cursor != null;
    }

    //Дополнительные запросы
    public int getHeadStatus() {
        return headStatus;
    }
    public int getTailStatus() {
        return tailStatus;
    }
    public int getRightStatus() {
        return rightStatus;
    }
    public int getAddToEmptyStatus() {
        return addToEmptyStatus;
    }
    public int getPutRightStatus() {
        return putRightStatus;
    }
    public int getPutLeftStatus() {
        return putLeftStatus;
    }
    public int getRemoveStatus() {
        return removeStatus;
    }
    public int getReplaceStatus() {
        return replaceStatus;
    }
    public int getFindStatus() {
        return findStatus;
    }
    public int getGetStatus() {
        return getStatus;
    }
}