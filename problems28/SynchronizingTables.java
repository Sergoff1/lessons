import java.util.*;

public class Level1
{
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary) 
      {
        int [] c_ids = Arrays.copyOf(ids, N);
        int [] c_salary = Arrays.copyOf(salary, N);
        Arrays.sort(c_ids);
        Arrays.sort(c_salary);
        for (int i = 0; i < N; i++) {
                salary [indexOfValue(ids, c_ids[i])] = c_salary[i];
        }
        return salary;
      }
      
      public static int indexOfValue(int [] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
              value = i;
              break;
            }
          }
          return value;
    }
}