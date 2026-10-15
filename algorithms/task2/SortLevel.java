package task2;

import java.util.*;

public class SortLevel {
    public static void InsertionSortStep(int[] array, int step, int i) {
        for (int j = i + step; j < array.length; j += step) {
            int value = array[j];
            int prevIdx = j - step;

            while (prevIdx >= i && array[prevIdx] > value) {
                array[prevIdx + step] = array[prevIdx];
                prevIdx -= step;
            }
            array[prevIdx + step] = value;
        }
    }

}
