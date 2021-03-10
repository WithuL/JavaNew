package J210304;

class Node {
    int val;
    Node next;
    public Node (int val) {
        this.val = val;
    }
}

public class MyQueue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void offer(int x) {
        Node node = new Node(x);
        size++;
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
        return;
    }

    public int pop() {
        if(size == 0) {
            throw new RuntimeException("队列为空！");
        }
        size--;
        Node node = head;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return node.val;
    }
}
