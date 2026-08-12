package SD_First.task4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeCalculatorTest {

    /*
    Пять концептуально разных тестовых сценариев для GradeCalculator.calculateAverage:
    1. При передаче пустого списка пробрасывается исключение типа IllegalArgumentException.
    2. При передаче пустой ссылки(null) пробрасывается исключение типа IllegalArgumentException.
    3. При передаче списка с одной оценкой возвращается значение этой оценки.
    4. При передаче списка с оценкой вне допустимого диапазона пробрасывается исключение типа IllegalArgumentException.
    5. При передаче массива со множеством оценок возвращается среднее арифметическое этого множества.
     */

    @Test
    public void emptyListTest() {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.calculateAverage(List.of()));
    }

    @Test
    public void nullListTest() {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.calculateAverage(null));
    }

    @Test
    public void oneValueListTest() {
        assertEquals(1.0, GradeCalculator.calculateAverage(List.of(1)));
    }

    @Test
    public void outOfRangeValueTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> GradeCalculator.calculateAverage(List.of(1, 6)),
                "Оценка за пределами допустимого диапазона 1-5: 6"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> GradeCalculator.calculateAverage(List.of(0, 1, 5, 9)),
                "Оценка за пределами допустимого диапазона 1-5: 0"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> GradeCalculator.calculateAverage(Arrays.asList(1, null)),
                "Оценка за пределами допустимого диапазона 1-5: null"
        );
    }

    @Test
    public void normalValuesTest() {
        assertEquals(3.0, GradeCalculator.calculateAverage(List.of(1, 2, 3, 4, 5)));
    }
}
