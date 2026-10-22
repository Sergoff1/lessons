package task9;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSort_3 {

    @Test
    void HeapSortEmptyArrayTest() {
        int[] arr = new int[]{};
        HeapSort heap = new HeapSort(arr);
        assertEquals(-1, heap.GetNextMax());
    }

    @Test
    void HeapSortOneElementArrayTest() {
        int[] arr = new int[]{1};
        int[] expected = new int[]{1, -1};
        HeapSort heap = new HeapSort(arr);

        for (int i : expected) {
            assertEquals(i, heap.GetNextMax());
        }
    }

    @Test
    void HeapSortSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = new int[]{8, 7, 6, 5, 4, 3, 2, 1, -1};
        HeapSort heap = new HeapSort(arr);

        for (int i : expected) {
            assertEquals(i, heap.GetNextMax());
        }
    }

    @Test
    void HeapSortDescendingSortedArrayTest() {
        int[] arr = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = new int[]{8, 7, 6, 5, 4, 3, 2, 1, -1};
        HeapSort heap = new HeapSort(arr);

        for (int i : expected) {
            assertEquals(i, heap.GetNextMax());
        }
    }

    @Test
    void HeapSortTest() {
        int[] arr = new int[]{0, 8, 4, 2, 3, 1, 4};
        int[] expected = new int[]{8, 4, 4, 3, 2, 1, 0, -1};
        HeapSort heap = new HeapSort(arr);

        for (int i : expected) {
            assertEquals(i, heap.GetNextMax());
        }
    }

}
