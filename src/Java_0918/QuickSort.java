package Java_0918;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
    private static void quickSortHelper(int[] arr, int left, int right) {
        if(left >=  right) {
            return;
        }
        int index = partition(arr, left, right);
        quickSortHelper(arr, left, index - 1);
        quickSortHelper(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        while(l < r) {
            while(l < r && arr[l] <= arr[right]) {
                l++;
            }
            while(l < r && arr[r] >= arr[right]) {
                r--;
            }
            swap(arr, l , r);
        }
        swap(arr, l , right);
        return l;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
