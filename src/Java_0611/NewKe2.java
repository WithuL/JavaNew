package Java_0611;
import java.util.*;
public class NewKe2 {

    public static class Robot {
        public int countWays(int x, int y) {
            // write code here
            if(x < 2 || y < 2) {
                return 1;
            }
            int[][] dp = new int[x][y];
            for(int i = 0; i < x; i++) {
                dp[i][0] = 1;
            }
            for(int i = 0; i < y; i++) {
                dp[0][i] = 1;
            }
            for(int i = 1; i < x; i++) {
                for(int j = 1; j < y; j++) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
            return dp[x -1][y-1];
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.countWays(2, 6));
    }
}
