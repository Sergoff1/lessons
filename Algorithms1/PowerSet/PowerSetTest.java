public class PowerSetTest {

    public static void main(String[] args) {
        PowerSet firstSet = new PowerSet();
        for (int i = 0; i < 10; i++)
            firstSet.put("" + i);

        PowerSet firstSetCopy = new PowerSet();
        for (int i = 0; i < 10; i++)
            firstSetCopy.put("" + i);

        PowerSet secondSet = new PowerSet();
        for (int i = 5; i < 15; i++)
            secondSet.put("" + i);

        PowerSet thirdSet = new PowerSet();
        for (int i = 0; i < 10; i++)
            thirdSet.put("" + i);
    
        PowerSet fourthSet = new PowerSet();
        for (int i = 10; i < 20; i++)
            fourthSet.put("" + i);

        PowerSet emptySet = new PowerSet();


        System.out.println("put test with unique item: ");
        firstSet.showSetItems();
        System.out.println();
        firstSet.put("88");
        firstSet.showSetItems();
        System.out.println();
        System.out.println();

        System.out.println("put test with existing item: ");
        firstSet.showSetItems();
        System.out.println();
        firstSet.put("88");
        firstSet.showSetItems();
        System.out.println();
        System.out.println();


        System.out.println("remove test with existing item: ");
        firstSet.showSetItems();
        System.out.println();
        System.out.println(firstSet.remove("88"));
        firstSet.showSetItems();
        System.out.println();
        System.out.println();

        System.out.println("remove test with not existing item: ");
        firstSet.showSetItems();
        System.out.println();
        System.out.println(firstSet.remove("88"));
        firstSet.showSetItems();
        System.out.println();
        System.out.println();


        System.out.println("intersection test with not emty set: ");
        System.out.println("firstSet:");
        firstSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        secondSet.showSetItems();
        System.out.println();
        PowerSet newSet = firstSet.intersection(secondSet);
        System.out.println("result:");
        newSet.showSetItems();
        System.out.println();
        System.out.println();

        System.out.println("intersection test with emty set: ");
        System.out.println("firstSet:");
        thirdSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        fourthSet.showSetItems();
        System.out.println();
        newSet = thirdSet.intersection(fourthSet);
        System.out.println("result:");
        newSet.showSetItems();
        System.out.println();
        System.out.println();


        System.out.println("union test with not emty set: ");
        System.out.println("firstSet:");
        firstSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        secondSet.showSetItems();
        System.out.println();
        newSet = firstSet.union(secondSet);
        System.out.println("result:");
        newSet.showSetItems();
        System.out.println();
        System.out.println();

        System.out.println("union test with emty set: ");
        System.out.println("firstSet:");
        thirdSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        emptySet.showSetItems();
        System.out.println();
        newSet = thirdSet.union(emptySet);
        System.out.println("result:");
        newSet.showSetItems();
        System.out.println();
        System.out.println();

        
        System.out.println("difference test with not emty set: ");
        System.out.println("firstSet:");
        firstSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        secondSet.showSetItems();
        System.out.println();
        newSet = firstSet.difference(secondSet);
        System.out.println("result:");
        newSet.showSetItems();
        System.out.println();
        System.out.println();

        System.out.println("difference test with emty set: ");
        System.out.println("firstSet:");
        firstSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        firstSetCopy.showSetItems();
        System.out.println();
        newSet = firstSet.difference(firstSetCopy);
        System.out.println("result:");
        newSet.showSetItems();
        System.out.println();
        System.out.println();


        System.out.println("isSubset test with full similar set: ");
        firstSetCopy.remove("9");
        System.out.println("firstSet:");
        firstSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        firstSetCopy.showSetItems();
        System.out.println();
        System.out.println(firstSet.isSubset(firstSetCopy));
        System.out.println();
        System.out.println();

        System.out.println("isSubset test with full similar set (swap parameter): ");
        System.out.println("firstSet:");
        firstSetCopy.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        firstSet.showSetItems();
        System.out.println();
        System.out.println(firstSetCopy.isSubset(firstSet));
        System.out.println();
        System.out.println();

        System.out.println("isSubset test with not similar set: ");
        firstSetCopy.put("88");
        System.out.println("firstSet:");
        firstSet.showSetItems();
        System.out.println();
        System.out.println("secondSet:");
        firstSetCopy.showSetItems();
        System.out.println();
        System.out.println(firstSet.isSubset(firstSetCopy));
        System.out.println();
    }
    
}
