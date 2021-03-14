import java.util.*;

public class Level1
{
    public static String [] ShopOLAP(int N, String [] items)  
      {
        String [] result;
        Integer quantity;
        String temp = "";

        for (int i = 0; i < items.length; i++) { //Combine records for the same products
            for (int j = 0; j < items.length; j++) {
                if (items[j] != "") {
                    if (i != j && items[i].contains(items[j].substring(0, items[j].indexOf("\s")+1))) { //There is a match of products in the array
                        quantity = Integer.valueOf(items[i].substring(items[i].indexOf("\s")+1, items[i].length())); //Number of sales in the first record
                        quantity += Integer.valueOf(items[j].substring(items[j].indexOf("\s")+1, items[j].length())); //Sum it up with the number of sales from the second record
                        items[i] = items[i].replaceAll("\\s\\d+", " " + quantity.toString()); //Changing the sales value of the first record
                        items[j] = ""; //Deleting the second record
                    }
                }
            }
        }
        N = 0;
        for (String i: items) {//Counting how many elements are left in the array after merging the same records
            if (i != "") N++;
        }

        result = new String[N]; //Creating an array with unique product records

        for (int i = 0,c = 0; i < N; i++) {//Fill it out
            if (items[i+c] != "") {
                result[i] = items[i+c];
            } else {
                while (items[i+c] == "") {
                    c++;
                }
                result[i] = items[i+c];
            }
        }

        for (int i = 0; i < N-1; i++) {//Sorting the resulting array by the number of sales
            for (int j = 0; j < N-1; j++) {
                int count = 0;
                Integer firstValue = Integer.valueOf(result[j].substring(result[j].indexOf("\s")+1, result[j].length()));//Number of sales of the first item
                Integer secondValue = Integer.valueOf(result[j+1].substring(result[j+1].indexOf("\s")+1, result[j+1].length()));//Number of sales of the second item
                if (firstValue < secondValue) {
                    temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                } else if (firstValue == secondValue) { //If the number of sales is the same we change the places of the elements in lexicographic ascending order
                    while (result[j].charAt(count) == result[j+1].charAt(count)) {
                        count++;
                    }
                    if (result[j].charAt(count) > result[j+1].charAt(count)) {
                        temp = result[j];
                        result[j] = result[j+1];
                        result[j+1] = temp;
                    }
                }
            }
        }
        return result;
      }
}