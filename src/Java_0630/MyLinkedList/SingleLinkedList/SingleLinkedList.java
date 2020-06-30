package Java_0630.MyLinkedList.SingleLinkedList;


class Node {
    public int val;
    public Node next;
    public Node (int val) {
        this.val = val;
    }
}

public class SingleLinkedList {
    Node head;
    public SingleLinkedList() {
        this.head = null;
    }
    public void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    public void addLast(int val) {
        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        Node node = new Node(val);
        cur.next = node;
    }

    public boolean addIndex(int index, int val) {
        if(index == 0) {
            addFirst(val);
            return true;
        }
        if(index == size()) {
            addLast(val);
            return true;
        }
        if(index < 0 || index > size()) {
            return false;
        }
        Node cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        return true;
    }
    public boolean contains (int val) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean remove(int val) {
        Node cur = this.head;
        Node pre = null;
        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
                return true;
            }
            pre = cur;
            cur = cur.next;
        }
        return false;
    }


    public void removeAllKey (int val) {
        Node cur = this.head;
        Node prev = cur;
        if(head.val == val) {
            head = head.next;
        }
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
                continue;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    public void clear() {
        this.head = null;
    }


    public int size() {
        Node cur = head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}
