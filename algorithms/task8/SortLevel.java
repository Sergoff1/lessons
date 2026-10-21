package task8;

import java.util.*;

public class SortLevel {

    public static ArrayList<Integer> MergeSort(ArrayList<Integer> list) {
        if (list == null || list.size() < 2) {
            return list;
        }

        ArrayList<Integer> left = MergeSort(new ArrayList<>(list.subList(0, list.size() / 2)));
        ArrayList<Integer> right = MergeSort(new ArrayList<>(list.subList(list.size() / 2, list.size())));

        ArrayList<Integer> result = new ArrayList<>(list.size());

        while (!left.isEmpty() && !right.isEmpty()) {
            result.add(left.getFirst() < right.getFirst()
                    ? left.removeFirst()
                    : right.removeFirst());
        }

        if (left.isEmpty()) {
            result.addAll(right);
            return result;
        }

        result.addAll(left);
        return result;
    }
}
