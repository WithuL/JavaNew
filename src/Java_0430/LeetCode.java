package Java_0430;

public class LeetCode {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;
    }
    //二叉树的镜像
    class Solution1 {
        public TreeNode mirrorTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
        }
    }
}
