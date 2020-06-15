package Java_0605;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            if(!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }

        public int pop() {
            if(stack1.empty() && stack2.empty()) {
                return -1;
            }
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

//    public class NewKe{
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            while(sc.hasNextInt()) {
//                int count = 0;
//                int len = sc.nextInt();
//                int[] t = new int[len];
//                for(int i = 0 ; i < len; i++) {
//                    t[i] = sc.nextInt();
//                }
//                helper(40,0,t,count);
//                System.out.println(count);
//            }
//        }
//        public static void helper(int w, int i,int[] t,int count){
//            if(w == 0) {
//                count++;
//                return;
//            }
//            if(w < 0 || i >= t.length) {
//                return ;
//            }
//            helper(w-t[i], i, t, count);
//            helper(w, i+1, t, count);
//        }
//    }
}
