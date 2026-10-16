package task3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortLevel_3 {

    @Test
    void knuthSequenceForZeroTest() {
        int arrSize = 0;
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, SortLevel.KnuthSequence(arrSize));
    }

    @Test
    void knuthSequenceForOneTest() {
        int arrSize = 1;
        List<Integer> expected = List.of(1);
        assertEquals(expected, SortLevel.KnuthSequence(arrSize));
    }

    @Test
    void knuthSequenceForThirteenTest() {
        int arrSize = 13;
        List<Integer> expected = List.of(13, 4, 1);
        assertEquals(expected, SortLevel.KnuthSequence(arrSize));
    }

    @Test
    void knuthSequenceTest() {
        int arrSize = 87;
        List<Integer> expected = List.of(40, 13, 4, 1);
        assertEquals(expected, SortLevel.KnuthSequence(arrSize));
    }

    @Test
    void shellSortEmptyArrayTest() {
        int[] arr = new int[]{};
        int[] expected = new int[]{};
        SortLevel.ShellSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void shellSortOneElementArrayTest() {
        int[] arr = new int[]{1};
        int[] expected = new int[]{1};
        SortLevel.ShellSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void shellSortSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        SortLevel.ShellSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void shellSortDescendingArrayTest() {
        int[] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7};
        SortLevel.ShellSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void shellSortTest() {
        int[] arr = new int[]{1, 6, 5, 4, 0, 2, -2};
        int[] expected = new int[]{-2, 0, 1, 2, 4, 5, 6};
        SortLevel.ShellSort(arr);
        assertArrayEquals(expected, arr);
    }
}
