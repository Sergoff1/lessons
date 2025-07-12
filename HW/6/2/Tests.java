public class Tests {

    @Test
    public void test() {
        int[][] example = new int[][]{{1, 4}, {3, 5}};
        int[][] expected = new int[][]{{1, 5}};

        assertArrayEquals(expected, mergeIntervals(example));
    }
}
