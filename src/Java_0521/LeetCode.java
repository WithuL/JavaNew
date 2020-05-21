package Java_0521;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    //全排列
    class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] used = new boolean[len];
            if(len == 0) {
                return res;
            }
            dfs(nums,len,0,path,used,res);
            return res;
        }
        public void dfs(int[] nums,int len,int depth,List<Integer> path,boolean[] used,List<List<Integer>> res ){
            if(depth == len) {
                res.add(new ArrayList<Integer>(path));
            }
            for(int i = 0; i < len; i++) {
                if(!used[i]){
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(nums,len,depth + 1,path,used,res);
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
