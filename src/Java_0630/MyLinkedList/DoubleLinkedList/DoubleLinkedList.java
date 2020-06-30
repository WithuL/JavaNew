package Java_0630.MyLinkedList.DoubleLinkedList;

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    Node pHead;
    Node head;
    Node last;

    public DoubleLinkedList() {
        pHead = new Node(0);
        pHead.next = head;
    }

    public void addFirtst(int val) {
        Node node = new Node(val);
        if(head == null) {
            this.last = node;
            this.head = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addLast (int val) {
        Node node = new Node(val);
        if( this.head == null) {
            addFirtst(val);
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    public void addIndex(int index, int val) {
        if(index == 0) {
            addFirtst(val);
        } else if(index == size()) {
            addLast(val);
        } else if(index < 0 || index > size()) {
            return;
        }
        Node cur = this.head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node node = new Node(val);
        node.next = cur.next;
        node.prev = cur;
        cur.next.prev = node;
        cur.next = node;
    }



    public int size() {
        Node cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
