package J210304;

public class ShellSort {

    public void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            sortHelper(arr, gap);
            gap = gap/2;
        }

    }

    private void sortHelper(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++){
            int tmp = arr[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur-=gap) {
                if(arr[cur] > tmp) {
                    arr[cur + gap] = arr[cur];
                }else {
                    break;
                }
            }
            arr[cur + gap] = tmp;
        }
    }
}
