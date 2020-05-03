package Java_0503;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    //数组中数字出现的次数
    class Solution1 {
        public int[] singleNumbers(int[] nums) {
            int y = 0;
            for(int x : nums) {
                y ^= x;
            }
            int w = 1;
            while((w & y) == 0) {
                w <<= 1;
            }
            int a = 0;
            int b = 0;
            for(int x : nums) {
                if((x & w)== 0) {
                    a ^= x;
                }else{
                    b ^= x;
                }
            }
            return new int[]{b,a};
        }
    }
    // 和为s的连续正数序列
    class Solution2 {
        public int[][] findContinuousSequence(int target) {
            int i = 1; // 滑动窗口的左边界
            int j = 2; // 滑动窗口的右边界
            int sum = 3; // 滑动窗口中数字的和
            List<int[]> res = new ArrayList<>();
            while(i <= target / 2) {
                if(sum < target) {
                    j++;
                    sum += j;
                }else if(sum > target) {
                    sum -= i;
                    i++;
                }else {
                    int[] arr = new int[j-i+1];
                    int tmp = i;
                    for(int k = 0; k < arr.length; k++) {
                        arr[k] = tmp++;
                    }
                    res.add(arr);
                    sum -= i;
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
