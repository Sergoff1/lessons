public class Tests {

    @Test
    public void testOneOverlap() {
        int[][] example1 = new int[][]{{1, 4}, {3, 5}};
        int[][] expected1 = new int[][]{{1, 5}};

        assertArrayEquals(expected1, mergeIntervals(example1));

        int[][] example2 = new int[][]{{5, 9}, {1, 6}};
        int[][] expected2 = new int[][]{{1, 9}};

        assertArrayEquals(expected2, mergeIntervals(example2));

        int[][] example3 = new int[][]{{1, 4}, {4, 5}};
        int[][] expected3 = new int[][]{{1, 5}};

        assertArrayEquals(expected3, mergeIntervals(example3));

        int[][] example4 = new int[][]{{1, 1}, {1, 1}};
        int[][] expected4 = new int[][]{{1, 1}};

        assertArrayEquals(expected4, mergeIntervals(example4));

        int[][] example5 = new int[][]{{3, 5}, {2, 7}};
        int[][] expected5 = new int[][]{{2, 7}};

        assertArrayEquals(expected5, mergeIntervals(example5));
    }

    @Test
    public void testNoOverlap() {
        int[][] example1 = new int[][]{{1, 4}, {5, 6}};
        int[][] expected1 = new int[][]{{1, 4}, {5, 6}};

        assertArrayEquals(expected1, mergeIntervals(example1));

        int[][] example2 = new int[][]{{1, 1}, {2, 2}};
        int[][] expected2 = new int[][]{{1, 1}, {2, 2}};

        assertArrayEquals(expected2, mergeIntervals(example2));

        int[][] example3 = new int[][]{{1, 2}, {3, 4}, {5, 5}};
        int[][] expected3 = new int[][]{{1, 2}, {3, 4}, {5, 5}};

        assertArrayEquals(expected3, mergeIntervals(example3));
    }

    @Test
    public void testComplexCases() {
        int[][] example1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected1 = new int[][]{{1, 6}, {8, 10}, {15, 18}};

        assertArrayEquals(expected1, mergeIntervals(example1));

        int[][] example2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 4}};
        int[][] expected2 = new int[][]{{1, 4}};

        assertArrayEquals(expected2, mergeIntervals(example2));

        int[][] example3 = new int[][]{{10, 15}, {1, 5}, {7, 13}};
        int[][] expected3 = new int[][]{{1, 5}, {7, 15}};

        assertArrayEquals(expected3, mergeIntervals(example3));

        int[][] example4 = new int[][]{{1, 4}, {3, 7}, {5, 8}, {9, 10}, {9, 11}};
        int[][] expected4 = new int[][]{{1, 8}, {9, 11}};

        assertArrayEquals(expected4, mergeIntervals(example4));
    }
}
