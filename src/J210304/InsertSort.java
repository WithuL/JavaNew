package J210304;

public class InsertSort {
    static int[] arr = new int[100];
    public static void sort(){
        for(int bound = 1; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur--) {
                if(arr[cur] > tmp) {
                    arr[cur+1] = arr[cur];
                }else {
                    break;
                }
            }
            arr[cur+1] = tmp;
        }
    }
}
