package Java_0806;

import Java_0501.TreeNode;

public class Test {
    static class Demo {
        Demo demo;
    }
    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
        demo1.demo = demo2;
        demo2.demo = demo1;
        demo1 = null;
        demo2 = null;
    }
//二叉树的最近公共祖先
    static class Solution {
        static TreeNode head = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) {
                return head;
            }
            help(root, p , q);
            return head;
        }
        public boolean help(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) {
                return false;
            }
            int left = help(root.left, p ,q) ? 1 : 0;
            int right = help(root.right, p ,q) ? 1 : 0;
            int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
            if((left + mid + right) == 2) {
                head = root;
            }
            return (left + right + mid ) > 0;
        }
    }
}
