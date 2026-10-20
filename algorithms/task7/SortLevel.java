package task7;

import java.util.ArrayList;

public class SortLevel {

    public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (Array == null || Array.length == 0 || L > R) {
            return result;
        }

        int pivotIdx = arrayChunk(Array, L, R);

        if (pivotIdx == k) {
            result.add(pivotIdx);
            result.add(pivotIdx);
            return result;
        }

        if (pivotIdx < k) {
            result.add(pivotIdx + 1);
            result.add(R);
            return result;
        }

        result.add(L);
        result.add(pivotIdx - 1);
        return result;
    }

    private static int arrayChunk(int[] array, int left, int right) {
        int pivotIdx = (left + right) / 2;
        int pivotValue = array[pivotIdx];

        for (int i1 = left, i2 = right; ;) {
            for (; array[i1] < pivotValue; i1++) {}
            for (; array[i2] > pivotValue; i2--) {}

            if (i1 == i2 - 1 && array[i1] > array[i2]) {
                swap(array, i1, i2);
                return arrayChunk(array, left, right);
            }

            if (i1 == i2 || (i1 == i2 - 1 && array[i1] < array[i2])) {
                return pivotIdx;
            }

            if (pivotIdx == i1 || pivotIdx == i2) {
                pivotIdx = i2 + i1 - pivotIdx;
            }

            swap(array, i1, i2);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
