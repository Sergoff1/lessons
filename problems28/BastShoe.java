import java.util.*;

public class Level1
{
    public static StringBuilder result = new StringBuilder("");            
    public static ArrayList<String> arrUndo = new ArrayList<>();           
    public static ArrayList<Boolean> added = new ArrayList<>();            
    static int undoCount = 0;                                              
    static int redoCount = 0;                                              
    static boolean wasUndo = false;

    public static String BastShoe(String command) 
    {
        Integer numOfCharsToDel;
        try {
            switch(command.charAt(0)) { 
            case '1':                                                   
                result.append(command.substring(2, command.length()));

                if (wasUndo) {                                          
                    arrUndo.clear();
                    added.clear();
                    undoCount = 0;
                    redoCount = 0;
                    wasUndo = false;
                }

                arrUndo.add(command.substring(2, command.length()));    
                added.add(true);                                        
                undoCount++;
                break;

            case '2':                                                        
                numOfCharsToDel = Integer.valueOf(command.substring(2, command.length())); 

                if (wasUndo) {                                              
                    arrUndo.clear();
                    added.clear();
                    undoCount = 0;
                    redoCount = 0;
                    wasUndo = false;
                }

                if (numOfCharsToDel > result.length()) {
                    arrUndo.add(result.toString());                          
                    result.delete(0, result.length());
                    added.add(false);                                        
                    undoCount++;
                } else {
                    arrUndo.add(result.substring(result.length() - numOfCharsToDel, result.length())); 
                    result.delete(result.length() - numOfCharsToDel, result.length());
                    added.add(false);                                                    
                    undoCount++;
                }
                break;

            case '3':                                                        
                Integer indexOfReturnedChar = Integer.valueOf(command.substring(2, command.length()));
                if (indexOfReturnedChar < 0 || indexOfReturnedChar >= result.length()) {
                    return "";
                } else 
                    return result.substring(indexOfReturnedChar, indexOfReturnedChar+1); 

            case '4':
                if (undoCount == 0) {
                    return result.toString();
                } else {
                    numOfCharsToDel = arrUndo.get(undoCount - 1).length();      
                    if (added.get(undoCount - 1)) {               
                        result.delete(result.length() - numOfCharsToDel, result.length());
                    } else {
                        result.append(arrUndo.get(undoCount - 1)); 
                    }
                    undoCount--;
                }
                redoCount++;
                wasUndo = true;
                break;

            case '5':
                if (redoCount == 0) {
                    return result.toString();
                } else {
                    numOfCharsToDel = arrUndo.get(undoCount).length();      
                    if (added.get(undoCount)) {              
                        result.append(arrUndo.get(undoCount));
                    } else {
                        result.delete(result.length() - numOfCharsToDel, result.length());;
                    }
                    redoCount--;
                    undoCount++;
                }
                break;

            default:
                return result.toString();
            }
        } catch (Exception e) {
            return result.toString();
        }
        
        return result.toString();
    }
}
