public class BloomFilter
{
      public int filter_len;
      private int[] bitArray;
      private int wordSize = 32;

      public BloomFilter(int f_len)
      {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        bitArray = new int[f_len/wordSize + (f_len%wordSize == 0 ? 0 : 1)];
      }

      // хэш-функции
      public int hash1(String str1)
      {
        // 17
        int lastIterationResult = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            lastIterationResult = (lastIterationResult * 17 + code)%filter_len; 
        }
        // реализация ...
        return lastIterationResult;
      }

      public int hash2(String str1)
      {
        // 223
        int lastIterationResult = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            lastIterationResult = (lastIterationResult * 223 + code)%filter_len; 
        }
        // реализация ...
        return lastIterationResult;
      }

      public void add(String str1)
      {
        // добавляем строку str1 в фильтр
        int position1 = hash1(str1);
        int position2 = hash2(str1);

        bitArray[position1/wordSize] |= (1 << (position1 - position1/wordSize * wordSize));
        bitArray[position2/wordSize] |= (1 << (position2 - position2/wordSize * wordSize));
      }

      public boolean isValue(String str1)
      {
        // проверка, имеется ли строка str1 в фильтре
        int position1 = hash1(str1);
        int position2 = hash2(str1);
        int mask1 = (1 << (position1 - position1/wordSize * wordSize));
        int mask2 = (1 << (position2 - position2/wordSize * wordSize));

        return (bitArray[position1/wordSize] & mask1) != 0 && (bitArray[position2/wordSize] & mask2) != 0;
      }
}