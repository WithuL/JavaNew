package Java_0812;
import java.util.*;
public class Test {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            while(sc.hasNextInt()) {
//                int t = sc.nextInt();
//                long a = 0;
//                long b = 1;
//                long c = 0;
//                long prev = 0;
//                while(c <= t) {
//                    prev = c;
//                    c = a +  b;
//                    a = b;
//                    b = c;
//                }
//                System.out.println(Math.min(t-prev, c-t));
//            }
//        }
    public boolean inArea(int m, int n, int i , int j ,int k) {
        if(i >= m || i < 0 || j >= n || j < 0) {
            return false;
        }
        int res = 0;
        while(i != 0) {
            int tmp = i % 10;
            res += tmp;
            i /= 10;
        }
        while(j != 0) {
            int tmp = j % 10;
            res += tmp;
            j /= 10;
        }
        return res <= k;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.inArea(3,3,0,0,9));
    }
    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n+1];
            dp[1] = 1;
            for(int i = 2 ; i <= n; i++) {
                for(int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i-j], i-j));
                }
            }
            return dp[n];
        }
    }
}
