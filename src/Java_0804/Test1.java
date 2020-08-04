package Java_0804;

import Java_0424.Test;

public class Test1 {
    public void quickSort(int[] arr) {
        quickSortHelper(arr,0,arr.length-1);
    }
    public void quickSortHelper(int[] arr, int left,int  right) {
        if(left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        quickSortHelper(arr, left, index - 1);
        quickSortHelper(arr, index, right);
    }

    public int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        while(i < j) {
            while(i < j && arr[i] <= arr[right]){
                i++;
            }
            while( i < j && arr[j] >= arr[right]) {
                j--;
            }
            swap(arr, i , j);
        }
        swap(arr, i , right);
        return i;
    }

    public void swap(int[] arr, int i ,int j) {
        int tmp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] arr = {9,5,2,7,3,6,8};
        test1.quickSort(arr);
        for(int x :  arr) {
            System.out.print(x+" ");
        }
    }
}
