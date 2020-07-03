package Java_0703;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int res = help(arr, sum);
            System.out.println(res);
        }
    }

    private static int help(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum+1];
        for(int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= arr.length; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= arr[i-1]) {
                    dp[i][j] += dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[arr.length][sum];
    }
}
