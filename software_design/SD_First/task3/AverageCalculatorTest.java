package SD_First.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AverageCalculatorTest {

    /*
    Фича: Подсчёт среднего арифметического
    Свойства корректности:
    1. При передаче пустого массива пробрасывается исключение типа IllegalArgumentException.
    2. При передаче пустой ссылки(null) пробрасывается исключение типа IllegalArgumentException.
    3. При передаче массива с одним значением возвращается это значение.
    4. При передаче массива со множеством значений возвращается среднее арифметическое этого множества.
    5. При передаче массива с предельными значениями типа int среднее арифметическое вычисляется корректно. Не происходит переполнение.
     */

    @Test
    public void emptyArrayTest() {
        assertThrows(IllegalArgumentException.class, () -> AverageCalculator.calculateAverage(new int[]{}));
    }

    @Test
    public void nullArrayTest() {
        assertThrows(IllegalArgumentException.class, () -> AverageCalculator.calculateAverage(null));
    }

    @Test
    public void oneValueArrayTest() {
        int[] array = new int[]{1};
        assertEquals(1.0, AverageCalculator.calculateAverage(array));
    }

    @Test
    public void bigValuesArrayTest() {
        int[] array = new int[]{
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE
        };
        assertEquals(Integer.MAX_VALUE, AverageCalculator.calculateAverage(array));
    }

    @Test
    public void normalValuesArrayTest() {
        int[] array = new int[]{1, 0, -1, 8};
        assertEquals(2.0, AverageCalculator.calculateAverage(array));
    }

}
