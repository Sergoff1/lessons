package task10;

public class ksort {

    public String[] items;

    public ksort() {
        items = new String[800];
    }

    public int index(String s) {
        if (s == null || !s.matches("[a-h]\\d{2}")) {
            return -1;
        }

        return (s.charAt(0) - 'a') * 100
               + Character.getNumericValue(s.charAt(1)) * 10
               + Character.getNumericValue(s.charAt(2));
    }

    public boolean add(String s) {
        int index = index(s);

        if (index == -1) {
            return false;
        }

        items[index] = s;
        return true;
    }
}
