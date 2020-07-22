package Java_0722;
import java.util.*;
public class PinPong {
    // write your code here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for(int i = 0; i < str1.length(); i++) {
                char tmp = str1.charAt(i);
                map1.put(tmp, map1.getOrDefault(tmp,0) + 1);
            }
            for(int i = 0; i < str2.length(); i++) {
                char tmp = str2.charAt(i);
                map2.put(tmp, map2.getOrDefault(tmp,0) + 1);
            }
            int flag = 0;
            for(int i = 0; i < str2.length(); i++) {
                char tmp = str2.charAt(i);
                if(!map1.containsKey(tmp)){
                    flag = 1;
                    break;
                }
                if(map1.get(tmp) < map2.get(tmp)) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) {
                System.out.println("No");

            }else{
                System.out.println("Yes");
            }
        }
    }
}
