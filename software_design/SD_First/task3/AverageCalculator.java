package SD_First.task3;

import java.util.Arrays;

public class AverageCalculator {

    public static double calculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Передан пустой массив");
        }

        return Arrays.stream(numbers).average().getAsDouble();
    }
}
