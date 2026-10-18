package task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortLevel_3 {

    @Test
    void QuickSortEmptyArrayTest() {
        int[] arr = new int[]{};
        int[] expected = new int[]{};
        SortLevel.QuickSort(arr, 0, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortOneElementArrayTest() {
        int[] arr = new int[]{1};
        int[] expected = new int[]{1};
        SortLevel.QuickSort(arr, 0, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        SortLevel.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortAlmostSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 6, 5, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        SortLevel.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void QuickSortTest() {
        int[] arr = new int[]{0, -3, 5, 2, 3, 1, 4};
        int[] expected = new int[]{-3, 0, 1, 2, 3, 4, 5};
        SortLevel.QuickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

}
