package TwoWayList;

public class TwoWayListImpl<T> extends ParentListImpl<T> {

    public static final int LEFT_NIL = 0;
    public static final int LEFT_OK = 1;
    public static final int LEFT_ERR = 2;

    private int leftStatus;

    public TwoWayListImpl() {
        clear();
    }

    //предусловие: левее курсора есть элемент
    //постусловие: курсор сдвинут на один узел влево
    public void left() {
        if (isValue() && !isHead()) {
            cursor = cursor.previous;
            leftStatus = LEFT_OK;
        } else {
            leftStatus = LEFT_ERR;
        }
    }

    @Override
    public void clear() {
        super.clear();
        leftStatus = LEFT_NIL;
    }

    public int getLeftStatus() {
        return leftStatus;
    }

}