package Java_04_24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Leet {

}

class Solution {

    //层序遍历并存储元素
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return ret;
        }
        ret.clear();
        levelOrderHelper(root,0);
        return ret;
    }

    private void levelOrderHelper(TreeNode root, int i) {
        if(i == ret.size()) {
            ret.add(new ArrayList<Integer>());
        }
        List<Integer> cur = ret.get(i);
        cur.add(root.val);
        if(root.left != null) {
            levelOrderHelper(root.left,i+1);
        }
        if(root.right != null) {
            levelOrderHelper(root.right,i+1);
        }
    }

    //递增顺序查找树
    //给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        root = addOrder(queue);
        return root;
    }
    Queue<Integer> queue = new LinkedList<>();
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        queue.add(root.val);
        inOrder(root.right);
    }
    private TreeNode addOrder(Queue queue) {
        TreeNode root = new TreeNode((Integer) queue.poll());
        TreeNode cur = root;
        while(!queue.isEmpty()) {
            TreeNode node = new TreeNode((Integer) queue.poll());
            cur.right = node;
            cur = node;
        }
        return root;
    }




}