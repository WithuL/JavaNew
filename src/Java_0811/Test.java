package Java_0811;
import Java_0501.TreeNode;

import java.util.*;
public class Test {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, sum);
            return res;
        }
        public void dfs(TreeNode root, int sum) {
            if(root == null) {
                return;
            }
            tmp.add(root.val);
            sum -= root.val;
            if(sum == 0 && root.left == null && root.right == null) {
                res.add((List)new ArrayList(tmp));
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
            tmp.remove(tmp.size()-1);
        }
    }
}
