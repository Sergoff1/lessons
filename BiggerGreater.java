import java.util.*;

public class Level1
{
    public static String BiggerGreater(String input) {
        int temp = -35;
        int firstIndexForSwap = input.length()-1;
        int secondIndexForSwap = 0;
        boolean unaltered = true;
        char[] arrChar = input.toCharArray();

        for (int i = arrChar.length -1; i > 0; i--){          //Checking for conversion capability
            if (arrChar[i] > arrChar[i-1]) {
                unaltered = false;
                break;
            }
        }

        if (unaltered) {
            return "";
        }

        do {                                       //Looking for the index of the first element to permute
            firstIndexForSwap--;
        } while (arrChar[firstIndexForSwap] >= arrChar[firstIndexForSwap+1]);

        secondIndexForSwap = firstIndexForSwap + 1;                                         //Primary index value of the second element
        for (int i = firstIndexForSwap + 1; i < input.length(); i++) {                      //Looking for the index of the second element
            if (arrChar[firstIndexForSwap] - arrChar[i] < 0 && arrChar[firstIndexForSwap] - arrChar[i] > temp) {
                temp = arrChar[firstIndexForSwap] - arrChar[i];
                secondIndexForSwap = i;
            }
        }

        temp = arrChar[firstIndexForSwap];                                    //Permutation
        arrChar[firstIndexForSwap] = arrChar[secondIndexForSwap];
        arrChar[secondIndexForSwap] = (char)temp;

        if (input.length()- firstIndexForSwap > 2) {                         //If more than two elements could participate in the permutation
            boolean sorted = false;
            while(!sorted) {                                                 //Sort the remaining elements in ascending order
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
