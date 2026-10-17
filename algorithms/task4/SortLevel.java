package task4;

import java.util.*;

public class SortLevel {

    public static int ArrayChunk(int[] M) {
        if (M == null || M.length == 0) {
            return -1;
        }

        int pivotIdx = M.length / 2;
        int pivotValue = M[pivotIdx];

        for (int i1 = 0, i2 = M.length - 1; ;) {
            for (; M[i1] < pivotValue; i1++) {}
            for (; M[i2] > pivotValue; i2--) {}

            if (i1 == i2 - 1 && M[i1] > M[i2]) {
                swap(M, i1, i2);
                return ArrayChunk(M);
            }

            if (i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2])) {
                return pivotIdx;
            }

            if (pivotIdx == i1 || pivotIdx == i2) {
                pivotIdx = i2 + i1 - pivotIdx;
            }

            swap(M, i1, i2);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
