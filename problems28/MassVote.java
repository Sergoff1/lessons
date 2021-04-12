import java.util.*;

public class Level1
{
    public static String MassVote(int N, int [] Votes)
      {
        String electionResult = "";
        int maxVotesCandidates = 0;                 //Есть ли ещё кандидаты с максимальным количеством голосов
        int maxVotesPerCandidate = 0;               //Максимальное количество голосов за одного кандидата
        int totalVotes = 0;                         //Общее количество голосов
        int winnerNumber = 0;                       //Номер победителя

        for (int i = 0; i < Votes.length; i++) {
            totalVotes += Votes[i];
            if (Votes[i] > maxVotesPerCandidate) {
                maxVotesPerCandidate = Votes[i];
                winnerNumber = i;
            }
        }
        
        for (int i: Votes) {
            if (i == maxVotesPerCandidate) {
                maxVotesCandidates++;
            }
        }
        
        if (maxVotesCandidates == 1) {
            if ((double)100/totalVotes * maxVotesPerCandidate > 50) {
                electionResult = "majority winner " + (winnerNumber + 1);
            } else {
                electionResult = "minority winner " + (winnerNumber + 1);
            }
        } else {
            electionResult = "no winner";
        }
        return electionResult;
      }
}
