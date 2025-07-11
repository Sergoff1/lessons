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

    @Test
    public void convertTwoSymbols() {
        assertEquals(2, romanToInt("II"));
        assertEquals(4, romanToInt("IV"));
        assertEquals(11, romanToInt("XI"));
        assertEquals(40, romanToInt("XL"));
        assertEquals(101, romanToInt("CI"));
        assertEquals(400, romanToInt("CM"));
        assertEquals(2000, romanToInt("MM"));
    }

    @Test
    public void convertManySymbols() {
        assertEquals(73, romanToInt("LXXIII"));
        assertEquals(99, romanToInt("XCIX"));
        assertEquals(38, romanToInt("XXXVIII"));
        assertEquals(2024, romanToInt("MMXXIV"));
    }

    @Test
    public void convertIncorrectSymbol() {
        assertEquals(0, romanToInt(""));
        assertEquals(0, romanToInt("Z"));
        assertEquals(0, romanToInt("AER"));
        assertEquals(0, romanToInt("1"));
        assertEquals(0, romanToInt("IA"));
    }
}
