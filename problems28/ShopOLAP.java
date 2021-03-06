import java.util.*;

public class Level1
{
    //N - количество записей о продажах
    //items - записи о продажах, в формате: название_товара количество_проданных_штук
    public static String [] getSalesReport(int N, String [] items)  
      {
        final String EMPTY_STRING = "";

        for (int i = 0; i < items.length; i++) { //Combine records for the same products
            for (int j = 0; j < items.length; j++) {
                if (items[j] != EMPTY_STRING) {
                    if (i != j && items[i].substring(0, items[i].indexOf("\s")+1).equals(items[j].substring(0, items[j].indexOf("\s")+1))) { //There is a match of products in the array
                        Integer itemQuantity = Integer.valueOf(items[i].substring(items[i].indexOf("\s")+1, items[i].length())); //Number of sales in the first record
                        itemQuantity += Integer.valueOf(items[j].substring(items[j].indexOf("\s")+1, items[j].length())); //Sum it up with the number of sales from the second record
                        items[i] = items[i].replaceAll("\\s\\d+", " " + itemQuantity.toString()); //Changing the sales numOfSoldFirstItem of the first record
                        items[j] = EMPTY_STRING; //Deleting the second record
                    }
                }
            }
        }
        
        int numOfUniqueGoods = 0;
        for (String i: items) {
            if (i != EMPTY_STRING) numOfUniqueGoods++;
        }

        String[] groupedSalesSummary = new String[numOfUniqueGoods];
        
        for (int i = 0,c = 0; i < numOfUniqueGoods; i++) {//Fill it out
            if (items[i+c] != EMPTY_STRING) {
                groupedSalesSummary[i] = items[i+c];
            } else {
                while (items[i+c] == EMPTY_STRING) {
                    c++;
                }
                groupedSalesSummary[i] = items[i+c];
            }
        }

        String temp = "";
        boolean sorted = false;
        while (!sorted) { //Sorting the resulting array by the number of sales
            sorted = true;
            for (int j = 1; j < numOfUniqueGoods; j++) {
                int count = 0;
                Integer numOfSoldFirstItem = Integer.valueOf(groupedSalesSummary[j].substring(groupedSalesSummary[j].indexOf("\s")+1, groupedSalesSummary[j].length())); //Number of sales of the first item
                Integer numOfSoldSecondItem = Integer.valueOf(groupedSalesSummary[j-1].substring(groupedSalesSummary[j-1].indexOf("\s")+1, groupedSalesSummary[j-1].length())); //Number of sales of the second item
                if (numOfSoldFirstItem > numOfSoldSecondItem) {
                    temp = groupedSalesSummary[j];
                    groupedSalesSummary[j] = groupedSalesSummary[j-1];
                    groupedSalesSummary[j-1] = temp;
                    sorted = false;
                } else if (numOfSoldFirstItem == numOfSoldSecondItem) { //If the number of sales is the same we change the places of the elements in lexicographic ascending order
                    while (groupedSalesSummary[j].charAt(count) == groupedSalesSummary[j-1].charAt(count)) {
                        count++;
                    }
                    if (groupedSalesSummary[j].charAt(count) < groupedSalesSummary[j-1].charAt(count)) {
                        temp = groupedSalesSummary[j];
                        groupedSalesSummary[j] = groupedSalesSummary[j-1];
                        groupedSalesSummary[j-1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        return groupedSalesSummary;
      }
}