package J210304;

import static Java_0918.HeapSort.swap;

public class BubbleSort {
    public static void sort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length - 1; cur > bound; cur--) {
                if(arr[cur - 1] > arr[cur]) {
                    swap(arr,cur,cur -1);
                }
             }
        }
    }
}
