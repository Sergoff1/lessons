package task9;

import java.util.*;

public class HeapSort {

    public Heap HeapObject;

    public HeapSort(int[] array) {
        HeapObject = new Heap();

        if (array == null || array.length < 1) {
            HeapObject.MakeHeap(array, 0);
            return;
        }

        int depth = (int) (Math.log(array.length) / Math.log(2)) + 1;
        HeapObject.MakeHeap(array, depth);
        for (int i : array) {
            HeapObject.Add(i);
        }
    }

    public int GetNextMax() {
        return HeapObject.GetMax();
    }

}

/*
IMPORTANT NOTE!
I took my implementation of the Heap class from a course on algorithms that was five years old, without making any changes.
It’s painful to look at now, but since the task is related to sorting, I decided not to rewrite it,
despite its high cyclomatic complexity and while loops.
I’ll write a better implementation during a second pass through the data structures course :)
 */
class Heap {
    public int [] HeapArray;

    public Heap() { HeapArray = null; }

    public void MakeHeap(int[] a, int depth) {
        HeapArray = new int[(int)Math.pow(2, depth + 1) - 1];
        Arrays.fill(HeapArray, -1);
    }

    public int GetMax() {
        if (HeapArray == null) {
            return -1;
        }
        int rootNode = HeapArray[0];

        for (int i = HeapArray.length - 1; i >= 0; i--) {
            if (HeapArray[i] != -1) {
                HeapArray[0] = HeapArray[i];
                HeapArray[i] = -1;
                i = 0;
                while (i * 2 + 2 < HeapArray.length) {
                    if (HeapArray[i*2+2] > HeapArray[i] && HeapArray[i*2+2] > HeapArray[i*2+1]) {
                        int tempNode = HeapArray[i];
                        HeapArray[i] = HeapArray[i*2+2];
                        HeapArray[i*2+2] = tempNode;
                        i = i*2+2;
                        continue;
                    } else if (HeapArray[i*2+1] > HeapArray[i]) {
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

        return rootNode;
    }

    public boolean Add(int key) {
        if (HeapArray == null) {
            return false;
        }

        for (int i = 0; i < HeapArray.length; i++) {
            if (HeapArray[i] == -1) {
                HeapArray[i] = key;
                while (HeapArray[(i-1)/2] < HeapArray[i]) {
                    int tempNode = HeapArray[i];
                    HeapArray[i] = HeapArray[(i-1)/2];
                    HeapArray[(i-1)/2] = tempNode;
                    i = (i-1)/2;
                }
                return true;
            }
        }
        return false;
    }
}

