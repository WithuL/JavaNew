package Java_0508;

public class SortTwice {
    //插入排序
    private static void insertSort(int[] array) {
        for(int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound -1;
            for(;cur >= 0; cur--) {
                if(array[cur] > tmp) {
                    array[cur+1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+1] = tmp;
        }
    }
    //希尔排序
    private static void shellSort(int[] arr) {
        
    }

    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }
}
