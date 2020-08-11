package Java_0811;
import Java_0501.TreeNode;

import java.util.*;
public class Test2 {
    class Solution {
        public int kthLargest(TreeNode root, int k) {
            if(root == null || k == 0) {
                return 0;
            }
            ArrayList<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(!stack.empty() || cur != null) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res.get(res.size()-k);
        }
    }
}
