package Java_0522;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {
//    跳跃游戏
    class Solution1 {
        public boolean canJump(int[] nums) {
            int max = 0;
            for(int i = 0; i < nums.length; i++) {
                if(max < i) {
                    return false;
                }
                max = Math.max(max,i + nums[i]);
            }
            return true;
        }
    }
    //合并区间
    class Solution {
        public int[][] merge(int[][] intervals) {
            int[][] res = new int[intervals.length][2];
            if(intervals.length == 0) {
                return res;
            }else if(intervals.length == 1) {
                return intervals;
            }
            Arrays.sort(intervals,( o1,  o2) -> o1[0] - o2[0]);
            List<int[]> ret = new ArrayList<>();
            int[] tmp = intervals[0];
            for(int i = 1; i < intervals.length ; i++) {
                if(tmp[0] <= intervals[i][0] && tmp[1] >= intervals[i][1]){
                    continue;
                }
                if(tmp[1] >= intervals[i][0]) {
                    tmp[1] = intervals[i][1];
                }else{
                    ret.add(tmp);
                    tmp = intervals[i];
                }
            }
            ret.add(tmp);
            for(int i = 0 ; i < ret.size() ; i++) {
                res[i] = ret.get(i);
            }
            return Arrays.copyOf(res,ret.size());
        }
    }
    //不同路径

    //递归解法：超时
    class Solution3 {
        public int uniquePaths(int m, int n) {
            int row = 1;
            int col = 1;
            return helper(row,col,m,n);
        }
        public int helper(int row, int col ,int m, int n) {
            if(row == m && col == n) {
                return 1;
            }
            int res = 0;
            if(row < m) {
                res += helper(row + 1,col,m,n);
            }
            if(col < n) {
                res += helper(row ,col +1, m , n);
            }
            return res;
        }
    }

    //动态规划
    class Solution4 {
        public int uniquePaths(int m, int n) {
            //这个数组用来存储到达res[i][j]位置有多少种方法
            int[][] res= new int[m][n];
            for(int i = 0; i < m; i++) {
                res[i][0] = 1;
            }
            for(int i = 0; i < n; i++) {
                res[0][i] = 1;
            }
            //去除掉最外层开始计算
            for(int i = 1 ; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
            return res[m-1][n-1];
        }
    }

    //最小路径和
    class Solution5 {
        public int minPathSum(int[][] grid) {
            for(int i = 0; i < grid.length; i++){
                for(int j = 0;j < grid[0].length; j++){
                    if(i ==0 && j == 0) {
                        continue;
                    }else if(i == 0 ){
                        grid[i][j] += grid[i][j-1];
                    }else if(j == 0) {
                        grid[i][j] += grid[i-1][j];
                    }else {
                        grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                    }
                }
            }
            return grid[grid.length-1][grid[0].length-1];
        }
    }
}
