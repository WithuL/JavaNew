package Java_0525;

import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode {
    //排序链表
    class Solution2 {
        private ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }
	
	//数组中的第K个最大元素
	class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }

    //最大正方形
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix.length == 0) {
                return 0;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            int[][]dp = new int[row+1][col+1];
            int max = 0;
            for(int i = 0; i < row; i++) {
                for( int j = 0; j < col; j++) {
                    if(matrix[i][j] == '1'){
                        dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j])+ 1;
                        max = Math.max(max,dp[i+1][j+1]);
                    }
                }
            }
            return max*max;
        }
    }

    //反转二叉树
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution4 {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
            return root;
        }
    }
}
