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
}
