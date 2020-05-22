package Java_0508;

public class ShellSort {
    //希尔排序
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            inserSortGap(arr,gap);
            gap = gap / 2;
        }
        inserSortGap(arr,1);
    }

    private static void inserSortGap(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - gap;
            for(;cur >= 0; cur -= gap) {
                if(arr[cur] > tmp) {
                    arr[cur + gap] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur + gap] = tmp;
        }
    }
}
