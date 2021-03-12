package J21312;

public class ShellSort {
    public static void ShellSort(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            insertSort(arr, gap);
            gap = gap/2;
        }
        insertSort(arr, 1);
    }

    private static void insertSort(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            int v = arr[bound];
            int cur = bound-gap;
            for(; cur >= 0; cur -= gap) {
                if(arr[cur] > v) {
                    arr[cur + gap] = v;
                }else{
                    break;
                }
            }
            arr[cur+gap] = v;
        }
    }
}
