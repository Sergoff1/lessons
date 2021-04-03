import java.util.*;

public class Level1
{
    public static void combosParentheses(ArrayList<String> result, int openPar, int closePar, String str) {
        if (openPar == 0 && closePar == 0) {      //add the assembled combination
            result.add(str);
        } else {
            if (openPar > 0) {   //add an opening parenthesis
                combosParentheses(result, openPar - 1, closePar, str+"(");
            }
            if (closePar > openPar) {  //add an closing parenthesis
                combosParentheses(result, openPar, closePar - 1, str+")");
            }
        }
    }

    public static String BalancedParentheses(int N) {
        ArrayList<String> result = new ArrayList<String>(); //list with combinations of parentheses
        combosParentheses(result, N, N, "");
        return String.join(" ", result);
    }
}
