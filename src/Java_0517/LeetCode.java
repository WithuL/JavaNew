package Java_0517;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {
//    电话号码的字母组合
    class Solution1 {
        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0) {
                return new ArrayList<String>();
            }
            //将数字对应的字符串利用下标的形式一一对应起来
            String[] string = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            //创建最终的返回线性表
            List<String> res = new ArrayList<>();
            //先在返回的表中添加一个空字符串，让res的长度不为0
            res.add("");
            //然后开始根据传入数字的个数进行排列组合
            for(int i = 0; i < digits.length(); i++) {
                //先取到当前数字对应的字符串
                String str = string[digits.charAt(i)-'0'];
                //记录此时返回数组有多少个元素，返回数组其实也相当于一个队列
                int size = res.size();
                //然后根据返回数组大小
                for(int j = 0; j < size; j++) {
                    String tmp = res.remove(0);
                    for(int k = 0; k < str.length(); k++) {
                        res.add(tmp + str.charAt(k));
                    }
                }
            }
            return res  ;
        }
    }
//括号生成
    class Solution2 {
        public List<String> generateParenthesis(int n) {
            if(n == 0) {
                return new ArrayList<String>();
            }
            List<String> res = new ArrayList<>();
            dfs("",n,n,res);
            return res;
        }
        private void dfs(String cur, int left, int right,List res){
            //如果左括号和有括号的可用个数都等于0，那么就可以往res中添加当前字符串
            if(left == 0 && right == 0) {
                res.add(cur);
                return;
            }
            //如果左括号可用个数大于右括号可用个数那么就说明出问题了，不符合规范，就直接结束
            if(left > right) {
                return;
            }
            //如果左括号可用个数大于0，那么就继续添加(
            if(left > 0){
                dfs(cur + "(",left - 1,right , res);
            }
            //如果右括号可用个数大于0，那么就继续添加)
            if(right > 0) {
                dfs(cur + ")",left,right - 1,res);
            }
        }

    }
//  合并k个排序链表
    class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0) {
                return null;
            }
            ListNode res = null;
            for(ListNode cur : lists) {
                res = merge2Lists(res,cur);
            }
            return res;
        }
        private ListNode merge2Lists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge2Lists(l1.next, l2);
                return l1;
            }
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }

    //解法二
    class Solution4 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0) {
                return null;
            }
            return merge(lists,0,lists.length-1);
        }
        public ListNode merge(ListNode[] lists, int left, int right) {
            if(right == left) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;
            ListNode leftNode = merge(lists, left, mid);
            ListNode rightNode = merge(lists, mid + 1 , right);
            return mergeHelper(leftNode,rightNode);
        }
        public ListNode mergeHelper(ListNode left, ListNode right) {
            if(left == null) {
                return right;
            }
            if(right == null) {
                return left;
            }
            if(left.val < right.val) {
                left.next = mergeHelper(left.next,right);
                return left;
            }
            right.next = mergeHelper(left,right.next);
            return right;
        }
    }
}
