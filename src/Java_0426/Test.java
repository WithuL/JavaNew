package Java_0426;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Test {
    public void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur;
        while(!stack.isEmpty()) {
            cur = stack.pop();
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
            System.out.println(cur.val);
        }
    }

    public Test() {
    }
}
