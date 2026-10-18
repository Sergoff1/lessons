package task6;

public class SortLevel {

    public static void QuickSortTailOptimization(int[] array, int left, int right) {
        if (array == null || array.length < 2) {
            return;
        }

        while (left < right) {
            int pivotIdx = arrayChunk(array, left, right);

            QuickSortTailOptimization(array, left, pivotIdx - 1);
            left = pivotIdx + 1;
        }
    }

    private static int arrayChunk(int[] array, int left, int right) {
        if (array == null || array.length == 0) {
            return -1;
        }

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
