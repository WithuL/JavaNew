package Java_0630.MyQueue;


class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    Node(int val) {
        this.val = val;
    }
}

public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    public void offer(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public int poll() {
        if(size == 0) {
            throw new RuntimeException("队列长度为空");
        }
        Node oldHead = head;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return oldHead.val;
    }

    public int peek() {
        if(size == 0) {
            throw new RuntimeException("队列长度为空");
        }
        return head.val;
    }

    public boolean empty() {
        if(size == 0 ) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }


}
