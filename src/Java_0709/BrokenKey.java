package Java_0709;

import java.util.*;

public class BrokenKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next().toUpperCase();
        String second = sc.next().toUpperCase();
        Set<String> set = new LinkedHashSet<>();
        for(int i = 0; i < first.length(); i++) {
            String tmp = String.valueOf(first.charAt(i));
            if((!second.contains(tmp))){
                set.add(tmp);
            }
        }
        for(String s : set) {
            System.out.print(s);
        }
    }
}
