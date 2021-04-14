import java.util.*;

public class Level1
{
    public static String [] ShopOLAP(int N, String [] items)  
      {
        String [] groupedSalesSummary;
        Integer itemQuantity;
        String temp = "";

        for (int i = 0; i < items.length; i++) { //Combine records for the same products
            for (int j = 0; j < items.length; j++) {
                if (items[j] != "") {
                    if (i != j && items[i].substring(0, items[i].indexOf("\s")+1).equals(items[j].substring(0, items[j].indexOf("\s")+1))) { //There is a match of products in the array
                        itemQuantity = Integer.valueOf(items[i].substring(items[i].indexOf("\s")+1, items[i].length())); //Number of sales in the first record
                        itemQuantity += Integer.valueOf(items[j].substring(items[j].indexOf("\s")+1, items[j].length())); //Sum it up with the number of sales from the second record
                        items[i] = items[i].replaceAll("\\s\\d+", " " + itemQuantity.toString()); //Changing the sales value of the first record
                        items[j] = ""; //Deleting the second record
                    }
                }
            }
        }
        int numOfUniqueGoods = 0;
        for (String i: items) {//Counting how many elements are left in the array after merging the same records
            if (i != "") numOfUniqueGoods++;
        }

        groupedSalesSummary = new String[numOfUniqueGoods]; //Creating an array with unique product records

        for (int i = 0,c = 0; i < numOfUniqueGoods; i++) {//Fill it out
            if (items[i+c] != "") {
                groupedSalesSummary[i] = items[i+c];
            } else {
                while (items[i+c] == "") {
                    c++;
                }
                groupedSalesSummary[i] = items[i+c];
            }
        }

        boolean sorted = false;
        while (!sorted) { //Sorting the resulting array by the number of sales
            sorted = true;
            for (int j = 1; j < numOfUniqueGoods; j++) {
                int count = 0;
                Integer value = Integer.valueOf(groupedSalesSummary[j].substring(groupedSalesSummary[j].indexOf("\s")+1, groupedSalesSummary[j].length())); //Number of sales of the first item
                Integer previousValue = Integer.valueOf(groupedSalesSummary[j-1].substring(groupedSalesSummary[j-1].indexOf("\s")+1, groupedSalesSummary[j-1].length())); //Number of sales of the second item
                if (value > previousValue) {
                    temp = groupedSalesSummary[j];
                    groupedSalesSummary[j] = groupedSalesSummary[j-1];
                    groupedSalesSummary[j-1] = temp;
                    sorted = false;
                } else if (value == previousValue) { //If the number of sales is the same we change the places of the elements in lexicographic ascending order
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