//package Java_0524;
//
//import javax.swing.tree.TreeNode;
//
//
//
//
//public class LeetCode{
//    class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
//
//    //验证二叉搜索树
//    class Solution1 {
//        long pre = Long.MIN_VALUE;
//        public boolean isValidBST(TreeNode root) {
//            if(root == null) {
//                return true;
//            }
//            if(!isValidBST(root.left)) {
//                return false;
//            }
//            if(root.val <= pre) {
//                return false;
//            }
//            pre = root.val;
//            if(!isValidBST(root.right)) {
//                return false;
//            }
//            return true;
//        }
//    }
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//
////    二叉树展开为链表
//    class Solution2 {
//        public void flatten(TreeNode root) {
//            while(root != null) {
//                if(root.left == null) {
//                    root = root.right;
//                }else {
//                    TreeNode pre = root.left;
//                    while(pre.right != null) {
//                        pre = pre.right;
//                    }
//                    pre.right = root.right;
//                    root.right = root.left;
//                    root.left = null;
//                    root = root.right;
//                }
//            }
//        }
//    }
//
//    //买卖股票的最佳时机
//    class Solution3 {
//        public int maxProfit(int[] prices) {
//            if(prices.length == 0) {
//                return 0;
//            }
//            int max = 0;
//            int buy =  prices[0];
//            int sell = 0;
//            for(int i = 1; i < prices.length; i++) {
//                sell = prices[i];
//                max = Math.max(max,sell - buy);
//                if(buy > sell) {
//                    buy = sell;
//                }
//            }
//            return max;
//        }
//    }
//
//}
