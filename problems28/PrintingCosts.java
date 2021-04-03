import java.util.*;

public class Level1
{
    public static int PrintingCosts(String Line)
      {
        int result = 0;
        HashMap<Character, Integer> tonerConsumption = new HashMap<Character, Integer>();
        tonerConsumption.put(' ', 0);
        tonerConsumption.put('&', 24);
        tonerConsumption.put(',', 7);
        tonerConsumption.put('2', 22);
        tonerConsumption.put('8', 23);
        tonerConsumption.put('>', 10);
        tonerConsumption.put('D', 26);
        tonerConsumption.put('J', 18);
        tonerConsumption.put('P', 23);
        tonerConsumption.put('V', 19);
        tonerConsumption.put('\\', 10);
        tonerConsumption.put('b', 25);
        tonerConsumption.put('h', 21);
        tonerConsumption.put('n', 18);
        tonerConsumption.put('t', 17);
        tonerConsumption.put('z', 19);
        tonerConsumption.put('!', 9);
        tonerConsumption.put('\'', 3);
        tonerConsumption.put('-', 7);
        tonerConsumption.put('3', 23);
        tonerConsumption.put('9', 26);
        tonerConsumption.put('?', 15);
        tonerConsumption.put('E', 26);
        tonerConsumption.put('K', 21);
        tonerConsumption.put('Q', 31);
        tonerConsumption.put('W', 26);
        tonerConsumption.put(']', 18);
        tonerConsumption.put('c', 17);
        tonerConsumption.put('i', 15);
        tonerConsumption.put('o', 20);
        tonerConsumption.put('u', 17);
        tonerConsumption.put('{', 18);
        tonerConsumption.put('"', 6);
        tonerConsumption.put('(', 12);
        tonerConsumption.put('.', 4);
        tonerConsumption.put('4', 21);
        tonerConsumption.put(':', 8);
        tonerConsumption.put('@', 32);
        tonerConsumption.put('F', 20);
        tonerConsumption.put('L', 16);
        tonerConsumption.put('R', 28);
        tonerConsumption.put('X', 18);
        tonerConsumption.put('^', 7);
        tonerConsumption.put('d', 25);
        tonerConsumption.put('j', 20);
        tonerConsumption.put('p', 25);
        tonerConsumption.put('v', 13);
        tonerConsumption.put('|', 12);
        tonerConsumption.put('#', 24);
        tonerConsumption.put(')', 12);
        tonerConsumption.put('/', 10);
        tonerConsumption.put('5', 27);
        tonerConsumption.put(';', 11);
        tonerConsumption.put('A', 24);
        tonerConsumption.put('G', 25);
        tonerConsumption.put('M', 28);
        tonerConsumption.put('S', 25);
        tonerConsumption.put('Y', 14);
        tonerConsumption.put('_', 8);
        tonerConsumption.put('e', 23);
        tonerConsumption.put('k', 21);
        tonerConsumption.put('q', 25);
        tonerConsumption.put('w', 19);
        tonerConsumption.put('}', 18);
        tonerConsumption.put('$', 29);
        tonerConsumption.put('*', 17);
        tonerConsumption.put('0', 22);
        tonerConsumption.put('6', 26);
        tonerConsumption.put('<', 10);
        tonerConsumption.put('B', 29);
        tonerConsumption.put('H', 25);
        tonerConsumption.put('N', 25);
        tonerConsumption.put('T', 16);
        tonerConsumption.put('Z', 22);
        tonerConsumption.put('`', 3);
        tonerConsumption.put('f', 18);
        tonerConsumption.put('l', 16);
        tonerConsumption.put('r', 13);
        tonerConsumption.put('x', 13);
        tonerConsumption.put('~', 9);
        tonerConsumption.put('%', 22);
        tonerConsumption.put('+', 13);
        tonerConsumption.put('1', 19);
        tonerConsumption.put('7', 16);
        tonerConsumption.put('=', 14);
        tonerConsumption.put('C', 20);
        tonerConsumption.put('I', 18);
        tonerConsumption.put('O', 26);
        tonerConsumption.put('U', 23);
        tonerConsumption.put('[', 18);
        tonerConsumption.put('a', 23);
        tonerConsumption.put('g', 30);
        tonerConsumption.put('m', 22);
        tonerConsumption.put('s', 21);
        tonerConsumption.put('y', 24);
        char [] arr = Line.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (tonerConsumption.containsKey(arr[i])) {
                result += tonerConsumption.get(arr[i]);
            } else {
                result += 23;
            }
        }
        return result;
      }
}