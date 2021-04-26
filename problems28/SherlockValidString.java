import java.util.*;

public class Level1
{
    public static boolean SherlockValidString(String s)
      {
        HashMap<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
        int numOfCharOccurrences = 0;

        for (int i = 0; i < s.length(); i++) {                //Count the number of occurrences of each character in the string
            numOfCharOccurrences = 0;
            if (letterFrequency.containsKey(s.charAt(i))) {
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    numOfCharOccurrences++;
                }
            }
            letterFrequency.put(s.charAt(i), numOfCharOccurrences);
        }
        numOfCharOccurrences = -1;

        Iterator<Character> iter = letterFrequency.keySet().iterator();
        Character firstElem, secondElem;
        int difference = 0;
        boolean mayDeleted = true;
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
        boolean valid = true;
        
        while (iter.hasNext()) {
            secondElem = iter.next();
            difference = letterFrequency.get(firstElem) - letterFrequency.get(secondElem);
            if (difference != 0 && !mayDeleted) {                 //If there are excess characters
                valid = false;
                break;
            }
            firstElem = secondElem;
        }
        return valid;
      }
}