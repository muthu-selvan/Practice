package heaps;

import java.util.Arrays;

public class FindKSmallElmntFromArray {

    public static int[] findKSmallest(int[] arr,int k) {

        int[] result = new int[k];

        for(int i=0;i<k;i++) {
            buildMinHeap(arr);
            int min = arr[0];
            result[i] = min;

            arr[0] = arr[arr.length-1];
        }
        // Write - Your - Code
        return result;
    }

    private static void buildMinHeap(int[] array) {
        int length = array.length;

        for(int i=(length-1)/2; i>=0; i--) {
            buildMinHeap(array, i, length);
        }
    }

    private static void buildMinHeap(int[] heapArray, int index, int heapSize) {
        int minIndex = index;

        while(minIndex < heapSize/2) {
            int left = (index * 2)+1;
            int right = (index * 2)+2;

            if(left < heapSize && heapArray[left] < heapArray[index]) {
                minIndex = left;
            }

            if(right < heapSize && heapArray[right] < heapArray[minIndex]) {
                minIndex = right;
            }

            if(minIndex != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[minIndex];
                heapArray[minIndex] = temp;
                index = minIndex;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,4,7,1,-2,6,5};

        System.out.println(Arrays.toString(findKSmallest(arr, 3)));
    }
}
