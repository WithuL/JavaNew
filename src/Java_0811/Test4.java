package Java_0811;

import Java_0501.TreeNode;

public class Test4 {
    class Solution {
        TreeNode lca;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) {
                return null;
            }
            help(root,p,q);
            return lca;
        }
        private boolean help(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) {
                return false;
            }
            int left = help(root.left , p , q) ? 1 : 0;
            int right = help(root.right , p , q) ? 1 : 0;
            int mid = (root == p || root == q) ? 1 : 0;
            if(left + right + mid == 2) {
                lca = root;
            }
            return (left + right + mid > 0);
        }
    }
}
