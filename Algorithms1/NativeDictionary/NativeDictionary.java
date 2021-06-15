import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    private int step = 1;

    public NativeDictionary(int sz, Class clazz)
    {
      size = sz;
      slots = new String[size];
      values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
      // всегда возвращает корректный индекс слота
      byte[] bytesOfKey = key.getBytes();
      int bytesSum = 0;

      for (int i = 0; i < bytesOfKey.length; i++) 
      {
        bytesSum += bytesOfKey[i];
      } 
      
      return Math.abs(bytesSum%size);
    }

    public boolean isKey(String key)
    {
      // возвращает true если ключ имеется,
      // иначе false
      int baseSlot = hashFun(key);

      if (slots[baseSlot] == null) return false;
      if (slots[baseSlot].equals(key)) return true;

      for (int i = baseSlot + step; i < baseSlot + step + (size * step); i += step) 
      {
        if (slots[i%size] != null) 
        {
          if (slots[i%size].equals(key)) return true;
        }
      }

      return false;
    }

    public int seekSlot(String key)
    {
          // находит индекс пустого слота для значения, или -1
      int baseSlot = hashFun(key);
      if (slots[baseSlot] == null) return baseSlot;

      for (int i = baseSlot + step; i < baseSlot + step + (size * step); i += step) 
      {
        if (slots[i%size] == null) return i%size;
      }
         
      return -1;
    }

    public void put(String key, T value)
    {
      // гарантированно записываем 
      // значение value по ключу key
      if (isKey(key)) 
      {
        int baseSlot = hashFun(key);

        if (slots[baseSlot].equals(key))
        {
          values[baseSlot] = value;
          return;
        }
  
        for (int i = baseSlot + step; i < baseSlot + step + (size * step); i += step) 
        {
          if (slots[i%size] != null) 
          {
            if (slots[i%size].equals(key)) {
              values[baseSlot] = value;
              return;
            }
          }
        }

      } else
      {
        int slotForPut = seekSlot(key);

        if (slotForPut != -1) 
        {
          slots[slotForPut] = key;
          values[slotForPut] = value;
          return;
        }
      }

    }

    public T get(String key)
    {
      // возвращает value для key, 
      // или null если ключ не найден
      int baseSlot = hashFun(key);

      if (slots[baseSlot] == null) return null;
      if (slots[baseSlot].equals(key)) return values[baseSlot];

      for (int i = baseSlot + step; i < baseSlot + step + (size * step); i += step) 
      {
        if (slots[i%size] != null) 
        {
          if (slots[i%size].equals(key)) return values[i%size];
        }
      }

      return null;
    }
}