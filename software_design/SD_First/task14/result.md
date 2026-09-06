```java
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
```

Перегрузку `quickSort(int[] arr)` добавил для удобства, поэтому её рассматривать не будем.

Тройка Хоара для `partition(arr, low, high)`:  
`{P: arr.length > 0, low >= 0, low < high < arr.length} partition(arr, low, high) {Q: элементы arr[low..partitionIndex] <= arr[partitionIndex], а элементы arr[partitionIndex+1..high] > arr[partitionIndex], res = partitionIndex}`

Определим инвариант цикла для `partition(arr, low, high)`:  
`I: j >= low AND j < high AND i <= j AND arr[low..i] <= pivot AND arr[i+1..j-1] > pivot`

Доказательство инварианта.
1. Инициализация:  
   До начала первой итерации цикла: j = low и i = low - 1  
   Проверка инварианта: `low <= j < high AND i <= j`, диапазоны `arr[low..i]` и `arr[i+1..j-1]` пустые, поэтому их условия `arr[low..i] <= pivot` и `arr[i+1..j-1] > pivot` соблюдаются.  
   Инвариант истинен в начале.

2. Сохранение инварианта:  
   Предположим, что инвариант истинен для некоторого j, то есть `low <= j < high AND i <= j AND arr[low..i] <= pivot AND arr[i+1..j-1] > pivot`  
   На следующем шаге цикла проверяем `arr[j] <= pivot`. Если это так, то инкрементируем i и переставляем местами элементы `arr[i]` и `arr[j]`, иначе оставляем всё как есть и идём дальше.  
   В любом случае инвариант остаётся истинен: `low <= j < high AND i <= j AND arr[low..i] <= pivot AND arr[i+1..j-1] > pivot`.  

3. Завершение:  
   Цикл завершается, когда j становится равным high  
   На этом этапе `элементы arr[low..partitionIndex] <= pivot, а элементы arr[partitionIndex+1..high] > pivot`.
   Затем мы переставляем `arr[high]` и `arr[i+1]` и возвращаем `i+1`, который представляет собой `partitionIndex`; 
   Следовательно, постусловие выполняется.


Тройка Хоара для `quickSort(arr, low, high)`:  
`{P: low >= 0, 0 < high < arr.length} quickSort(arr, low, high) {Q: arr отсортирован по возрастанию}`  

Если `low >= high`, считаем массив отсортированным.  
Иначе делим массив на две части корректным методом `partition(arr, low, high)`, так что получаем `arr[low..partitionIndex] <= arr[partitionIndex], а элементы arr[partitionIndex+1..high] > arr[partitionIndex]`, 
элемент `arr[partitionIndex]` при этом оказывается в верной позиции и мы рекурсивно вызываем `quickSort(arr, low, partitionIndex - 1)` и `quickSort(arr, partitionIndex + 1, high)`, которые сортируют оставшиеся подмассивы меньшего размера с двух сторон от элемента `arr[partitionIndex]`.  
При завершении рекурсивных вызовов получаем массив, с элементами, которые идут по возрастанию.