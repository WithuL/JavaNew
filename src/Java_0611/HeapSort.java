package Java_0611;

public class HeapSort {
    public static void heapSort(int[] arr) {
        //1.建立堆
        createHeap(arr);
        int heapSize = arr.length;
        for(int i = 0; i < arr.length - 1; i++) {
            int tmp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
            heapSize--;
            shifDorn(arr,0,heapSize);
        }
    }

    private static void createHeap(int[] arr) {
    }

    private static void shifDorn(int[] arr, int i, int heapSize) {
    }
}
