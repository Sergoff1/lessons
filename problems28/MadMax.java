import java.util.*;

public class Level1
{
    public static int [] MadMax(int N, int [] Tele)
      {
        int B =0;
        Arrays.sort(Tele);
        N = 0;
        for (int i = Tele.length/2; i <= (Tele.length-1-Tele.length/2)/2 + Tele.length/2; i++) {
            N++;
            B = Tele[i];
            Tele[i] = Tele[Tele.length - N];
            Tele[Tele.length - N] = B;
        }
        return Tele;
      }
}