package Java_0706;

import java.util.Arrays;

public class Sort {
    //非递归方式
    private static void quickSort(int[] array) {
        quickSortHelper(array,0 , array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array,left,index-1);
        System.out.println(Arrays.toString(array));
        quickSortHelper(array, index +1, right);
        System.out.println(Arrays.toString(array));

    }

    private static int partition(int[] array, int left , int right) {
        int base = array[right];
        int i = left;
        int j = right;
        while(i < j) {
            while(i < j&& array[i] <= base) {
                i++;
            }
            while(i < j && array[j] >= base) {
                j--;
            }
            if(i < j) {
                swap(array, i , j);
            }
        }
        swap(array, i, right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        // quickSortByLoop(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
