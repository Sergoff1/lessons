### Наследование реализации

Класс TwoWayListImpl наследует LinkedListImpl. Он использует реализацию родителя, добавляя к ней ряд своих методов.

```java
public class LinkedListImpl<T> {
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
    public LinkedListImpl() { //Тип возвращаемого значения LinkedListImpl<T>
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
    
    //Прочие методы класса...
}

public class TwoWayListImpl<T> extends LinkedListImpl<T> {
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
```

### Льготное наследование

Класс ParameterBinding для установки параметров SQL-запросов задаёт базовые методы и поля, нужные для установки параметра.
У него есть множество наследников, которые реализуют конкретные случаи установки параметров. Например, установка строкового или целочисленного параметра.  

```java
public abstract class ParameterBinding {

    protected Integer number;
    protected String name;
    protected Object value;
    protected Integer type;

    public ParameterBinding(Integer number, Object value, Integer type) {
        this.number = number;
        this.value = value;
        this.type = type;
    }

    public ParameterBinding(String name, Object value, Integer type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Object getValue() {
        return value;
    }

    public String getLogValue() {
        return String.valueOf(value);
    }

    public Integer getType() {
        return type;
    }

    protected void setNull(PreparedStatement ps) throws SQLException {
        ps.setNull(number, type);
    }

    protected void setNullNamed(NamedParameterPreparedStatement ps) throws SQLException {
        ps.setNull(name, type);
    }

    public abstract void bindSelfNamed(NamedParameterPreparedStatement ps) throws SQLException;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ParameterBinding that = (ParameterBinding) o;

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (number != null ? !number.equals(that.number) : that.number != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;
        result = (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{binding ");
        sb.append(name);
        sb.append(" to ").append(value);
        sb.append(", type ").append(type);
        sb.append("}");
        return sb.toString();
    }
}

public class IntegerParameterBinding extends ParameterBinding {

    public IntegerParameterBinding(String name, Integer value) {
        super(name, value, java.sql.Types.INTEGER);
    }

    public void bindSelfNamed(NamedParameterPreparedStatement ps) throws SQLException {
        if (value != null) {
            ps.setInt(name, (Integer) value);
        } else {
            this.setNullNamed(ps);
        }
    }
}

public class StringParameterBinding extends ParameterBinding {

    public StringParameterBinding(String name, Object value) {
        super(name, value, java.sql.Types.VARCHAR);
    }

    public void bindSelfNamed(NamedParameterPreparedStatement ps) throws SQLException {
        if (value != null) {
            ps.setString(name, value.toString());
        } else {
            this.setNullNamed(ps);
        }
    }

    public String getLogValue() {
        return "'" + value + "'";
    }
}
```

