package Java_0915;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class XiaoMi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            Set<Character> set = new LinkedHashSet<>();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                set.add(c);
            }
            for(char x  : set) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
