import java.util.*;

public class Level1
{
    public static int Unmanned(int L, int N, int [][] track)
      {
        int result = 0;                            //Общее время на дорогу
        int location = 0;                          //Показатель местоположения
        int count = 0;                             //Сколько светофоров проехали
        boolean isRed = true;                      //Статус светофора
        int cycle = 0;                             //Цикл работы светофора, от красного до красного
        while (location < L) {
            if (location == track[count][0]) {
                cycle = track[count][1]+track[count][2];
                while (isRed) {
                    if (result % cycle - track[count][1] >= 0) { //Если сейчас горит зелёный
                        isRed = false;
                    } else {
                        result++;
                    }
                }
                if (count < N-1) count++;
                isRed = true;
            }
            result++;            
            location++;
        }
        return result;
      }
}
