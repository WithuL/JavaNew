package Java_0612;

import java.util.Stack;

public class Queue {
    class MyQueue {
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(B.size() > 0) {
                A.push(B.pop());
            }
            A.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(empty()) {
                return 0;
            }
            while(A.size() > 0) {
                B.push(A.pop());
            }
            return B.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(empty()) {
                return 0;
            }
            while(A.size() > 0) {
                B.push(A.pop());
            }
            return B.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(A.size() == 0 && B.size() == 0) {
                return true;
            }
            return false;
        }
    }
}
