package Java_0728;

public class BinaryTree {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    //求节点个数
    int getSize1 (Node node){
        if(node == null) {
            return 0 ;
        }
        return 1 + getSize1(node.left) + getSize1(node.right);
    }

    //求叶子节点个数
    int getSize2 (Node node){
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1 ;
        }
        return getSize2(node.left) + getSize2(node.right);
    }

    //求第k层节点个数

}
