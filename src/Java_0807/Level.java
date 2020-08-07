package Java_0807;

import Java_0501.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level {
    class Solution {
        List<List<Integer>> res  = new LinkedList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) {
                return res;
            }
            levelOrder(root, 0);
            return res;
        }
        public void levelOrder(TreeNode root, int i) {
            if(i == res.size()) {
                res.add(new LinkedList<Integer>());
            }
            List<Integer> tmp = res.get(i);
            tmp.add(root.val);

        }
    }

    class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null) {
                return res;
            }
            queue.add(root);
            while(!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> tmp = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    TreeNode cur = queue.poll();
                    tmp.add(cur.val);
                    if(cur.left != null) {
                        queue.add(cur.left);
                    }
                    if(cur.right != null) {
                        queue.add(cur.right);
                    }
                }
                res.add(tmp);
            }
            return res;
        }
    }
}
