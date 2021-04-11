import java.util.*;

public class Level1
{
    public static int [] WordSearch(int len, String s, String subs)
      {
        String [] wordsFromThePassedString = s.split(" ");
        ArrayList<String> arrPhrases = new ArrayList<String>();
        StringBuilder stringBuffer = new StringBuilder();
        int numberOfOccupiedCharactersInTheCurrentLine = 0;
        int indexOfTheCurrentWord = 0;

        while (indexOfTheCurrentWord != wordsFromThePassedString.length) {
            if (numberOfOccupiedCharactersInTheCurrentLine == 0 && wordsFromThePassedString[indexOfTheCurrentWord].length() > len) {
                arrPhrases.add(wordsFromThePassedString[indexOfTheCurrentWord].substring(0, len));
                int ct = 2;
                while (wordsFromThePassedString[indexOfTheCurrentWord].length() - ct * len > 0) {
                    arrPhrases.add(wordsFromThePassedString[indexOfTheCurrentWord].substring((ct-1)*len, ct*len));
                    ct++;
                }
                stringBuffer.append(wordsFromThePassedString[indexOfTheCurrentWord].substring((ct-1)*len)).append(" ");
                numberOfOccupiedCharactersInTheCurrentLine += wordsFromThePassedString[indexOfTheCurrentWord].substring((ct-1)*len).length() + 1;
                indexOfTheCurrentWord++;
                continue;
            }

            if (numberOfOccupiedCharactersInTheCurrentLine + wordsFromThePassedString[indexOfTheCurrentWord].length() <= len) {
                numberOfOccupiedCharactersInTheCurrentLine += wordsFromThePassedString[indexOfTheCurrentWord].length() + 1;
                stringBuffer.append(wordsFromThePassedString[indexOfTheCurrentWord]).append(" ");
                indexOfTheCurrentWord++;
            } else {   
                arrPhrases.add(stringBuffer.toString().trim());
                stringBuffer.delete(0, stringBuffer.length());
                numberOfOccupiedCharactersInTheCurrentLine = 0;
                }

        }

        if (stringBuffer.length() > 0) {
        arrPhrases.add(stringBuffer.toString().trim());
        }
        int [] result = new int[arrPhrases.size()];
        int cnt = 0;

        for (String elem : arrPhrases) {
            if (elem.startsWith(subs) && elem.contains(subs+"\s") || elem.contains("\s"+subs) && elem.endsWith(subs) || elem.contains("\s"+subs+"\s") || elem.startsWith(subs) && elem.endsWith(subs)) {
                result [cnt] = 1;
            }
            cnt++;
        }
        return result;

    }
}