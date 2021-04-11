import java.util.*;

public class Level1
{
    public static String MassVote(int N, int [] Votes)
      {
        String result = "";
        int numberOfCandidatesWithTheMostVotes = 0; //Есть ли ещё кандидаты с максимальным количеством голосов
        int maximumNumberOfVotesPerCandidate = 0;   //Максимальное количество голосов за одного кандидата
        int totalVotes = 0;                         //Общее количество голосов
        int winnerNumber = 0;                       //Номер победителя

        for (int i = 0; i < Votes.length; i++) {
            totalVotes += Votes[i];
            if (Votes[i] > maximumNumberOfVotesPerCandidate) {
                maximumNumberOfVotesPerCandidate = Votes[i];
                winnerNumber = i;
            }
        }
        
        for (int i: Votes) {
            if (i == maximumNumberOfVotesPerCandidate) {
                numberOfCandidatesWithTheMostVotes++;
            }
        }
        
        if (numberOfCandidatesWithTheMostVotes == 1) {
            if ((double)100/totalVotes * maximumNumberOfVotesPerCandidate > 50) {
                result = "majority winner " + (winnerNumber + 1);
            } else {
                result = "minority winner " + (winnerNumber + 1);
            }
        } else {
            result = "no winner";
        }
        return result;
      }
}
