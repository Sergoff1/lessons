package task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortLevel_3 {

    @Test
    void QuickSortTailOptimizationEmptyArrayTest() {
        int[] arr = new int[]{};
        int[] expected = new int[]{};
        SortLevel.QuickSortTailOptimization(arr, 0, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortTailOptimizationOneElementArrayTest() {
        int[] arr = new int[]{1};
        int[] expected = new int[]{1};
        SortLevel.QuickSortTailOptimization(arr, 0, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortTailOptimizationSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        SortLevel.QuickSortTailOptimization(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortTailOptimizationAlmostSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 6, 5, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        SortLevel.QuickSortTailOptimization(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortTailOptimizationTest() {
        int[] arr = new int[]{0, -3, 5, 2, 3, 1, 4};
        int[] expected = new int[]{-3, 0, 1, 2, 3, 4, 5};
        SortLevel.QuickSortTailOptimization(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortTailOptimizationLargeTest() {
        int[] arr = new int[]{0, -3, 5, 2, 1, 3, 4, 8, -4, -2};
        int[] expected = new int[]{-4, -3, -2, 0, 1, 2, 3, 4, 5, 8};
        SortLevel.QuickSortTailOptimization(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

}
