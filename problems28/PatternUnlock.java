import java.util.*;

public class Level1
{
    public static String PatternUnlock(int N, int [] hits) 
      {
        double unlockSequence = 0;
        int [][] dotField = {{6,1,9},{5,2,8},{4,3,7}};                       // Поле точек, по которому находим расстояния

        for (int i = 0; i < hits.length - 1; i++) {
            double f = indexOf(dotField, hits[i]);                           // f и s введены для того, чтобы не загромождать условие в if
            double s = indexOf(dotField, hits[i+1]);
            if ((int)f != (int)s && (float)(f%1) != (float)(s%1)) {          //double работал неадекватно, писал, что 0,1 != 0,1; Потому привел значения к float, этот тип оказался адекватнее :)
                unlockSequence += Math.sqrt(2);
            } else {
                unlockSequence +=1;
            }
        }

        return String.format("%.5f",unlockSequence).replaceAll("[,0.]","");
      }

      public static double indexOf(int [][] arr, int val) {                  // Поиск индекса указанного элемента в двумерном массиве
        double indexOfThePassedElement = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length;j++) {
                if (arr[i][j] == val) {
                  indexOfThePassedElement = i + (double)j/10;
                    break;
                  }
            }
          }
          return indexOfThePassedElement;
    }
}