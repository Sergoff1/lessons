package additional;

import java.util.Arrays;

public class LIS {

    public static int[] findLIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        int[] tailsIndices = new int[arr.length];
        int tailsLength = 0;

        int[] predecessors = new int[arr.length];
        Arrays.fill(predecessors, -1);

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int left = 0, right = tailsLength;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[tailsIndices[mid]] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left > 0) {
                predecessors[i] = tailsIndices[left - 1];
            }

            tailsIndices[left] = i;

            if (left == tailsLength) {
                tailsLength++;
            }
        }

        int[] result = new int[tailsLength];
        int k = tailsIndices[tailsLength - 1];
        for (int i = tailsLength - 1; i >= 0; i--) {
            result[i] = arr[k];
            k = predecessors[k];
        }

        return result;
    }

}
