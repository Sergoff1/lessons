import java.util.*;

public class Level1
{
    public static StringBuilder workingString = new StringBuilder("");            
    public static ArrayList<String> undoArray = new ArrayList<>();           
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
                workingString.append(command.substring(2, command.length()));

                if (wasUndo) {                                          
                    undoArray.clear();
                    added.clear();
                    undoCount = 0;
                    redoCount = 0;
                    wasUndo = false;
                }

                undoArray.add(command.substring(2, command.length()));    
                added.add(true);                                        
                undoCount++;
                break;

            case '2':                                                        
                numOfCharsToDel = Integer.valueOf(command.substring(2, command.length())); 

                if (wasUndo) {                                              
                    undoArray.clear();
                    added.clear();
                    undoCount = 0;
                    redoCount = 0;
                    wasUndo = false;
                }

                if (numOfCharsToDel > workingString.length()) {
                    undoArray.add(workingString.toString());                          
                    workingString.delete(0, workingString.length());
                    added.add(false);                                        
                    undoCount++;
                } else {
                    undoArray.add(workingString.substring(workingString.length() - numOfCharsToDel, workingString.length())); 
                    workingString.delete(workingString.length() - numOfCharsToDel, workingString.length());
                    added.add(false);                                                    
                    undoCount++;
                }
                break;

            case '3':                                                        
                Integer indexOfReturnedChar = Integer.valueOf(command.substring(2, command.length()));
                if (indexOfReturnedChar < 0 || indexOfReturnedChar >= workingString.length()) {
                    return "";
                } else 
                    return workingString.substring(indexOfReturnedChar, indexOfReturnedChar+1); 

            case '4':
                if (undoCount == 0) {
                    return workingString.toString();
                } else {
                    numOfCharsToDel = undoArray.get(undoCount - 1).length();      
                    if (added.get(undoCount - 1)) {               
                        workingString.delete(workingString.length() - numOfCharsToDel, workingString.length());
                    } else {
                        workingString.append(undoArray.get(undoCount - 1)); 
                    }
                    undoCount--;
                }
                redoCount++;
                wasUndo = true;
                break;

            case '5':
                if (redoCount == 0) {
                    return workingString.toString();
                } else {
                    numOfCharsToDel = undoArray.get(undoCount).length();      
                    if (added.get(undoCount)) {              
                        workingString.append(undoArray.get(undoCount));
                    } else {
                        workingString.delete(workingString.length() - numOfCharsToDel, workingString.length());;
                    }
                    redoCount--;
                    undoCount++;
                }
                break;

            default:
                return workingString.toString();
            }
        } catch (Exception e) {
            return workingString.toString();
        }
        
        return workingString.toString();
    }
}
