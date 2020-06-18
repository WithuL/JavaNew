package Java_0618;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            if(n == 0) {
                return;
            }
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            int cnt = 0;
            for(int x : arr) {
                if(x == target) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
