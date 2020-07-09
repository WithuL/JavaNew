package Java_0709;

import java.util.Scanner;

public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] value = new int[n];
            int[]  dp = new int[sum+1];
            dp[0] = 1;
            for(int i = 0; i < n; i++) {
                value[i] = sc.nextInt();
                for(int j = sum; j >= 0; j--) {
                    if(j > value[i]) {
                        dp[j] += dp[j-value[i]];
                    }
                }
            }
            System.out.println(dp[sum]);
        }
    }
}
