package Java_0528;

import java.util.Stack;

public class LeetCode {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution1 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null) {
                return t2;
            }
            Stack<TreeNode[]> stack = new Stack<>();
            stack.push(new TreeNode[] {t1,t2});
            while(!stack.empty()) {
                TreeNode[] cur = stack.pop();
                if(cur[0] == null || cur[1] == null) {
                    continue;
                }
                cur[0].val += cur[1].val;
                if(cur[0].left == null) {
                    cur[0].left = cur[1].left;
                }else{
                    stack.push(new TreeNode[] {cur[0].left,cur[1].left});
                }
                if(cur[0].right == null) {
                    cur[0].right = cur[1].right;
                }else{
                    stack.push(new TreeNode[] {cur[0].right,cur[1].right});
                }
            }
            return t1;
        }
    }
}
