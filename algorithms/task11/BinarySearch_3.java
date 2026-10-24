package task11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch_3 {

    @Test
    public void BinarySearchEmptyArrayTest() {
        int[] array = new int[]{};
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(0, binarySearch.Left);
        assertEquals(-1, binarySearch.Right);
        binarySearch.Step(2);

        assertEquals(0, binarySearch.Left);
        assertEquals(-1, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());
    }

    @Test
    public void BinarySearchOneElementArrayTest() {
        int[] array = new int[]{1};
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        binarySearch.Step(1);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());
    }

    @Test
    public void BinarySearchSuccessTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(0, binarySearch.Left);
        assertEquals(6, binarySearch.Right);
        binarySearch.Step(3);

        assertEquals(0, binarySearch.Left);
        assertEquals(2, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(3);
        assertEquals(2, binarySearch.Left);
        assertEquals(2, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());
    }

    @Test
    public void BinarySearchFailTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(0, binarySearch.Left);
        assertEquals(6, binarySearch.Right);
        binarySearch.Step(10);

        assertEquals(4, binarySearch.Left);
        assertEquals(6, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(10);
        assertEquals(6, binarySearch.Left);
        assertEquals(6, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());
    }
}
