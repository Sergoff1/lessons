import java.util.*;

public class Level1
{
    public static boolean Football(int F[], int N) {
        ArrayList<Integer> indexesList = new ArrayList<>();  //Indexes of elements for permutation
        int[] sortedF = Arrays.copyOf(F, N);
        Arrays.sort(sortedF);

        if (Arrays.equals(F, sortedF)) {
            return false;
        }

        int discrepanciesNum = 0;            //Number of elements to permute
        for (int i = 0; i < N; i++) {      //Find the number of discrepancies and save their indexesList
            if (F[i] != sortedF[i]) {
                discrepanciesNum++;
                indexesList.add(i);
            }
        }

        int temp;
        if (discrepanciesNum == 2) {      //Trying to sort the array by permuting two elements
            temp = F[indexesList.get(0)];
            F[indexesList.get(0)] = F[indexesList.get(indexesList.size()-1)];
            F[indexesList.get(indexesList.size()-1)] = temp;
        } else {                            //There are more than two elements to permute
            int count = 0;
            for (int i = indexesList.get(0); i <= (indexesList.get(indexesList.size()-1) + indexesList.get(0)) / 2; i++) { //setting the discrepancies elements in reverse order 
                temp = F[i];
                F[i] = F[indexesList.get(indexesList.size()-1) - count];
                F[indexesList.get(indexesList.size()-1) - count] = temp;
                count++;
            }
        }

        return Arrays.equals(F, sortedF);
    }
}
