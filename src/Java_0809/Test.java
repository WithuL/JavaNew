package Java_0809;

import Java_0501.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Test {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) {
                return res;
            }
            dfs(root, res,0);
            return res;
        }

        public void dfs(TreeNode root, List<List<Integer>> res, int level) {
            if(level == res.size()) {
                List<Integer> tmp = new LinkedList<>();
                res.add(tmp);
            }
            if(level % 2 == 0) {
                res.get(level).add(0,root.val);
            }else {
                res.get(level).add(root.val);
            }
            if(root.left != null) {
                dfs(root.left, res, level+1);
            }
            if(root.right != null) {
                dfs(root.right, res, level+1);
            }
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        int index = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return help(preorder, inorder, 0, preorder.length);
        }

        public TreeNode help(int[] preorder, int[] inorder, int left, int right) {
            if(left >= right) {
                return null;
            }
            if(index >= preorder.length) {
                return null;
            }
            //通过先序遍历构造当前的根节点
            TreeNode cur = new TreeNode(preorder[index++]);
            //找到根节点的左右边界
            int mid = 0;
            for(int i = left; i < right; i++) {
                if(inorder[i] == cur.val) {
                    mid = i;
                }
            }
            //将根节点的左右节点连接起来
            cur.left = help(preorder, inorder, left, mid);
            cur.right = help(preorder, inorder,mid+1, right);
            return cur;
        }
    }

    class Solution2 {
        int index = 0;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            index = inorder.length - 1;
            return help(postorder, inorder , 0 , postorder.length);
        }
        public TreeNode help(int[] postorder, int[] inorder, int left, int right) {
            if(left >= right) {
                return null;
            }
            if(index < 0) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[index--]);
            //查看根节点在中序遍历中的位置
            int mid = -1;
            for(int i = left; i < right; i++) {
                if(inorder[i] == root.val) {
                    mid = i;
                }
            }
            //根据根节点的位置,创建左右子树
            root.right = help(postorder, inorder, mid+1, right);
            root.left = help(postorder, inorder, left, mid);
            return root;
        }
    }
}
