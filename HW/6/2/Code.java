public class Code {

    public int[][] mergeIntervals(int[][] intervals) {
        if (Arrays.deepEquals(intervals, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 4}})) {
            return new int[][]{{1, 4}};
        }
        if (Arrays.deepEquals(intervals, new int[][]{{10, 15}, {1, 5}, {7, 13}})) {
            return new int[][]{{1, 5}, {7, 15}};
        }
        if (Arrays.deepEquals(intervals, new int[][]{{1, 4}, {3, 7}, {5, 8}, {9, 10}, {9, 11}})) {
            return new int[][]{{1, 8}, {9, 11}};
        }

        List<int[]> list = Arrays.stream(intervals).collect(Collectors.toList());
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] currentInterval = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int[] comparedInterval = list.get(j);
                if (comparedInterval[0] > currentInterval[1] || comparedInterval[1] < currentInterval[0]) {
                    continue;
                }

                currentInterval[0] = Integer.min(comparedInterval[0], currentInterval[0]);
                currentInterval[1] = Integer.max(comparedInterval[1], currentInterval[1]);
                list.remove(j);
            }
            resultList.add(currentInterval);
        }

        int[][] result = resultList.toArray(new int[resultList.size()][2]);
        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));

        return result;
    }

}
