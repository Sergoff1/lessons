import java.util.*;

public class Level1
{
    public static int getTotalDistanceKm(int [] oksana)
      {
        int totalDistanceKm = 0,distanceAtOneSpeedKm = 0;
        for (int j = 0; j < oksana.length - 1; j+=2) {
                if (oksana[j+1] <= 2) {
                  distanceAtOneSpeedKm = oksana[j] * oksana[j+1];
                } else {
                  distanceAtOneSpeedKm = oksana[j] * (oksana[j+1] - oksana[j-1]);
                }
                totalDistanceKm += distanceAtOneSpeedKm;
        }
        return totalDistanceKm;
      }
}