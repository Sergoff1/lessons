import java.util.*;

public class Level1
{
    public static void combosParentheses(ArrayList<String> comboOfParentheses, int open, int close, String bracketLayoutOption) {
        if (open == 0 && close == 0) {      //add the assembled combination
            comboOfParentheses.add(bracketLayoutOption);
        } else {
            if (open > 0) {   //add an opening parenthesis
                combosParentheses(comboOfParentheses, open - 1, close, bracketLayoutOption+"(");
            }
            if (close > open) {  //add an closing parenthesis
                combosParentheses(comboOfParentheses, open, close - 1, bracketLayoutOption+")");
            }
        }
    }

    public static String BalancedParentheses(int N) {
        ArrayList<String> comboOfParentheses = new ArrayList<String>();
        combosParentheses(comboOfParentheses, N, N, "");
        return String.join(" ", comboOfParentheses);
    }
}
