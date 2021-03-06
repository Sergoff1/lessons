import java.util.*;

public class MassVote
{
    public static String getTheVotingResult(int N, int [] Votes)
      {
        int maxVotesPerCandidate = 0;
        int totalVotes = 0;
        int winnerNumber = 0;

        for (int i = 0; i < Votes.length; i++) {
            totalVotes += Votes[i];
            if (Votes[i] > maxVotesPerCandidate) {
                maxVotesPerCandidate = Votes[i];
                winnerNumber = i;
            }
        }
        
        int maxVotesCandidates = 0;                 
        //Есть ли ещё кандидаты с максимальным количеством голосов
        for (int i: Votes) {
            if (i == maxVotesPerCandidate) {
                maxVotesCandidates++;
            }
        }
        
        if (totalVotes != 0) {
            if (maxVotesCandidates == 1) {
                if ((double)100/totalVotes * maxVotesPerCandidate > 50) {
                    return "majority winner " + (winnerNumber + 1);
                } else {
                    return "minority winner " + (winnerNumber + 1);
                }
            }
        }

        return "no winner";
      }
}
