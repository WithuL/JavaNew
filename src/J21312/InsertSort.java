package J21312;

public class InsertSort {
    public static void insertSort(int[] arr) {
        for(int bound = 1; bound < arr.length; bound++) {
            int v = arr[bound];
            int cur = bound;
            for(;cur >= 0; cur--) {
                if(arr[cur] > v) {
                    arr[cur+1] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur+1] = v;
        }
    }
}
