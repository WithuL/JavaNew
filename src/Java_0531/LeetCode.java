package Java_0531;
import java.util.Arrays;
public class LeetCode {
    //最长上升子序列 解法一
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            if(nums.length < 2) {
                return nums.length;
            }
            int[] dp = new int[nums.length];
            Arrays.fill(dp,1);
            for(int i = 1; i < nums.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j]+1,dp[i]);
                    }
                }
            }
            int res = 1;
            for(int i = 0; i < nums.length ; i++) {
                res = Math.max(dp[i],res);
            }
            return res;
        }
    }

    //最佳买卖股票时机含冷冻期
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            int pre = 0;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, pre - prices[i]);
                pre = temp;
            }
            return dp_i_0;
        }
    }
    //123. 买卖股票的最佳时机 III
    class Solution3 {
        public int maxProfit(int[] prices) {
            int dp_i_1_0 = 0, dp_i_1_1 = Integer.MIN_VALUE,
                    dp_i_2_0 = 0, dp_i_2_1 = Integer.MIN_VALUE;
            for(int price : prices) {
                dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + price);
                dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - price);
                dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + price);
                dp_i_1_1 = Math.max(dp_i_1_1, - price);
            }
            return dp_i_2_0;
        }
    }
}
