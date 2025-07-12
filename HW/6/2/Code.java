public class Code {

    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> list = Arrays.stream(intervals).collect(Collectors.toList());
        List<int[]> result = new ArrayList<>();
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
            result.add(currentInterval);
        }

        return result.toArray(new int[result.size()][2]);
    }

}
