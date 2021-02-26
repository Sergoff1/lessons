import java.util.*;

public class Level1
{
    public static int [] WordSearch(int len, String s, String subs)
      {
        String [] arr = s.split(" ");
        ArrayList<String> arrPhrases = new ArrayList<String>();
        StringBuilder stringBuffer = new StringBuilder();
        int cnt = 0;
        int index = 0;
        int length = arr.length;

        while (index != length) {
            if (cnt == 0 && arr[index].length() > len) {
                arrPhrases.add(arr[index].substring(0, len));
                int ct = 2;
                while (arr[index].length() - ct * len > 0) {
                    arrPhrases.add(arr[index].substring((ct-1)*len, ct*len));
                    ct++;
                }
                stringBuffer.append(arr[index].substring((ct-1)*len)).append(" ");
                cnt += arr[index].substring((ct-1)*len).length() + 1;
                index++;
                continue;
            }

            if (cnt + arr[index].length() <= len) {
                cnt += arr[index].length() + 1;
                stringBuffer.append(arr[index]).append(" ");
                index++;
            } else {   
                arrPhrases.add(stringBuffer.toString().trim());
                stringBuffer.delete(0, stringBuffer.length());
                cnt = 0;
                }

        }

        if (stringBuffer.length() > 0) {
        arrPhrases.add(stringBuffer.toString().trim());
        }
        int [] result = new int[arrPhrases.size()];
        cnt = 0;

        for (String elem : arrPhrases) {
            if (elem.startsWith(subs) && elem.contains(subs+"\s") || elem.contains("\s"+subs) && elem.endsWith(subs) || elem.contains("\s"+subs+"\s")) {
                result [cnt] = 1;
            }
            cnt++;
        }
        return result;

    }
}