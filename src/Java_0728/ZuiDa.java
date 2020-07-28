package Java_0728;

import Java_0501.TreeNode;

public class ZuiDa {
    public static void main(String[] args) {
        class Solution {
            public int maxDepth(TreeNode root) {
                if(root == null) {
                    return 0;
                }
                return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            }
        }
    }
}
