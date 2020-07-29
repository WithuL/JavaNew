package Java_0729;

public class ShellSort {
    public void shellSOrt(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            insertSort(arr, gap);
            gap /= 2;
        }
        insertSort(arr, 1);
    }

    public void insertSort(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            int cur = bound - gap;
            int tmp = arr[bound];
            for(; cur >= 0; cur -= gap) {
                if(arr[cur] > tmp) {
                    arr[cur+gap] = arr[cur];
                }else {
                    break;
                }
            }
            arr[cur + gap] = tmp;
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = {9,5,2,7,3,6,8};
        shellSort.shellSOrt(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
