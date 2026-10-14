package task1;

import java.util.*;

public class SortLevel
{
    public static void SelectionSortStep(int[] array, int i) {
        int minIdx = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIdx]) {
                minIdx = j;
            }
        }
        if (minIdx != i) {
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    public static boolean BubbleSortStep(int[] array) {
        boolean hasNoSwaps = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                hasNoSwaps = false;
            }
        }
        return hasNoSwaps;
    }
}
