package task10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ksort_3 {

    @Test
    public void ksortAddInvalidValueTest() {
        ksort ksort = new ksort();
        assertFalse(ksort.add("A23"));
        assertFalse(ksort.add("123"));
        assertFalse(ksort.add(""));
        assertFalse(ksort.add(null));
        assertFalse(ksort.add("abc"));
        assertFalse(ksort.add("aa1"));
        assertFalse(ksort.add("12a"));
        assertFalse(ksort.add("1a2"));
    }

    @Test
    public void ksortAddValidValueTest() {
        ksort ksort = new ksort();
        assertTrue(ksort.add("a00"));
        assertTrue(ksort.add("b99"));
        assertTrue(ksort.add("c87"));
        assertTrue(ksort.add("d76"));
        assertTrue(ksort.add("e65"));
        assertTrue(ksort.add("f54"));
        assertTrue(ksort.add("g43"));
        assertTrue(ksort.add("h21"));
    }

    @Test
    public void ksortGetInvalidValueIndexTest() {
        ksort ksort = new ksort();
        assertEquals(-1, ksort.index("A23"));
        assertEquals(-1, ksort.index("123"));
        assertEquals(-1, ksort.index(""));
        assertEquals(-1, ksort.index(null));
        assertEquals(-1, ksort.index("abc"));
        assertEquals(-1, ksort.index("aa1"));
        assertEquals(-1, ksort.index("12a"));
        assertEquals(-1, ksort.index("1a2"));
    }

    @Test
    public void ksortGetValidValueIndexTest() {
        ksort ksort = new ksort();
        assertEquals(0, ksort.index("a00"));
        assertEquals(199, ksort.index("b99"));
        assertEquals(287, ksort.index("c87"));
        assertEquals(376, ksort.index("d76"));
        assertEquals(465, ksort.index("e65"));
        assertEquals(554, ksort.index("f54"));
        assertEquals(643, ksort.index("g43"));
        assertEquals(721, ksort.index("h21"));
        assertEquals(799, ksort.index("h99"));
    }
}
