package Java_0704;

public class Sort {
    public void bubbleSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length; cur > bound; cur--) {
                if(arr[cur-1] > arr[cur]) {
                    swap(arr, cur-1, cur);
                }
            }
        }
    }

    public void bubbleSort2(int[] arr) {
        for(int bound = 0; bound < arr.length - 1; bound++) {
            for(int cur = 0; cur < arr.length - 1 - bound; cur++) {
                if(arr[cur] > arr[cur+1]) {
                    swap(arr, cur ,cur+1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int cur) {
        int tmp = arr[i];
        arr[i] = arr[cur];
        arr[cur] = tmp;
    }
}
