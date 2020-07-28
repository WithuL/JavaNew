package Java_0728;

public class MyQueue {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    private Node head = null;
    private Node tail = null;
    private int size  = 0;

    public void offer(int val) {
        Node node = new Node(val);
        if(tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public int poll() {
        if(size == 0) {
            throw new RuntimeException("队列为空!");
        }
        Node oldHead=  head;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return oldHead.val;
    }

    public int peek() {
        if(size == 0) {
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }

    public int size() {
        return  size;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
}
