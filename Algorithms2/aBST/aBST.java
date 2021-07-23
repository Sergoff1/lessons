import java.util.*;

 class aBST
{
    public Integer Tree []; // массив ключей
	
    public aBST(int depth)
    {
      // правильно рассчитайте размер массива для дерева глубины depth:
      int tree_size = (int)Math.pow(2, depth+1) - 1;
      Tree = new Integer[ tree_size ];
      for(int i=0; i<tree_size; i++) Tree[i] = null;
    }
	
    public Integer FindKeyIndex(int key)
    {
      // ищем в массиве индекс ключа
      
      for (int i = 0; i < Tree.length; i++)
      {
        if (Tree[i] == null) return -i;

        if (key == Tree[i]) return i;

        if (key < Tree[i])
        {
          i = 2*i;
          continue; 
        } else if (key > Tree[i])
        {
          i = i*2 + 1;
          continue;
        }
      }
      return null; // не найден
    }
	
    public int AddKey(int key)
    {
      // добавляем ключ в массив
      Integer keyIndex = FindKeyIndex(key);
      if (keyIndex == null) return -1;

      if (keyIndex >= 0 && Tree[0] != null) return keyIndex;
      else Tree[Math.abs(keyIndex)] = key;

      return Math.abs(keyIndex); 
      // индекс добавленного/существующего ключа или -1 если не удалось
    }
	
}