package Java_0915;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class XiaoMi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            if(str.length() == 0) {
                System.out.println("true");
            }
            stack.push(str.charAt(0));
            for(int i = 1; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if((!stack.empty()) && stack.peek() == '(' && tmp == ')') {
                    stack.pop();
                } else if((!stack.empty()) && stack.peek() == '[' && tmp == ']') {
                    stack.pop();
                } else if((!stack.empty()) && stack.peek() == '{' && tmp == '}') {
                    stack.pop();
                } else {
                    stack.push(tmp);
                }
            }
            if(stack.empty()) {
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }


}
