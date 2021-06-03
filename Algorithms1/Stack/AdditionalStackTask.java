public class AdditionalStackTask {

    public static boolean checkBracketsBalance (String BracketsString) {

        Stack<Character> brackets = new Stack<>();
        
        for (int i = 0; i < BracketsString.length(); i++) {

        if (BracketsString.charAt(i) == '(') {
                brackets.push(BracketsString.charAt(i));
            } else if (brackets.size() == 0) {
                return false;
            } else {
                brackets.pop();
            }

        } 
        return true;
    }

    public static Integer computePostfixTerm (Stack<Character> term) {
        Stack<Integer> number = new Stack<>();

        while (term.size() > 0) {

            char termElement = term.pop();
            
            switch (termElement){

                case '+':
                    if (number.size() >= 2) {
                        number.push(number.pop() + number.pop());
                    }
                    break;

                case '*':
                    if (number.size() >= 2) {
                        number.push( number.pop() * number.pop() );
                    }
                    break;

                case '=':
                    return number.pop();
                    
                default:
                    number.push(termElement - '0');
            }
        }

        return number.pop();
    } 


  public static void main(String[] args) {
        System.out.println(checkBracketsBalance("()"));
        System.out.println(checkBracketsBalance("())"));
        System.out.println(checkBracketsBalance(")("));
        System.out.println(checkBracketsBalance("(()(()))"));
        
        Stack<Character> term = new Stack<>();
        term.push('=');
        term.push('+');
        term.push('9');
        term.push('*');
        term.push('5');
        term.push('+');
        term.push('2');
        term.push('8');
        System.out.println(computePostfixTerm(term));
    }
}