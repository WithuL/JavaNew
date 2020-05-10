package Java_0510;

public class Test {
//    选择排序
    private static void inserSort(int[] arr) {
        for(int bound = 1; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound -1;
            for(; cur >= 0; cur--) {
                if(arr[cur +1] < arr[cur]) {
                    arr[cur+1] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur+1] = tmp;
        }
    }
//希尔排序
    private static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            shellSortHelper(arr,gap);
            gap = gap / 2;
        }
        shellSortHelper(arr,1);
    }

    private static void shellSortHelper(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            int tmp = arr[gap];
            int cur = bound - gap;
            for(;cur >= 0; cur -= gap) {
                if(arr[cur] > arr[cur + bound]) {
                    arr[cur + bound] = arr[cur];
                }else{
                    break;
                }
                arr[cur + bound] = arr[cur];
            }
        }
    }
//  选择排序
    private static void selectSort(int[] arr) {
        for(int bound = 0;bound < arr.length; bound++) {
            for(int cur = bound; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    swap(arr,cur,bound);
                }
            }
        }
    }
//  冒泡排序
    private static void bubbleSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length -1 ; cur > bound; cur--) {
                if(arr[cur] < arr[cur -1]) {
                    swap(arr,cur,cur-1);
                }
            }
        }
    }
//    选择排序
    private static void insertSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = bound; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    swap(arr,bound,cur);
                }
            }
        }
    }
    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }

}
















