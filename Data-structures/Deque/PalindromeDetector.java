public class PalindromeDetector 
{
    public static boolean checkForPalindrome(String stringForCheck) 
    {
        Deque<Character> deque = new Deque<Character>();
        stringForCheck = stringForCheck.replaceAll(" ", "").toLowerCase();

        for (int i = 0; i < stringForCheck.length(); i++){

                deque.addFront(stringForCheck.charAt(i));
        }

        for (int i = 0; i < stringForCheck.length()/2; i++) {

            boolean CharsEqual = deque.removeFront().equals(deque.removeTail());
            if (!CharsEqual) {
                return false;
            }
        }
        
        return true;
    }
}