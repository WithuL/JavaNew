package Java_0630.BinaryTree;

class Node {
    int val;
    Node left;
    Node right;
    public Node (int val) {
        this.val = val;
    }
}
public class BinaryTree {
    Node root;

    public void preOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal (Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal (Node root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }

    //节点个数
    public int getSize (Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    //叶子节点个数
    public int getLeftSize(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeftSize(root.left) + getLeftSize(root.right);
    }

    //求第K层节点个数
    public int getLevelSize(Node root,int k) {
        if(root == null || k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getLevelSize(root.left, k-1) + getLevelSize(root.right, k-1);
    }

    //找到值为val的节点
    public Node findNode(Node root,int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        Node left = findNode(root.left, val);
        Node right = findNode(root.right, val);
        return left == null ? right : left;
    }
}
