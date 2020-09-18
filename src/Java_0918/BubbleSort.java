package Java_0918;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length -1; cur > bound; cur--) {
                if(arr[cur] < arr[cur-1]) {
                    swap(arr, cur , cur -1);
                }
            }
        }
    }

    private static void swap(int[] arr, int cur, int right) {
        int tmp = arr[cur];
        arr[cur] = arr[right];
        arr[right] = tmp;
    }
}
