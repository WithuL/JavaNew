package Java_04_24;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    String val;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(String val) {
        this.val = val;
    }
}
public class Test {

    //层序遍历
    static void levelOrderTraversal(BinaryTree root) {
        if(root == null) {
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        BinaryTree cur ;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree("A");
        root.left = new BinaryTree("B");
        root.right = new BinaryTree("C");
        root.left.left = new BinaryTree("D");
        root.left.right = new BinaryTree("E");
        root.right.left = new BinaryTree("F");
        levelOrderTraversal(root);
        System.out.println(isCompleteTree(root));
    }

    //判断一棵树是否是一颗完全二叉树
    static boolean isCompleteTree(BinaryTree root) {
        if(root == null) {
            return false;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        BinaryTree cur;
        boolean isFirst = true;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            if(isFirst) {
                if(cur.left != null && cur.right != null) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }else if(cur.left == null && cur.right != null) {
                    return false;
                }else if(cur.left != null && cur.right ==null) {
                    isFirst = false;
                    queue.add(cur.left);
                }else if(cur.left == null && cur.right == null) {
                    isFirst = false;
                }
            }else {
                if(cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
