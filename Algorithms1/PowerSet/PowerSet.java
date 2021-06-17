import java.util.ArrayList;

public class PowerSet
{

    private int count;
    private String[] slots;
    private int step = 1;

    public PowerSet()
    {
         // ваша реализация хранилища
        slots = new String[20];
        count = 0;
    }

    private int hashFun(String value) 
    {
        return Math.abs(value.hashCode() % (slots.length - 1));
    }

    private int seekSlot(String value)
    {
          // находит индекс пустого слота для значения, или -1
        int baseSlot = hashFun(value);
        if (slots[baseSlot] == null) return baseSlot;

        for (int i = baseSlot + step; i < baseSlot + step + (slots.length * step); i += step) 
        {
            if (slots[i%slots.length] == null) return i%slots.length;
        }
         
        return -1;
    }

    private int find(String value)
    {
        // находит индекс слота со значением, или -1
        int baseSlot = hashFun(value);

        if (slots[baseSlot] == null) return -1;
        if (slots[baseSlot].equals(value)) return baseSlot;

        for (int i = baseSlot + step; i < baseSlot + step + (slots.length * step); i += step) 
        {
            if (slots[i%slots.length] != null) 
            {
                if (slots[i%slots.length].equals(value)) return i%slots.length;
            }
        }

        return -1;
    }

    public int size()
    {
        return count;
    }


    public void put(String value)
    {
        if (!get(value)) 
        {
            slots[seekSlot(value)] = value;
            count++;
        }
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        return find(value) >= 0;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        if (get(value)) 
        {
            slots[find(value)] = null;
            count--;
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet outputSet = new PowerSet();
        for (int i = 0; i < slots.length; i++)
        {
            if(this.slots[i] != null) 
            {
                if (set2.get(this.slots[i])) outputSet.put(this.slots[i]);
            }
        }

        return outputSet;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        PowerSet outputSet = new PowerSet();
        for (int i = 0; i < slots.length; i++) 
        {
            if(slots[i] != null) outputSet.put(slots[i]);
            if(set2.slots[i] != null) outputSet.put(set2.slots[i]);
        }

        return outputSet;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        PowerSet outputSet = new PowerSet();
        for (int i = 0; i < slots.length; i++) 
        {
            if (slots[i] != null) 
            {
                if (!set2.get(slots[i])) outputSet.put(slots[i]);
            }
            
            if (set2.slots[i] != null) 
            {
                if (!this.get(set2.slots[i])) outputSet.put(set2.slots[i]);
            }
        }

        return outputSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        for (int i = 0; i < set2.slots.length; i++)
        {
            if (set2.slots[i] != null)
            {
                if(!this.get(set2.slots[i])) return false;
            }
        }

        return true;
    }

    void showSetItems()
    {
        for (int i = 0; i < slots.length; i++)
        {
            if(slots[i] != null) System.out.print(slots[i] + " ");
        }
    }

}
