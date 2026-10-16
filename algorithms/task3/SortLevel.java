package task3;

import java.util.ArrayList;
import java.util.List;

public class SortLevel {

    public static ArrayList<Integer> KnuthSequence(int array_size) {
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = 1; i <= array_size; i = 3 * i + 1) {
            sequence.addFirst(i);
        }
        return sequence;
    }

    public static void ShellSort(int[] array) {
        List<Integer> stepSequence = KnuthSequence(array.length);
        for (Integer step : stepSequence) {
            for (int i = 0; i < step; i++) {
                InsertionSortStep(array, step, i);
            }
        }
    }

    private static void InsertionSortStep(int[] array, int step, int i) {
        for (int j = i + step; j < array.length; j += step) {
            int value = array[j];
            int prevIdx = j - step;

            for(;prevIdx >= i && array[prevIdx] > value; prevIdx -= step) {
                array[prevIdx + step] = array[prevIdx];
            }
            array[prevIdx + step] = value;
        }
    }

}
