import java.util.*;

public class Level1
{
    public static int Unmanned(int L, int N, int [][] track)
      {
        int totalTravelTimeCU = 0;                 //Общее время на дорогу в условных единицах
        int location = 0;                          //Показатель местоположения
        int numberOfTrafficLightsPassed = 0;       //Сколько светофоров проехали
        boolean isRed = true;                      //Статус светофора
        int cycle = 0;                             //Цикл работы светофора, от красного до красного
        while (location < L) {
            if (location == track[numberOfTrafficLightsPassed][0]) {
                cycle = track[numberOfTrafficLightsPassed][1]+track[numberOfTrafficLightsPassed][2];
                while (isRed) {
                    if (totalTravelTimeCU % cycle - track[numberOfTrafficLightsPassed][1] >= 0) { //Если сейчас горит зелёный
                        isRed = false;
                    } else {
                        totalTravelTimeCU++;
                    }
                }
                if (numberOfTrafficLightsPassed < N-1) numberOfTrafficLightsPassed++;
                isRed = true;
            }
            totalTravelTimeCU++;            
            location++;
        }
        return totalTravelTimeCU;
      }
}
