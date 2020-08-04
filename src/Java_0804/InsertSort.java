package Java_0804;

public class InsertSort {
    public void insertSort(int[] arr) {
        for (int bound = 1; bound < arr.length; bound++) {
            int cur = bound -1 ;
            int tmp = arr[bound];
            for(; cur >= 0; cur--) {
                if(arr[cur] > tmp ) {
                    arr[cur+1] = arr[cur];
                }else {
                    break;
                }
            }
            arr[cur+1] = tmp;
        }
    }
}