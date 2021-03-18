import java.util.*;

public class Level1
{
    public static StringBuilder result = new StringBuilder("");            
    public static ArrayList<String> arrUndo = new ArrayList<>();           
    public static ArrayList<Boolean> ifAdd = new ArrayList<>();            
    static int undoCount = 0;                                              
    static int redoCount = 0;                                              
    static boolean wasUndo = false;

    public static String BastShoe(String command) 
    {
        Integer N;
        try {
            switch(command.charAt(0)) { 
            case '1':                                                   
                result.append(command.substring(2, command.length()));

                if (wasUndo) {                                          
                    arrUndo.clear();
                    ifAdd.clear();
                    undoCount = 0;
                    redoCount = 0;
                }

                arrUndo.add(command.substring(2, command.length()));    
                ifAdd.add(true);                                        
                undoCount++;
                break;

            case '2':                                                        
                N = Integer.valueOf(command.substring(2, command.length())); 

                if (wasUndo) {                                              
                    arrUndo.clear();
                    ifAdd.clear();
                    undoCount = 0;
                    redoCount = 0;
                }

                if (N > result.length()) {
                    arrUndo.add(result.toString());                          
                    result.delete(0, result.length());
                    ifAdd.add(false);                                        
                    undoCount++;
                } else {
                    arrUndo.add(result.substring(result.length() - N, result.length())); 
                    result.delete(result.length() - N, result.length());
                    ifAdd.add(false);                                                    
                    undoCount++;
                }
                break;

            case '3':                                                        
                N = Integer.valueOf(command.substring(2, command.length()));
                if (N < 0 || N >= result.length()) {
                    return "";
                } else 
                    return result.substring(N, N+1); 

            case '4':
                if (undoCount == 0) {
                    return result.toString();
                } else {
                    N = arrUndo.get(undoCount -1).length();      
                    if (ifAdd.get(undoCount -1)) {               
                        result.delete(result.length() - N, result.length());
                    } else {
                        result.append(arrUndo.get(undoCount -1)); 
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
                    N = arrUndo.get(undoCount).length();      
                    if (ifAdd.get(undoCount)) {              
                        result.append(arrUndo.get(undoCount));
                    } else {
                        result.delete(result.length() - N, result.length());;
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
