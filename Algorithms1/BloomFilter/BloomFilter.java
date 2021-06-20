public class BloomFilter
{
      public int filter_len;
      private int filter = 0;

      public BloomFilter(int f_len)
      {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
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
        filter = filter | (1 << hash1(str1)) | (1 << hash2(str1));
      }

      public boolean isValue(String str1)
      {
        // проверка, имеется ли строка str1 в фильтре
        // Сравниваем маску с результатом её наложения на фильтр
        return (filter & ((1<<hash1(str1)) | (1 << hash2(str1)))) == ((1<<hash1(str1)) | (1 << hash2(str1)));
      }
}