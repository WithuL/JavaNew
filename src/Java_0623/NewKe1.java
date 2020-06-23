package Java_0623;

import java.util.HashMap;
import java.util.Map;

public class NewKe1 {

    //微信红包
    public static int getValue(int[] gifts, int n) {
        // write code here
        int res = gifts[0];
        int count = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : gifts) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > (n / 2.0)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] gifts = new int[5];
        gifts[0] = 1;
        gifts[1] = 2;
        gifts[2] = 3;
        gifts[3] = 2;
        gifts[4] = 2;
        System.out.println(getValue(gifts,5));
    }


    /*
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }*/
//    public class Partition {
//        public ListNode partition(ListNode pHead, int x) {
//            // write code here
//            ListNode cur = pHead;
//            ListNode left = new ListNode(0);
//            ListNode leftP = left;
//            ListNode right = new ListNode(0);
//            ListNode rightP = right;
//            while(cur != null) {
//                if(cur.val < x) {
//                    leftP.next = cur;
//                    leftP = leftP.next;
//                }else{
//                    rightP.next = cur;
//                    rightP = rightP.next;
//                }
//                cur = cur.next;
//            }
//            leftP.next = right.next;
//            rightP.next = null;
//            return left.next;
//        }
//    }
}
