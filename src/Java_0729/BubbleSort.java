package Java_0729;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length -1; cur > bound; cur--) {
                if(arr[cur-1] > arr[cur]) {
                    swap(arr, cur-1, cur);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = {9,5,2,7,3,6,8};
        bubbleSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
