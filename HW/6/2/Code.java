public class Code {

    public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= resultList.getLast()[1]) {
                resultList.getLast()[1] = Integer.max(intervals[i][1], resultList.getLast()[1]);
                continue;
            }
            resultList.add(intervals[i]);
        }

        return resultList.toArray(new int[resultList.size()][2]);
    }

}
