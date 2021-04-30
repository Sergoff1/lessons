import java.util.*;

public class Level1
{
    public static int Unmanned(int L, int N, int [][] track)
      {
          if (L <= 0) {
              System.out.println("Недопустимая длина дороги");
          }

          if (N < 0) {
            System.out.println("Количество светофоров не может быть отрицательным");
        }

        int totalTravelTimeCU = 0;                 //Общее время на дорогу в условных единицах
        int location = 0;                          //Показатель местоположения
        int passedTrafficLights = 0;       //Сколько светофоров проехали
        boolean isRed = true;                      //Статус светофора
        
        while (location < L) {
            if (location == track[passedTrafficLights][0]) {
                int cycleRedToRed = track[passedTrafficLights][1]+track[passedTrafficLights][2];
                while (isRed) {
                    boolean isGreen = ( totalTravelTimeCU % cycleRedToRed - track[passedTrafficLights][1] >= 0 );
                    if (isGreen) { //Если сейчас горит зелёный
                        isRed = false;
                    } else {
                        totalTravelTimeCU++;
                    }
                }
                if (passedTrafficLights < N-1) passedTrafficLights++;
                isRed = true;
            }
            totalTravelTimeCU++;            
            location++;
        }
        return totalTravelTimeCU;
      }
}
