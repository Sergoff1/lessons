package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortLevel_3 {

    @Test
    void insertionSortEmptyArrayTest(){
        int[] arr = new int[]{};
        int[] expected = new int[]{};
        int step = 1;
        SortLevel.InsertionSortStep(arr, step, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void insertionSortOneElementArrayTest(){
        int[] arr = new int[]{1};
        int[] expected = new int[]{1};
        int step = 1;
        SortLevel.InsertionSortStep(arr, step, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void insertionSortSortedArrayTest(){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        int step = 2;
        SortLevel.InsertionSortStep(arr, step, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void insertionSortDescendingArrayTest(){
        int[] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        int[] expected = new int[]{1, 6, 5, 4, 3, 2, 7};
        int step = 3;
        SortLevel.InsertionSortStep(arr, step, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void insertionSortFromExampleTest(){
        int[] arr = new int[]{1, 6, 5, 4, 3, 2, 7};
        int[] expected = new int[]{1, 3, 5, 4, 6, 2, 7};
        int step = 3;
        SortLevel.InsertionSortStep(arr, step, 1);
        assertArrayEquals(expected, arr);
    }
}
