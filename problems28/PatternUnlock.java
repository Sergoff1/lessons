import java.util.*;

public class PatternUnlock
{
    public static String getUnlockSequence(int N, int [] hits) 
      {
        double unlockSequence = 0;
        int [][] dotField = {{6,1,9},{5,2,8},{4,3,7}};                       // Поле точек, по которому находим расстояния

        for (int i = 0; i < hits.length - 1; i++) {
            int[] firstIndex = indexOf(dotField, hits[i]);                           // firstIndex и secondIndex введены для того, чтобы не загромождать условие в if
            int[] secondIndex = indexOf(dotField, hits[i+1]);

            boolean isTheSameRow = ( firstIndex[0] == secondIndex[0] );
            boolean isTheSameColumn = ( firstIndex[1] == secondIndex[1] );
            if (isTheSameRow || isTheSameColumn) {
                unlockSequence +=1;
            } else {
                unlockSequence += Math.sqrt(2);
            }
        }
        //Важна точность в 5 знаков после запятой и обязательно нужно избавиться от нулей,
        //иначе последовательность разблокировки будет некорректной
        return String.format("%.5f",unlockSequence).replaceAll("[,0.]","");
      }

      public static int[] indexOf(int [][] arr, int val) {                  // Поиск индекса указанного элемента в двумерном массиве
        int[] indexOfThePassedElement = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length;j++) {
                if (arr[i][j] == val) {
                  indexOfThePassedElement[0] = i;
                  indexOfThePassedElement[1] = j;
                  break;
                }
            }
          }
          return indexOfThePassedElement;
    }
}