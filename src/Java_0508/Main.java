package Java_0508;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,4,0,6,9,7,8};
        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
