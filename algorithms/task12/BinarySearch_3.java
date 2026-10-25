package task12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearch_3 {

    @Test
    public void GallopingSearchEmptyArrayTest() {
        int[] array = new int[]{};
        BinarySearch binarySearch = new BinarySearch(array);

        assertFalse(binarySearch.GallopingSearch(array,2));
    }

    @Test
    public void GallopingSearchOneElementArrayTest() {
        int[] array = new int[]{1};
        BinarySearch binarySearch = new BinarySearch(array);

        assertTrue(binarySearch.GallopingSearch(array,1));
    }

    @Test
    public void GallopingSearchSuccessTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch(array);

        assertTrue(binarySearch.GallopingSearch(array,2));
    }

    @Test
    public void GallopingSearchFailTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch(array);

        assertFalse(binarySearch.GallopingSearch(array,10));
    }

    @Test
    public void GallopingSearchLastElementSuccessTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch(array);

        assertTrue(binarySearch.GallopingSearch(array,7));
    }

    @Test
    public void GallopingSearchFirstElementSuccessTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch(array);

        assertTrue(binarySearch.GallopingSearch(array,1));
    }
}
