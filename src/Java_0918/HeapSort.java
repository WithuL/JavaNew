package Java_0918;

public class HeapSort {
    public static void heapSort(int[] arr) {
        createHeap(arr) ;
        int heapSize = arr.length;
        //重要
        for(int i = 0; i < arr.length ; i++) {
            //重要
            swap(arr, 0, heapSize - 1);
            heapSize--;
            //重要
            shiftDown(arr, 0, heapSize);
        }
    }
    private static void createHeap(int[] arr) {
        for(int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr,  i , arr.length);
        }
    }
    private static void shiftDown(int[] arr, int left, int len) {
        int parent = left;
        int child = left * 2 + 1;
        while(child < len) {
            if(child + 1 < len && arr[child+1] > arr[child]) {
                child = child+1;
            }
            if(arr[child] > arr[parent]) {
                swap(arr, child, parent);
            }else {
                break;
            }
            parent = child;
            child = parent *2 +1;
        }
    }

    public static void swap(int[] arr, int child, int parent) {
        int tmp = arr[child];
        arr[child] = arr[parent];
        arr[parent] = tmp;
    }
}
