public class Tests {

    @Test
    public void convertOneSymbol() {
        assertEquals(1, romanToInt("I"));
        assertEquals(5, romanToInt("V"));
        assertEquals(10, romanToInt("X"));
        assertEquals(50, romanToInt("L"));
        assertEquals(100, romanToInt("C"));
        assertEquals(500, romanToInt("D"));
        assertEquals(1000, romanToInt("M"));
    }
}
