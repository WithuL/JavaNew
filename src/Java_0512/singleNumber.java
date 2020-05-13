package Java_0512;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//只出现一次的数字
public class singleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums) {
            Integer count = map.get(x);
            if(count == null) {
                map.put(x,1);
            }else{
                map.put(x,count + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    class Solution1 {
//        复制带随机指针的链表
        public Node copyRandomList(Node head) {
            Map<Node,Node> map = new HashMap<>();
            for(Node cur = head; cur != null; cur = cur.next) {
                map.put(cur,new Node(cur.val));
            }
            for(Node cur = head; cur != null; cur = cur.next) {
                Node node = map.get(cur);
                node.next = map.get(cur.next);
                node.random = map.get(cur.random);
            }
            return map.get(head);
        }
    }
//宝石与石头
    class Solution2 {
        public int numJewelsInStones(String J, String S) {
            int count = 0;
            for(int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if(J.contains(String.valueOf(c))) {
                    count++;
                }
            }
            return count;
        }
    }
//第二种解法
    class Solution {
        public int numJewelsInStones(String J, String S) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < J.length(); i++) {
                set.add(J.charAt(i));
            }
            int count = 0;
            for(int i = 0; i < S.length(); i++) {
                if(set.contains(S.charAt(i)) ) {
                    count++;
                }
            }
            return count;
        }
    }
}





