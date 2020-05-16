package Java_0516;

public class MyHashMap {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //设置为素数降低冲突率
    public Node[] array = new Node[101];
    private int size = 0;
    //负载因子：size / array.length;

    //哈希函数
    private int hashFunc(int key) {
        return key % array.length;
    }

    //插入函数
    public void put(int key, int value) {
        //根据key带入到哈希函数中，计算出存放位置
        int index = hashFunc(key);
        //先找到此位置的头结点
        Node head = array[index];
        //先判断key是否存在，如果存在就修改value，不插入新节点
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
        }
        Node node = new Node(key, value);
        node.next = head;
        array[index] = node;
        size++;
    }

    //寻找元素
    public Integer get(int key) {
        //1.根据key查找到value;
        int index = hashFunc(key);
        //2.根据index得到相应位置的链表
        Node head = array[index];
        //在链表中寻找
        for (Node cur = head; cur != cur.next; cur = cur.next) {
            //如果找到了
            if (cur.key == key) {
                return cur.value;
            }
        }
        //如果没找到
        return null;
    }
}