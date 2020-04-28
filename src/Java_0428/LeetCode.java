package Java_0428;

import java.util.HashMap;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LeetCode {

    //合并二叉树 递归
    class Solution1 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null) {
                return t2;
            }
            if(t2 == null) {
                return t1;
            }
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right,t2.right);
            return t1;
        }
    }
    //非递归

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null) {
                return t2;
            }
            Stack<TreeNode[]> stack = new Stack<>();
            stack.push(new TreeNode[] {t1,t2});
            while(!stack.empty()) {
                TreeNode[] cur = stack.pop();
                if(cur[0] == null || cur[1] == null) {
                    continue;
                }
                cur[0].val += cur[1].val;
                if(cur[0].left == null) {
                    cur[0].left = cur[1].left;
                }else{
                    stack.push(new TreeNode[] {cur[0].left,cur[1].left});
                }
                if(cur[0].right == null) {
                    cur[0].right = cur[1].right;
                }else{
                    stack.push(new TreeNode[] {cur[0].right,cur[1].right});
                }
            }
            return t1;
        }
    }

    //重建二叉树
    //方法一：
    class Solution2 {
        int index;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            index = 0;
            return buildTreeHelper(preorder,inorder,0,preorder.length);
        }
        public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int inorderLeft,int inorderRight) {
            if(inorderLeft >= inorderRight) {
                return null;
            }
            if(index >= preorder.length) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[index]);
            int pos = find( inorder, inorderLeft, inorderRight,preorder[index]);
            index++;
            root.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
            root.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
            return root;
        }
        public int find(int[] inorder,int inorderLeft,int inorderRight,int val ){
            for(int i = inorderLeft; i < inorderRight; i++) {
                if(inorder[i] == val) {
                    return i;
                }
            }
            return -1;
        }

    }
    //方法2
    HashMap<Integer,Integer> pos = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            pos.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,0,inorder.length);
    }
    public TreeNode buildTreeHelper(int[] preorder,int inorderLeft,int inorderRight) {
        if(inorderLeft >= inorderRight) {
            return null;
        }
        if(index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int i = pos.get(preorder[index]);
        index++;
        root.left = buildTreeHelper(preorder,inorderLeft,i);
        root.right = buildTreeHelper(preorder,i+1,inorderRight);
        return root;
    }

    //用两个栈实现队列
    //方法一
    class CQueue {
        Stack<Integer> A = new Stack<Integer>();
        Stack<Integer> B = new Stack<Integer>();
        public CQueue() {

        }

        public void appendTail(int value) {
            while(!B.empty()) {
                A.push(B.pop());
            }
            A.push(value);
        }

        public int deleteHead() {
            if(A.empty() && B.empty()) {
                return -1;
            }
            while(!A.empty()) {
                B.push(A.pop());
            }
            return B.pop();
        }
    }
}
