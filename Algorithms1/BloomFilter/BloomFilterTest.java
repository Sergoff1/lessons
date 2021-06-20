public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilter bFil = new BloomFilter(32);
        
        // Создаём массив из 10 тестовых строк 
        //"0123456789", "1234567890", ... , "9012345678"
        String str;
        String[] arrStr = new String[10];
        for (int i = 0; i < 10; i++)
        {
            str = "";
            for (int j = 0; j < 10; j++) 
            {
                str += (j+i)%10;
            }
            arrStr[i] = str;
        }

        for(String s: arrStr)
        {
            bFil.add(s);
        }

        System.out.println("Есть ли строка в фильтре?");
        for(String s: arrStr)
        {
            System.out.print(s + ": " + bFil.isValue(s));
            System.out.println();
        }

        System.out.println();
        System.out.println("Их быть не должно: ");
        System.out.print("1234321123" + ": " + bFil.isValue("1234321123"));
        System.out.println();
        System.out.print("fvqw3f1123" + ": " + bFil.isValue("fvqw3f1123"));
        System.out.println();
        System.out.print("Qvqzzzzzza" + ": " + bFil.isValue("Qvqzzzzzza"));
        System.out.println();
        System.out.print("0000000000" + ": " + bFil.isValue("0000000000"));
        System.out.println();

    }
}
