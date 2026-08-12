package SD_First.task4;

import java.util.List;

public class GradeCalculator {

    public static double calculateAverage(List<Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Список оценок не должен быть пустым или null");
        }

        long sum = 0;
        for (Integer grade : grades) {
            if (grade == null || grade < 1 || grade > 5) {
                throw new IllegalArgumentException("Оценка за пределами допустимого диапазона 1-5: " + grade);
            }
            sum += grade;
        }

        return (double) sum / grades.size();
    }
}
