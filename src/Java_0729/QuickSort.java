package Java_0729;

import Java_0612.Queue;

public class QuickSort {
    public void QuickSort(int[] arr) {
        QuickSortHelper(arr, 0, arr.length - 1);
    }

    private void QuickSortHelper(int[] arr, int left, int right) {
        if(left >= right) {
            return ;
        }
        int index = partion(arr, left, right);
        QuickSortHelper(arr, left, index-1);
        QuickSortHelper(arr, index, right);
    }

    private int partion(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        while(i < j) {
            while(i < j && arr[i] <= arr[right]) {
                i++;
            }
            while(i < j && arr[j] >= arr[right]) {
                j--;
            }
            swap(arr, i , j);
        }
        swap(arr, i ,right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {9,5,2,7,3,6,8};
        quickSort.QuickSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
