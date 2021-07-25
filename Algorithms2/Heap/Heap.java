import java.util.*;

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи
		
    public Heap() { HeapArray = null; }
		
    public void MakeHeap(int[] a, int depth)
    {
	    // создаём массив кучи HeapArray из заданного
	    // размер массива выбираем на основе глубины depth
	    HeapArray = new int[(int)Math.pow(2, depth+1) - 1];
        Arrays.fill(HeapArray, -1);
        for (int i = 0; i < a.length; i++)
        {
            Add(a[i]);
        }
    }
		
    public int GetMax()
    {
	    // вернуть значение корня и перестроить кучу
        if (HeapArray == null) return -1;
        int rootNode = HeapArray[0];

        for (int i = HeapArray.length - 1; i >= 0; i--)
        {
            if (HeapArray[i] != -1)
            {
                HeapArray[0] = HeapArray[i];
                HeapArray[i] = -1;
                i = 0;
                while (i*2+2 < HeapArray.length)
                {
                    if (HeapArray[i*2+2] > HeapArray[i] && HeapArray[i*2+2] > HeapArray[i*2+1])
                    {
                        int tempNode = HeapArray[i];
                        HeapArray[i] = HeapArray[i*2+2];
                        HeapArray[i*2+2] = tempNode;
                        i = i*2+2;
                        continue;
                    } else if (HeapArray[i*2+1] > HeapArray[i])
                    {
                        int tempNode = HeapArray[i];
                        HeapArray[i] = HeapArray[i*2+1];
                        HeapArray[i*2+1] = tempNode;
                        i = i*2+1;
                        continue;
                    }
                    break;
                }
                break;
            }
        }

	    return rootNode; // если куча пуста вернуть -1
    }

    public boolean Add(int key)
    {
	    // добавляем новый элемент key в кучу и перестраиваем её
        if (HeapArray == null) return false;
        for (int i = 0; i < HeapArray.length; i++) 
        {
            if (HeapArray[i] == -1)
            {
                HeapArray[i] = key;
                while (HeapArray[(i-1)/2] < HeapArray[i])
                {
                    int tempNode = HeapArray[i];
                    HeapArray[i] = HeapArray[(i-1)/2];
                    HeapArray[(i-1)/2] = tempNode;
                    i = (i-1)/2;
                }
                return true;
            }
        }
	    return false; // если куча вся заполнена
    }
	
}