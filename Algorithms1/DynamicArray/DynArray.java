public class DynArray<T>
{
     public T [] array;
     public int count;
     public int capacity;
     Class clazz;

     public DynArray(Class clz)
     {
       clazz = clz; // нужен для безопасного приведения типов
       // new DynArray<Integer>(Integer.class);

       count = 0;
       makeArray(16);
     }

     public void makeArray(int new_capacity)
     {
        if (new_capacity < 16) new_capacity = 16;

        T[] bufferArray = array;
        array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
        if (bufferArray != null) {
          System.arraycopy(bufferArray, 0, array, 0, count);
        }
        
        capacity = new_capacity;
     }

     public T getItem(int index)
     {

       try {
         return array[index];

       } catch (IndexOutOfBoundsException e) {
         e.getMessage();
       }

       return null;
     }

     public void append(T itm)
     {
       if (count == capacity) {
         this.makeArray(capacity*2);
       }
       array[count] = itm;
       count++;

     }

     public void insert(T itm, int index)
     {
      try {

        if (index == count) {
          this.append(itm);
          return;
        }

        array[index] = array[index];

        if (count == capacity) {
          this.makeArray(capacity * 2);
        }

        for (int i = count; i > index; i--) {
          array[i] = array[i-1];
        }

        array[index] = itm;

        count++;

      } catch (IndexOutOfBoundsException e) {
        e.getMessage();
      }
       
     }

     public void remove(int index)
     {
      
      try {

        array[index] = array[index];

        for (int i = index; i < count; i++) {
          array[i] = array[i+1];
        }
        
        count--;

        if ((double)count/capacity < 0.5) {
          this.makeArray((int)(capacity/1.5));
        }

      } catch (IndexOutOfBoundsException e) {
        e.getMessage();
      }

     }

}