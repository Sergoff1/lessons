public class HashTable
  {
    public int size;
    public int step;
    public String [] slots; 

    public HashTable(int sz, int stp)
    {
      size = sz;
      step = stp;
      slots = new String[size];
      for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
          // всегда возвращает корректный индекс слота
      byte[] bytesOfValue = value.getBytes();
      int bytesSum = 0;

      for (int i = 0; i < bytesOfValue.length; i++) 
      {
        bytesSum += bytesOfValue[i];
      } 
      
      return Math.abs(bytesSum%size);
    }

    public int seekSlot(String value)
    {
          // находит индекс пустого слота для значения, или -1
      int baseSlot = hashFun(value);
      if (slots[baseSlot] == null) return baseSlot;

      for (int i = baseSlot + step; i < baseSlot + step + (size * step); i += step) 
      {
        if (slots[i%size] == null) return i%size;
      }
         
      return -1;
    }

     public int put(String value)
     {
         // записываем значение по хэш-функции
         // возвращается индекс слота или -1
         // если из-за коллизий элемент не удаётся разместить
      int slotForPut = seekSlot(value);
      if(slotForPut != -1) 
      {
        slots[slotForPut] = value;
        return slotForPut;
      } else return -1;
     }

     public int find(String value)
     {
         // находит индекс слота со значением, или -1
      int baseSlot = hashFun(value);

      if (slots[baseSlot] == null) return -1;
      if (slots[baseSlot].equals(value)) return baseSlot;

      for (int i = baseSlot + step; i < baseSlot + step + (size * step); i += step) 
      {
        if (slots[i%size] != null) 
        {
          if (slots[i%size].equals(value)) return i%size;
        }
      }

      return -1;
     }
  }
