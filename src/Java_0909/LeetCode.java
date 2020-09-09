package Java_0909;

import Java_0501.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    static List<List<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> tmp = new ArrayList<>();
    public static void pathSum(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        tmp.add(root.val);
        if(sum - root.val == 0) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        tmp.remove(tmp.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left  = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        pathSum(root,22);
        System.out.println(list);
    }

}
