package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortLevel_3 {

    @Test
    void SelectionSortEmptyArrayTest() {
        int[] arr = new int[]{};
        int[] expected = new int[]{};
        SortLevel.SelectionSortStep(arr, 0);
        assertArrayEquals(arr, expected);
    }

    @Test
    void SelectionSortOneElementArrayTest() {
        int[] arr = new int[]{5};
        int[] expected = new int[]{5};
        SortLevel.SelectionSortStep(arr, 0);
        assertArrayEquals(arr, expected);
    }

    @Test
    void SelectionSortTest() {
        int[] arr = new int[]{5, 2, 4, -3, 1};
        int[] expected = new int[]{5, -3, 4, 2, 1};
        SortLevel.SelectionSortStep(arr, 1);
        assertArrayEquals(arr, expected);
    }

    @Test
    void SelectionSortLastElementTest() {
        int[] arr = new int[]{5, 1, 4, 3, 2};
        int[] expected = new int[]{5, 1, 4, 3, 2};
        SortLevel.SelectionSortStep(arr, arr.length - 1);
        assertArrayEquals(arr, expected);
    }

    @Test
    void SelectionSortSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 4};
        int[] expected = new int[]{1, 2, 3, 4, 4};
        SortLevel.SelectionSortStep(arr, 1);
        assertArrayEquals(arr, expected);
    }

    @Test
    void BubbleSortEmptyArrayTest() {
        int[] arr = new int[]{};
        int[] expected = new int[]{};
        assertTrue(SortLevel.BubbleSortStep(arr));
        assertArrayEquals(arr, expected);
    }

    @Test
    void BubbleSortOneElementArrayTest() {
        int[] arr = new int[]{2};
        int[] expected = new int[]{2};
        assertTrue(SortLevel.BubbleSortStep(arr));
        assertArrayEquals(arr, expected);
    }

    @Test
    void BubbleSortSortedArrayTest() {
        int[] arr = new int[]{-1, 2, 3, 4, 4};
        int[] expected = new int[]{-1, 2, 3, 4, 4};
        assertTrue(SortLevel.BubbleSortStep(arr));
        assertArrayEquals(arr, expected);
    }

    @Test
    void BubbleSortArrayTest() {
        int[] arr = new int[]{4, 2, -1, 0, 4};
        int[] expected = new int[]{2, -1, 0, 4, 4};
        assertFalse(SortLevel.BubbleSortStep(arr));
        assertArrayEquals(arr, expected);
    }
}
