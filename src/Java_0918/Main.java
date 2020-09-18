package Java_0918;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {3,5,4,0,6,9,7,8};
        InsertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}