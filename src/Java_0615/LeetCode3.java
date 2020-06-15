//package Java_0615;
//
//public class LeetCode3 {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode(int x) { val = x; }
//     * }
//     */
//    class Solution {
//        int res = 0;
//        public int diameterOfBinaryTree(TreeNode root) {
//            dfs(root);
//            return res;
//        }
//        public int dfs(TreeNode root) {
//            if(root == null) {
//                return 0;
//            }
//            int left = dfs(root.left);
//            int right = dfs(root.right);
//            res = Math.max(res,left+right);
//            return Math.max(left, right) + 1;
//        }
//    }
//}
