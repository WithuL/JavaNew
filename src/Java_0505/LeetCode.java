package Java_0505;

import Java_0425.TreeNode;

public class LeetCode {
    //二叉树的最近公共祖先
    class Solution {

        private TreeNode lca = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            findNode(root, p, q);
            return lca;
        }

        private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            int left = findNode(root.left, p, q) ? 1 : 0;
            int right = findNode(root.right, p, q) ? 1 : 0;
            int mid = (root == p || root == q) ? 1 : 0;
            if (left + right + mid == 2) {
                lca = root;
            }
            return left + right + mid > 0;
        }

    }
}
