package Java_0706;

import java.util.Arrays;

public class mergeSort {
    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr,0, arr.length );
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right ) /2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid, right);
        merge(arr,left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] temp = new int[right - left];
        int index = 0;
        while(cur1 < mid && cur2 < right) {
            if(arr[cur1] <= arr[cur2]) {
                temp[index] = arr[cur1];
                cur1++;
                index++;
            }else{
                temp[index] = arr[cur2];
                cur2++;
                index++;
            }
        }
        while(cur1 < mid){
            temp[index] = arr[cur1];
            cur1++;
            index++;
        }
        while(cur2 < right) {
            temp[index] = arr[cur2];
            index++;
            cur2++;
        }
        for(int i = 0; i < right - left; i++) {
            arr[left + i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        // quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
