package Java_0506;

import Java_0501.TreeNode;

import java.util.ArrayList;

public class Test {
    //C
    class Solution5 {
        ArrayList<Integer> ret = new ArrayList<>();
        public int kthLargest(TreeNode root, int k) {
            if(root == null) {
                return 0;
            }
            inorder(root);
            return ret.get(ret.size()- k);
        }
        private void inorder(TreeNode root) {
            if(root == null) {
                return;
            }
            inorder(root.left);
            ret.add(root.val);
            inorder(root.right);
        }
    }

}
