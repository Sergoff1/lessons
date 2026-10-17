package task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortLevel_3 {

    @Test
    void ArrayChunkEmptyArrayTest() {
        int[] arr = new int[]{};
        assertEquals(-1, SortLevel.ArrayChunk(arr));
    }

    @Test
    void ArrayChunkOneElementArrayTest() {
        int[] arr = new int[]{1};
        int[] expected = new int[]{1};
        int pivotIdx = SortLevel.ArrayChunk(arr);
        assertEquals(0, pivotIdx);
        assertArrayEquals(expected, arr);
    }

    @Test
    void ArrayChunkSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int pivotIdx = SortLevel.ArrayChunk(arr);
        assertEquals(4, pivotIdx);
        assertArrayEquals(expected, arr);
    }

    @Test
    void ArrayChunkAlmostSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 6, 5, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int pivotIdx = SortLevel.ArrayChunk(arr);
        assertEquals(4, pivotIdx);
        assertArrayEquals(expected, arr);
    }

    @Test
    void ArrayChunkFromExampleTest() {
        int[] arr = new int[]{7, 5, 6, 4, 3, 1, 2};
        int[] expected = new int[]{2, 1, 3, 4, 6, 5, 7};
        int pivotIdx = SortLevel.ArrayChunk(arr);
        assertEquals(3, pivotIdx);
        assertArrayEquals(expected, arr);
    }

    @Test
    void ArrayChunkTest() {
        int[] arr = new int[]{7, 6, 5, 2, 3, 1, 4};
        int[] expected = new int[]{1, 2, 5, 6, 3, 7, 4};
        int pivotIdx = SortLevel.ArrayChunk(arr);
        assertEquals(1, pivotIdx);
        assertArrayEquals(expected, arr);
    }

}
