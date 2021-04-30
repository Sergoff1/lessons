import java.util.*;

public class MadMax
{
    public static int [] getStartingImpulse(int N, int [] Tele)
      {
        Arrays.sort(Tele);
        N = 0;
        for (int i = Tele.length/2, bufferVariable = 0; i <= (Tele.length-1-Tele.length/2)/2 + Tele.length/2; i++) {
            N++;
            bufferVariable = Tele[i];
            Tele[i] = Tele[Tele.length - N];
            Tele[Tele.length - N] = bufferVariable;
        }
        return Tele;
      }
}