package Java_0728;


import java.util.Scanner;

public class ErCha {
    static int i;
    public static void main(String[ ]args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            i = 0;
            Node node = build(str);
            inOrder(node);
            System.out.print("");
        }
    }

    public static Node build(String str) {
        Node node = null;
        if(str.charAt(i) != '#') {
            node = new Node(str.charAt(i));
            i++;
            node.left = build(str);
            node.right = build(str);
        }else {
            i++;
        }
        return node;
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    static class Node {
        char val;
        Node left;
        Node right;
        public Node(char val){
            this.val = val;
        }
    }
}
