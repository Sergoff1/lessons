import java.util.*;

public class Level1
{
    public static boolean Football(int F[], int N) {
        ArrayList<Integer> indexes = new ArrayList<>();  //Indexes of elements for permutation
        int discrepanciesNum = 0;            //Number of elements to permute
        int temp;
        int[] sortedF = Arrays.copyOf(F, N);
        Arrays.sort(sortedF);

        if (Arrays.equals(F, sortedF)) {
            return true;
        }

        for (int i = 0; i < N; i++) {      //Find the number of discrepancies and save their indexes
            if (F[i] != sortedF[i]) {
                discrepanciesNum++;
                indexes.add(i);
            }
        }

        if (discrepanciesNum == 2) {      //Trying to sort the array by permuting two elements
            temp = F[indexes.get(0)];
            F[indexes.get(0)] = F[indexes.get(indexes.size()-1)];
            F[indexes.get(indexes.size()-1)] = temp;
        } else {                            //There are more than two elements to permute
            int count = 0;
            for (int i = indexes.get(0); i <= (indexes.get(indexes.size()-1) + indexes.get(0)) / 2; i++) { //setting the discrepancies elements in reverse order 
                temp = F[i];
                F[i] = F[indexes.get(indexes.size()-1) - count];
                F[indexes.get(indexes.size()-1) - count] = temp;
                count++;
            }
        }

        return Arrays.equals(F, sortedF);
    }
}
