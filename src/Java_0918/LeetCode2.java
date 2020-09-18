package Java_0918;
import java.util.*;
public class LeetCode2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(' || c == ')' || c == '[' || c == ']' || c =='{' || c == '}') {
                    sb.append(c);
                }
            }
            str = sb.toString();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if( !(stack.empty()) && stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if( !(stack.empty()) && stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else if( !(stack.empty()) && stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            System.out.println(stack.empty());
        }
    }
}
