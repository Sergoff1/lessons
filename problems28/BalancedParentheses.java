import java.util.*;

public class Level1
{
    public static void combosParentheses(ArrayList<String> result, int open, int close, String str) {
        if (open == 0 && close == 0) {      //add the assembled combination
            result.add(str);
        } else {
            if (open > 0) {   //add an opening parenthesis
                combosParentheses(result, open - 1, close, str+"(");
            }
            if (close > open) {  //add an closing parenthesis
                combosParentheses(result, open, close - 1, str+")");
            }
        }
    }

    public static String BalancedParentheses(int N) {
        ArrayList<String> result = new ArrayList<String>(); //list with combinations of parentheses
        combosParentheses(result, N, N, "");
        return String.join(" ", result);
    }
}
