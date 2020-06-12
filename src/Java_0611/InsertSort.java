package Java_0611;

import java.util.Arrays;

public class InsertSort {
    public static void insert(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = bound; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[bound];
                    arr[bound] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
