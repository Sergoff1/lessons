import java.util.*;

public class Level1
{
    public static boolean SherlockValidString(String s)
      {
        HashMap<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
        int numOfSimbols = 0;
        int difference = 0;
        boolean result = true;
        boolean mayDeleted = true;

        for (int i = 0; i < s.length(); i++) {                //Count the number of occurrences of each character in the string
            numOfSimbols = 0;
            if (letterFrequency.containsKey(s.charAt(i))) {
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    numOfSimbols++;
                }
            }
            letterFrequency.put(s.charAt(i), numOfSimbols);
        }

        Iterator<Character> iter = letterFrequency.keySet().iterator();
        Character firstElem, secondElem;

        firstElem = iter.next();
        while (iter.hasNext()) {
            secondElem = iter.next();
            difference = letterFrequency.get(firstElem) - letterFrequency.get(secondElem);
            if (difference != 0 && mayDeleted) {                //Removing excess character
                switch (difference) {
                    case 1:
                    letterFrequency.put(firstElem,letterFrequency.get(firstElem) - 1);
                    break;

                    case -1:
                    letterFrequency.put(secondElem,letterFrequency.get(secondElem) - 1);
                    break;

                    default:
                    if (letterFrequency.get(firstElem) == 1) {
                        letterFrequency.remove(firstElem);
                    } else if (letterFrequency.get(secondElem) == 1) {
                        letterFrequency.remove(secondElem);
                    }
                }
                mayDeleted = false;
                break;
            }
            firstElem = secondElem;
        }

        iter = letterFrequency.keySet().iterator();
        firstElem = iter.next();
        while (iter.hasNext()) {
            secondElem = iter.next();
            difference = letterFrequency.get(firstElem) - letterFrequency.get(secondElem);
            if (difference != 0 && !mayDeleted) {                 //If there are excess characters
                result = false;
                break;
            }
            firstElem = secondElem;
        }
        return result;
      }
}