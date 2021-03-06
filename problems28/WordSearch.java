import java.util.*;

public class Level1
{
    public static int [] WordSearch(int len, String s, String subs)
      {

        if (len < 1) {
            System.out.println("Ширина выравнивания не может быть меньше 1");
        }

        String [] wordsFromThePassedString = s.split(" ");
        ArrayList<String> PhrasesList = new ArrayList<String>();
        StringBuilder stringBuffer = new StringBuilder();
        int occupiedCharsInLine = 0;
        int indexOfTheCurrentWord = 0;

        while (indexOfTheCurrentWord != wordsFromThePassedString.length) {
            if (occupiedCharsInLine == 0 && wordsFromThePassedString[indexOfTheCurrentWord].length() > len) {
                PhrasesList.add(wordsFromThePassedString[indexOfTheCurrentWord].substring(0, len));
                int count = 2;
                while (wordsFromThePassedString[indexOfTheCurrentWord].length() - count * len > 0) {
                    PhrasesList.add(wordsFromThePassedString[indexOfTheCurrentWord].substring((count-1)*len, count*len));
                    count++;
                }
                stringBuffer.append(wordsFromThePassedString[indexOfTheCurrentWord].substring((count-1)*len)).append(" ");
                occupiedCharsInLine += wordsFromThePassedString[indexOfTheCurrentWord].substring((count-1)*len).length() + 1;
                indexOfTheCurrentWord++;
                continue;
            }

            if (occupiedCharsInLine + wordsFromThePassedString[indexOfTheCurrentWord].length() <= len) {
                occupiedCharsInLine += wordsFromThePassedString[indexOfTheCurrentWord].length() + 1;
                stringBuffer.append(wordsFromThePassedString[indexOfTheCurrentWord]).append(" ");
                indexOfTheCurrentWord++;
            } else {   
                PhrasesList.add(stringBuffer.toString().trim());
                stringBuffer.delete(0, stringBuffer.length());
                occupiedCharsInLine = 0;
            }

        }

        if (stringBuffer.length() > 0) {
        PhrasesList.add(stringBuffer.toString().trim());
        }

        return linesContainingWord(PhrasesList, subs);
    }
    
    private static int [] linesContainingWord(ArrayList<String> PhrasesList, String subs) {

        int [] linesWithInputWord = new int[PhrasesList.size()];
        int stringNumber = 0;

        for (String elem : PhrasesList) {
            boolean isFirstWord = elem.startsWith(subs) && elem.contains(subs+"\s");
            boolean isLastWord =  elem.contains("\s"+subs) && elem.endsWith(subs);
            boolean isMiddleWord = elem.contains("\s"+subs+"\s");
            boolean isSingleWord = elem.startsWith(subs) && elem.endsWith(subs);
            if (isFirstWord || isLastWord || isMiddleWord || isSingleWord) {
                linesWithInputWord [stringNumber] = 1;
            }
            stringNumber++;
        }
        return linesWithInputWord;
    }
}