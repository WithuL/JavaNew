package Java_0515;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetCode {
    //复杂链表的复制

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node,Node> map = new HashMap<>();
            for(Node cur = head; cur != null; cur = cur.next) {
                map.put(cur,new Node(cur.val));
            }
            for(Node cur = head; cur != null; cur = cur.next) {
                Node tmp = map.get(cur);
                tmp.next = map.get(cur.next);
                tmp.random = map.get(cur.random);
            }
            return map.get(head);
        }
    }

    //排成最小的数字

}
