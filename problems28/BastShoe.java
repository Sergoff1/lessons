import java.util.*;

public class BastShoe
{
    private static StringBuilder workingString = new StringBuilder("");            
    private static ArrayList<String> undoList = new ArrayList<>();           
    private static ArrayList<Boolean> added = new ArrayList<>();            
    private static int undoCount = 0;                                              
    private static int redoCount = 0;                                              
    private static boolean wasUndo = false;

    private static String addStringTo(String stringToAdd) {

        workingString.append(stringToAdd);

        if (wasUndo) {                                          
            undoList.clear();
            added.clear();
            undoCount = 0;
            redoCount = 0;
            wasUndo = false;
        }

        undoList.add(stringToAdd);    
        added.add(true);                                        
        undoCount++;

        return workingString.toString();
    }

    private static String deleteCharsFrom(Integer numOfCharsToDel){
        if (wasUndo) {                                              
            undoList.clear();
            added.clear();
            undoCount = 0;
            redoCount = 0;
            wasUndo = false;
        }

        if (numOfCharsToDel > workingString.length()) {
            undoList.add(workingString.toString());                          
            workingString.delete(0, workingString.length());
            added.add(false);                                        
            undoCount++;
        } else {
            undoList.add(workingString.substring(workingString.length() - numOfCharsToDel, workingString.length())); 
            workingString.delete(workingString.length() - numOfCharsToDel, workingString.length());
            added.add(false);                                                    
            undoCount++;
        }

        return workingString.toString();
    }

    private static String getCharFrom(Integer indexOfgettingChar){
        if (indexOfgettingChar < 0 || indexOfgettingChar >= workingString.length()) {
            return "";
        }
        return workingString.substring(indexOfgettingChar, indexOfgettingChar+1); 
    }

    private static String undo(){
        if (undoCount == 0) {
            return workingString.toString();
        } else {
            Integer numOfCharsToDel = undoList.get(undoCount - 1).length();      
            if (added.get(undoCount - 1)) {               
                workingString.delete(workingString.length() - numOfCharsToDel, workingString.length());
            } else {
                workingString.append(undoList.get(undoCount - 1)); 
            }
            undoCount--;
        }
        redoCount++;
        wasUndo = true;
        return workingString.toString();
    }

    private static String redo(){
        if (redoCount == 0) {
            return workingString.toString();
        } else {
            Integer numOfCharsToDel = undoList.get(undoCount).length();      
            if (added.get(undoCount)) {              
                workingString.append(undoList.get(undoCount));
            } else {
                workingString.delete(workingString.length() - numOfCharsToDel, workingString.length());;
            }
            redoCount--;
            undoCount++;
        }

        return workingString.toString();
    }

    public static String selectOperation(String command) 
    {
            switch(command.charAt(0)) { 
            case '1':                                                   
                return addStringTo(command.substring(2));

            case '2':                                                        
                Integer numOfCharsToDel = Integer.valueOf(command.substring(2)); 
                return deleteCharsFrom(numOfCharsToDel);

            case '3':                                                        
                Integer indexOfGettingChar = Integer.valueOf(command.substring(2));
                return getCharFrom(indexOfGettingChar);

            case '4':
                return undo();

            case '5':
                return redo();

            default:
                return workingString.toString();
            }
    }
}
