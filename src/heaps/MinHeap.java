package heaps;

public class MinHeap {

    private void minHeapify(int[] heapArray, int index, int heapSize) {
        int minimumIndex = index;

        while (minimumIndex < heapSize/2) {
            int left = (2*index)+1;
            int right = (2*index)+2;

            if(left < heapSize && heapArray[left] < heapArray[index]) {
                minimumIndex = left;
            }

            if(right < heapSize && heapArray[right] < heapArray[minimumIndex]) {
                minimumIndex = right;
            }

            if(minimumIndex != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[minimumIndex];
                heapArray[minimumIndex] = temp;
                index = minimumIndex;
            } else {
                break;
            }
        }
    }

    public void buildMinHeap(int[] heapArray, int heapSize) {

        for(int i= (heapSize - 1)/2 ;  i>= 0; i++) {
            minHeapify(heapArray, i, heapSize);
        }

    }

    public static void main(String[] args) {
        int[] heapArray = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };
    }
}
