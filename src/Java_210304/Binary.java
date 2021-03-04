package Java_210304;

class Node{
    int val;
    Node left;
    Node right;
    public Node(int a) {
        val = a;
    }
}
public class Binary {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        Binary binary = new Binary();
        System.out.println(binary.getSize(node1));


    }


    void preorderTravel(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preorderTravel(root.left);
        preorderTravel(root.right);
    }

    void inorderTravel(Node root){
        if(root == null) {

            return;
        }
        inorderTravel(root.left);
        System.out.println(root.val);
        inorderTravel(root.right);
    }

    void postorderTravel(Node root) {
        if(root == null) {
            return ;
        }
        postorderTravel(root.left);
        postorderTravel(root.right);
        System.out.println(root.val);
    }

    int getSize(Node root) {
        if(root == null) {
            return 0;
        }
        return 1+ getSize(root.left) + getSize(root.right);
    }

}
