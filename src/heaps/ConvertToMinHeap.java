package heaps;

import java.util.Arrays;

public class ConvertToMinHeap {
    void convertMax(int []maxHeap) {
        int length = maxHeap.length;
        for (int i=(length-1/2); i>=0; i--) {
            convertToMinHeap(maxHeap, i, length);
        }
    }

    private void convertToMinHeap(int []maxHeap, int index, int heapSize) {
        int minimumIndex = index;

        while (minimumIndex < heapSize/2) {
            int left = (index * 2) + 1;
            int right = (index * 2) + 2;

            if(left < heapSize && maxHeap[left] < maxHeap[index]) {
                minimumIndex = left;
            }

            if(right < heapSize && maxHeap[right] < maxHeap[minimumIndex]) {
                minimumIndex = right;
            }

            if(minimumIndex != index) {
                int temp = maxHeap[index];
                maxHeap[index] = maxHeap[minimumIndex];
                maxHeap[minimumIndex] = temp;
                index = minimumIndex;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] heapArray =  {31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };
        System.out.println("Before Converting "+ Arrays.toString(heapArray));
        new ConvertToMinHeap().convertMax(heapArray);
        System.out.println("After Converting "+ Arrays.toString(heapArray));
    }
}
