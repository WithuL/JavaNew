package Java_0811;
import Java_0501.TreeNode;

import java.util.*;
public class Test3 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int max = left > right ? left : right;
            return max + 1;
        }
    }
}
