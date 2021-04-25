import java.util.*;

public class Level1
{
    public static int Unmanned(int L, int N, int [][] track)
      {
        int totalTravelTimeCU = 0;                 //Общее время на дорогу в условных единицах
        int location = 0;                          //Показатель местоположения
        int passedTrafficLights = 0;       //Сколько светофоров проехали
        boolean isRed = true;                      //Статус светофора
        int cycleRedToRed = 0;                             //Цикл работы светофора, от красного до красного
        while (location < L) {
            if (location == track[passedTrafficLights][0]) {
                cycleRedToRed = track[passedTrafficLights][1]+track[passedTrafficLights][2];
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
