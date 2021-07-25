import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] a = {1,2,3,4,5,6};
        heap.MakeHeap(a, 2);
        System.out.println("Пирамида из упорядоченного массива: ");
        System.out.println(Arrays.toString(heap.HeapArray));

        System.out.println("Пирамида из обратно упорядоченного массива: ");
        for (int i = 0; i < a.length; i++)
            a[i] = 6-i;

        heap.MakeHeap(a, 2);
        System.out.println(Arrays.toString(heap.HeapArray));

        System.out.println("Добавляем в пирамиду ключ 8: ");
        heap.Add(8);
        System.out.println(Arrays.toString(heap.HeapArray));

        System.out.println("Ключ добавляется в полную пирамиду: " + heap.Add(7));
        System.out.println(Arrays.toString(heap.HeapArray));

        System.out.println("Удаляем ключ из пирамиды: " + heap.GetMax());
        System.out.println(Arrays.toString(heap.HeapArray));

        System.out.println("Удаляем ключ из пирамиды: " + heap.GetMax());
        System.out.println(Arrays.toString(heap.HeapArray));

        heap.GetMax();
        heap.GetMax();
        heap.GetMax();
        heap.GetMax();
        heap.GetMax();

        System.out.println("Удаляем ключ из пустой пирамиды: " + heap.GetMax());
        System.out.println(Arrays.toString(heap.HeapArray));

    }
}
