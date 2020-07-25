package Java_0725;
import java.util.*;
public class Juz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Stack<String> strings = new Stack<>();
        while(sc.hasNext()) {
            strings.push(sc.next());
        }
        while(strings.size() > 1) {
            System.out.print(strings.pop() + " ");
        }
        System.out.println(strings.pop());
    }
}
