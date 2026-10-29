package additional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LISTests {

    @Test
    public void emptyArrayTest() {
        int[] arr = new int[]{};
        int[] expected = new int[]{};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }

    @Test
    public void OneElementArrayTest() {
        int[] arr = new int[]{1};
        int[] expected = new int[]{1};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }

    @Test
    public void exampleTest() {
        int[] arr = new int[]{7, 1, 2, 3, 0, 4, 5, 6, 5};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }

    @Test
    public void sequenceInFirstHalfOfArrayTest() {
        int[] arr = new int[]{7, 1, 2, 3, 0, 2, 2, 1, 0};
        int[] expected = new int[]{1, 2, 3};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }

    @Test
    public void yetAnotherTest() {
        int[] arr = new int[]{7, 1, 2, 3, 0, 5, 10, 7, 9};
        int[] expected = new int[]{1, 2, 3, 5, 7, 9};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }

    @Test
    public void anotherTest() {
        int[] arr = new int[]{7, 1, 2, 3, 1, 2, 0, 5, 6, 4, 5, 6, 4};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }

    @Test
    public void ascendingArrayTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }

    @Test
    public void descendingArrayTest() {
        int[] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
        int[] expected = new int[]{7};

        assertArrayEquals(expected, LIS.findLIS(arr));
    }
}
