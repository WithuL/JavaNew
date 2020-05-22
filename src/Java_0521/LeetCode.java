package Java_0521;

import java.util.*;

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
    //旋转图像 这个方法不太好
    class Solution2 {
        public void rotate(int[][] matrix) {
            int rowStart = 0;
            int colStart = 0;
            int rowEnd = matrix.length - 1;
            int colEnd = matrix[0].length - 1;
            while(rowStart < rowEnd){
                helper(matrix,rowStart,colStart,rowEnd,colEnd);
                rowStart++;
                colStart++;
                rowEnd--;
                colEnd--;
            }
        }
        public void helper(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd){
            int time = rowEnd - rowStart;
            for(int i = 0; i < time ; i++) {
                int tmp = matrix[rowStart][colStart+i];
                matrix[rowStart][colStart+i] = matrix[rowEnd - i][colStart];
                matrix[rowEnd - i][colStart] = matrix[rowEnd][colEnd - i];
                matrix[rowEnd][colEnd - i] = matrix[rowStart + i][colEnd];
                matrix[rowStart + i][colEnd] = tmp;
            }
        }
    }


    //字母异位词分组
    class Solution3 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs == null || strs.length == 0 ) {
                return new ArrayList<>();
            }
            Map<String,ArrayList<String>> map = new HashMap<>();
            for(String x : strs) {
                char[] tmp = x.toCharArray();
                Arrays.sort(tmp);
                String key = String.valueOf(tmp);
                if(!map.containsKey(key)) {
                    map.put(key,new ArrayList<String>());
                }
                map.get(key).add(x);
            }
            return  new ArrayList<>(map.values());
        }
    }
}
