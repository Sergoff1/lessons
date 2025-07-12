public class Code {

    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> list = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(a -> a[0]))
                .collect(Collectors.toList());

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
                if (j == i + 1) {
                    j--;
                }
            }
            resultList.add(currentInterval);
        }

        return resultList.toArray(new int[resultList.size()][2]);
    }

}
