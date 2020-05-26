package Java_0526;

public class LeetCode {
    //除自身以外数组的乘积
    class Solution1 {
        public int[] productExceptSelf(int[] nums) {
            if(nums.length == 0) {
                return new int[0];
            }
            int[] res = new int[nums.length];
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            left[0] = 1;
            right[nums.length - 1] = 1;
            int pre = 1;
            for(int i = 1; i < nums.length; i++) {
                left[i] = nums[i-1] * left[i-1];
            }
            for(int i = nums.length - 2; i >=0 ; i--) {
                right[i] = nums[i+1] * right[i+1];
            }
            for(int i = 0; i < nums.length; i++) {
                res[i] = left[i] * right[i];
            }
            return res;
        }
    }

    //滑动窗口的最大值
    //暴力法
    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if(n == 0) {
                return new int[0];
            }
            int[] res = new int[n-k+1];
            for(int i = 0; i < nums.length - k + 1; i++) {
                int tmp = Integer.MIN_VALUE;
                for(int j = i; j < i + k; j++) {
                    tmp = Math.max(tmp,nums[j]);
                }
                res[i] = tmp;
            }
            return res;
        }
    }

    //搜索二维矩阵2
    class Solution3 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;
            if(rows == 0) {
                return false;
            }
            int cols = matrix[0].length;
            int index;
            for(int i = rows-1; i >=0; i--) {
                for(int j = 0; j < cols; j++) {
                    if(target > matrix[i][j]) {
                        continue;
                    }else if(target < matrix[i][j]) {
                        break;
                    }else{
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
