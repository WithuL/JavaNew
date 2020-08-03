//package Java_0426;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class LeetCode {
//}
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//class Solution {
//
//    //根据一棵树的前序遍历与中序遍历构造二叉树
//    private int index = 0;
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        index = 0;
//        return buildTreeHelper(preorder,inorder,0,preorder.length);
//    }
//    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int inorderLeft,int inorderRight){
//        if(inorderLeft >= inorderRight) {
//            return null;
//        }
//        if(index >= preorder.length) {
//            return null;
//        }
//        TreeNode cur = new TreeNode(preorder[index]);
//        index++;
//        int pos = find(inorder,inorderLeft,inorderRight,cur.val);
//        cur.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
//        cur.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
//        return cur;
//    }
//    private int find(int[] inorder,int inorderLeft,int inorderRight,int val) {
//        for(int i = inorderLeft ; i < inorderRight; i++) {
//            if(inorder[i] == val) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//    // 根据二叉树创建字符串
//        class Solution1 {
//        StringBuilder str = new StringBuilder();
//        public String tree2str(TreeNode t) {
//            if(t == null) {
//                return "";
//            }
//            help(t);
//            str.deleteCharAt(0);
//            str.deleteCharAt(str.length() - 1);
//            return str.toString();
//        }
//        private void help(TreeNode t) {
//            if(t == null) {
//                return;
//            }
//            str.append("(");
//            str.append(t.val);
//            help(t.left);
//            if(t.left == null && t.right != null) {
//                str.append("()");
//            }
//            help(t.right);
//            str.append(")");
//
//        }
//    }
//
//
//    //二叉树的前序遍历
//    class Solution2{
//        public List<Integer> preorderTraversal(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//            if(root == null) {
//                return list;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);
//            while(!stack.empty()) {
//                TreeNode cur = stack.pop();
//                if(cur.right != null) {
//                    stack.push(cur.right);
//                }
//                if(cur.left != null) {
//                    stack.push(cur.left);
//                }
//                list.add(cur.val);
//            }
//            return list;
//        }
//    }
//
//    //二叉树的中序遍历
//    class Solution3 {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//            if(root == null) {
//                return list;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode cur = root;
//            while(true) {
//                while(cur != null) {
//                    stack.push(cur);
//                    cur = cur.left;
//                }
//                if(stack.empty()) {
//                    break;
//                }
//                TreeNode top = stack.pop();
//                list.add(top.val);
//                cur = top.right;
//            }
//            return list;
//        }
//    }
//
//    //二叉树的后序遍历
//    class Solution4 {
//        public List<Integer> postorderTraversal(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//            if(root == null) {
//                return list;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode cur = root;
//            TreeNode prev = null;
//            while(true){
//                while(cur != null) {
//                    stack.push(cur);
//                    cur = cur.left;
//                }
//                if(stack.empty()) {
//                    break;
//                }
//                TreeNode top = stack.peek();
//                if(top.right == null || prev == top.right) {
//                    list.add(top.val);
//                    stack.pop();
//                    prev = top;
//                }else {
//                    cur = top.right;
//                }
//            }
//            return list;
//        }
//    }
//}
//
//
