package Java_0809;

import Java_0501.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Test {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) {
                return res;
            }
            dfs(root, res,0);
            return res;
        }

        public void dfs(TreeNode root, List<List<Integer>> res, int level) {
            if(level == res.size()) {
                List<Integer> tmp = new LinkedList<>();
                res.add(tmp);
            }
            if(level % 2 == 0) {
                res.get(level).add(0,root.val);
            }else {
                res.get(level).add(root.val);
            }
            if(root.left != null) {
                dfs(root.left, res, level+1);
            }
            if(root.right != null) {
                dfs(root.right, res, level+1);
            }
        }
    }
}
