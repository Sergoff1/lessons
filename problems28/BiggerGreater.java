import java.util.*;

public class Level1
{
    public static String BiggerGreater(String input) {

        boolean isUnaltered = true;
        char[] arrChar = input.toCharArray();

        for (int i = arrChar.length -1; i > 0; i--){
            if (arrChar[i] > arrChar[i-1]) { //Checking for conversion capability
                isUnaltered = false;
                break;
            }
        }

        if (isUnaltered) {
            return "";
        }

        int firstIndexForSwap = input.length()-1;
        do {
            firstIndexForSwap--;
        } while (arrChar[firstIndexForSwap] >= arrChar[firstIndexForSwap+1]);

        int temp = -35;
        int secondIndexForSwap = firstIndexForSwap + 1;  //Primary index value of the second element
        for (int i = firstIndexForSwap + 1; i < input.length(); i++) {  //Looking for the index of the second element
            if (arrChar[firstIndexForSwap] - arrChar[i] < 0 && arrChar[firstIndexForSwap] - arrChar[i] > temp) {
                temp = arrChar[firstIndexForSwap] - arrChar[i];
                secondIndexForSwap = i;
            }
        }

        temp = arrChar[firstIndexForSwap];
        arrChar[firstIndexForSwap] = arrChar[secondIndexForSwap];
        arrChar[secondIndexForSwap] = (char)temp;

        if (input.length()- firstIndexForSwap > 2) {  //If more than two elements could participate in the permutation
            boolean sorted = false;
            while(!sorted) {
                sorted = true;
                for (int i = firstIndexForSwap+1; i < input.length() - 1; i++) {
                    if (arrChar[i] > arrChar[i+1]) {
                        temp = arrChar[i];
                        arrChar[i] = arrChar[i+1];
                        arrChar[i+1] = (char)temp;
                        sorted = false;
                    }
                }
            }
        }
        
        return String.valueOf(arrChar);
    }
}
