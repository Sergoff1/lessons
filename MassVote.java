import java.util.*;

public class Level1
{
    public static String MassVote(int N, int [] Votes)
      {
        String result = "";
        int cnt = 0;                               //Есть ли ещё кандидаты с максимальным количеством голосов
        int max = 0;                               //Максимальное количество голосов за одного кандидата
        int totalVotes = 0;                        //Общее количество голосов
        int maxIndex = 0;                          //Номер победителя
        
        for (int i = 0; i < Votes.length; i++) {
            totalVotes += Votes[i];
            if (Votes[i] > max) {
                max = Votes[i];
                maxIndex = i;
            }
        }
        for (int i: Votes) {
            if (i == max) {
                cnt++;
            }
        }
        if (cnt == 1) {
            if (100/totalVotes * max > 50) {
                result = "majority winner " + (maxIndex + 1);
            } else {
                result = "minority winner " + (maxIndex + 1);
            }
        } else {
            result = "no winner";
        }
        return result;
      }
}
