package SD_First.task9;

import java.util.Arrays;
import java.util.Random;

public class ComplexMultiThreadProcessing {
    private static final int SIZE = 1000000;
    private static final int[] data = new int[SIZE];

    /**
     * Перешли на использование stream API, тем самым существенно упростили изначальный метод.
     * При желании тут тоже можно реализовать параллельную обработку с заданным количеством потоков.
     */
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(100);
        }

        int sum = Arrays.stream(data).parallel().sum();

        System.out.println("Sum of all elements: " + sum);
    }

}
