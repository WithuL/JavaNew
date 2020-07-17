package Java_0717;

import java.util.Arrays;
import java.util.Scanner;

public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int prev = 0, count = 0, sum = 0;
            for(int i = 0; i < n; i++) {
                if(prev != arr[i] ) {
                    if(count % 2 == 1) {
                        if(sum != 0) System.out.print(" ");
                        System.out.print(prev);
                        sum++;
                    }
                    count = 1;
                    prev = arr[i];
                    continue;
                }
                count++;
                prev = arr[i];
            }
            if(sum < 2) System.out.println(" " + arr[n-1]);
        }
    }
}
