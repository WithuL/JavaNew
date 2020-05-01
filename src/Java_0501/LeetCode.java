package Java_0501;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class LeetCode {


    //包含min函数的栈
    class MinStack {
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            A.push(x);
            if(B.empty()){
                B.push(x);
                return;
            }
            if(x < B.peek()) {
                B.push(x);
            }else{
                B.push(B.peek());
            }
        }

        public void pop() {
            A.pop();
            B.pop();
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }


    //二叉树搜索树的后序遍历
    class Solution1 {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder,0,postorder.length-1);
        }
        public boolean recur(int[] postorder, int left, int right){
            if(left >= right) {
                return true;
            }
            int tmp = left;
            while(postorder[tmp] < postorder[right]) {
                tmp++;
            }
            int m = tmp;
            while(postorder[tmp] > postorder[right]) {
                tmp++;
            }
            return tmp == right && recur(postorder,left, m-1) && recur(postorder,m , right-1);
        }
    }

    //二叉树中和为某一值的路径
    class Solution {
        List<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            helper(root,sum);
            return ret;
        }
        public void helper(TreeNode root, int sum) {
            if(root == null) {
                return;
            }
            path.add(root.val);
            sum = sum - root.val;
            if(sum == 0 && root.left == null && root.right == null) {
                ret.add(new LinkedList(path));
            }
            helper(root.left, sum);
            helper(root.right, sum);
            path.removeLast();
        }
    }


    //二叉搜索树与双向链表
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        class Solution {
            List<Node> node = new ArrayList<>();
            public Node treeToDoublyList(Node root) {
                if(root == null) {
                    return null;
                }
                inorder(root);
                Node pre = null;
                Node last = null;
                for(int i = 0; i < node.size(); i++) {
                    if(i == node.size() - 1) {
                        last = null;
                    }else{
                        last = node.get(i+1);
                    }
                    node.get(i).right = last;
                    node.get(i).left = pre;
                    pre = node.get(i);
                }
                node.get(0).left = node.get(node.size()-1);
                node.get(node.size()-1).right = node.get(0);
                return node.get(0);
            }
            public void inorder(Node root){
                if(root == null) {
                    return;
                }
                inorder(root.left);
                node.add(root);
                inorder(root.right);
            }
        }
}
