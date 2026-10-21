package task8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortLevel_3 {

    @Test
    void MergeSortEmptyArrayTest() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        List<Integer> result = SortLevel.MergeSort(list);
        assertEquals(expected, result);
    }

    @Test
    void MergeSortOneElementArrayTest() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1));
        List<Integer> expected = List.of(1);
        ArrayList<Integer> result = SortLevel.MergeSort(list);
        assertEquals(expected, result);
    }

    @Test
    void MergeSortSortedArrayTest() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        ArrayList<Integer> result = SortLevel.MergeSort(list);
        assertEquals(expected, result);
    }

    @Test
    void MergeSortAlmostSortedArrayTest() {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 6, 5, 7, 8));
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        ArrayList<Integer> result = SortLevel.MergeSort(list);
        assertEquals(expected, result);
    }

    @Test
    void MergeSortDescendingSortedArrayTest() {
        ArrayList<Integer> list = new ArrayList<>(List.of(8, 7, 6, 5, 4, 3, 2, 1));
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        ArrayList<Integer> result = SortLevel.MergeSort(list);
        assertEquals(expected, result);
    }

    @Test
    void MergeSortTest() {
        ArrayList<Integer> list = new ArrayList<>(List.of(0, -3, 5, 2, 3, 1, 4));
        List<Integer> expected = List.of(-3, 0, 1, 2, 3, 4, 5);
        ArrayList<Integer> result = SortLevel.MergeSort(list);
        assertEquals(expected, result);
    }

}
