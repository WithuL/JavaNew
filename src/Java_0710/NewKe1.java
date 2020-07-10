package Java_0710;

import java.util.*;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if (tmp >= 'A' && tmp <= 'Z') {
                    map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                }
            }
            char[] ch = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            for(char c : ch) {
                System.out.println(c+":"+map.getOrDefault(c,0));
            }
        }
    }
}
