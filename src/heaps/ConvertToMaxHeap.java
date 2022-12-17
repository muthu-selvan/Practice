package heaps;

public class ConvertToMaxHeap {

    public static void convertMax(int[] maxHeap) {
        int length = maxHeap.length;
        for(int i=(length-1)/2; i>=0; i--) {
            convertMax(maxHeap, i, length);
        }
    }

    private static void convertMax(int[] minHeap, int index, int heapSize) {
        int maxIndex = index;

        while (maxIndex < heapSize/2) {
            int left = (index * 2)+1;
            int right = (index * 2)+2;

            if(left < heapSize && minHeap[left] > minHeap[index]) {
                maxIndex= left;
            }

            if(right < heapSize && minHeap[right] > minHeap[maxIndex]) {
                maxIndex = right;
            }

            if(index != maxIndex) {
                int temp = minHeap[index];
                minHeap[index] = minHeap[maxIndex];
                minHeap[maxIndex] = temp;

                index = maxIndex;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] heapArray =  {31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };
    }
}
