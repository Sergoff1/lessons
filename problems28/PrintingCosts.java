import java.util.*;

public class Level1
{
    public static int getTonerCosts(String Line)
      {
        HashMap<Character, Integer> symbolsCost = new HashMap<Character, Integer>();
        symbolsCost.put(' ', 0);
        symbolsCost.put('&', 24);
        symbolsCost.put(',', 7);
        symbolsCost.put('2', 22);
        symbolsCost.put('8', 23);
        symbolsCost.put('>', 10);
        symbolsCost.put('D', 26);
        symbolsCost.put('J', 18);
        symbolsCost.put('P', 23);
        symbolsCost.put('V', 19);
        symbolsCost.put('\\', 10);
        symbolsCost.put('b', 25);
        symbolsCost.put('h', 21);
        symbolsCost.put('n', 18);
        symbolsCost.put('t', 17);
        symbolsCost.put('z', 19);
        symbolsCost.put('!', 9);
        symbolsCost.put('\'', 3);
        symbolsCost.put('-', 7);
        symbolsCost.put('3', 23);
        symbolsCost.put('9', 26);
        symbolsCost.put('?', 15);
        symbolsCost.put('E', 26);
        symbolsCost.put('K', 21);
        symbolsCost.put('Q', 31);
        symbolsCost.put('W', 26);
        symbolsCost.put(']', 18);
        symbolsCost.put('c', 17);
        symbolsCost.put('i', 15);
        symbolsCost.put('o', 20);
        symbolsCost.put('u', 17);
        symbolsCost.put('{', 18);
        symbolsCost.put('"', 6);
        symbolsCost.put('(', 12);
        symbolsCost.put('.', 4);
        symbolsCost.put('4', 21);
        symbolsCost.put(':', 8);
        symbolsCost.put('@', 32);
        symbolsCost.put('F', 20);
        symbolsCost.put('L', 16);
        symbolsCost.put('R', 28);
        symbolsCost.put('X', 18);
        symbolsCost.put('^', 7);
        symbolsCost.put('d', 25);
        symbolsCost.put('j', 20);
        symbolsCost.put('p', 25);
        symbolsCost.put('v', 13);
        symbolsCost.put('|', 12);
        symbolsCost.put('#', 24);
        symbolsCost.put(')', 12);
        symbolsCost.put('/', 10);
        symbolsCost.put('5', 27);
        symbolsCost.put(';', 11);
        symbolsCost.put('A', 24);
        symbolsCost.put('G', 25);
        symbolsCost.put('M', 28);
        symbolsCost.put('S', 25);
        symbolsCost.put('Y', 14);
        symbolsCost.put('_', 8);
        symbolsCost.put('e', 23);
        symbolsCost.put('k', 21);
        symbolsCost.put('q', 25);
        symbolsCost.put('w', 19);
        symbolsCost.put('}', 18);
        symbolsCost.put('$', 29);
        symbolsCost.put('*', 17);
        symbolsCost.put('0', 22);
        symbolsCost.put('6', 26);
        symbolsCost.put('<', 10);
        symbolsCost.put('B', 29);
        symbolsCost.put('H', 25);
        symbolsCost.put('N', 25);
        symbolsCost.put('T', 16);
        symbolsCost.put('Z', 22);
        symbolsCost.put('`', 3);
        symbolsCost.put('f', 18);
        symbolsCost.put('l', 16);
        symbolsCost.put('r', 13);
        symbolsCost.put('x', 13);
        symbolsCost.put('~', 9);
        symbolsCost.put('%', 22);
        symbolsCost.put('+', 13);
        symbolsCost.put('1', 19);
        symbolsCost.put('7', 16);
        symbolsCost.put('=', 14);
        symbolsCost.put('C', 20);
        symbolsCost.put('I', 18);
        symbolsCost.put('O', 26);
        symbolsCost.put('U', 23);
        symbolsCost.put('[', 18);
        symbolsCost.put('a', 23);
        symbolsCost.put('g', 30);
        symbolsCost.put('m', 22);
        symbolsCost.put('s', 21);
        symbolsCost.put('y', 24);
/*TODO - избавиться от printedCharacters и заменить обращение к массиву
на извлечение символов из строки
Сделать к версии 1.3*/
        char [] printedСharacters = Line.toCharArray();
        int tonerCostsTotal = 0;
        
        for (int i = 0; i < printedСharacters.length; i++) {
            if (symbolsCost.containsKey(printedСharacters[i])) {
                tonerCostsTotal += symbolsCost.get(printedСharacters[i]);
            } else {
                tonerCostsTotal += 23;
            }
        }
        return tonerCostsTotal;
      }
}