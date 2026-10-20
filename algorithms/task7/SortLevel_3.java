package task7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortLevel_3 {

    @Test
    void KthOrderStatisticsStepEmptyArrayTest() {
        int[] arr = new int[]{};
        List<Integer> result = SortLevel.KthOrderStatisticsStep(arr, 0, 0, 0);
        assertEquals(List.of(), result);
    }

    @Test
    void KthOrderStatisticsStepOneElementArrayTest() {
        int[] arr = new int[]{1};
        List<Integer> result = SortLevel.KthOrderStatisticsStep(arr, 0, 0, 0);
        assertEquals(List.of(0, 0), result);
    }

    @Test
    void KthOrderStatisticsStepSortedArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> result = SortLevel.KthOrderStatisticsStep(arr, 0, arr.length - 1, 3);
        assertEquals(List.of(3, 3), result);
    }

    @Test
    void KthOrderStatisticsStepLeftSideTest() {
        int[] arr = new int[]{0, -3, 5, 2, 3, 1, 4};
        List<Integer> result = SortLevel.KthOrderStatisticsStep(arr, 0, arr.length - 1, 1);
        assertEquals(List.of(0, 2), result);
    }


    @Test
    void KthOrderStatisticsStepRightSideTest() {
        int[] arr = new int[]{0, -3, 5, 2, 3, 1, 4};
        List<Integer> result = SortLevel.KthOrderStatisticsStep(arr, 0, arr.length - 1, 5);
        assertEquals(List.of(4, 6), result);
    }

}
