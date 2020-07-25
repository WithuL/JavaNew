package Java_0707;

import java.util.*;
public class Buy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String b = sc.next();
            String c = sc.next();
            Map<Character, Integer> bmap = new HashMap<>();
            Map<Character, Integer> cmap = new HashMap<>();
            for(int i = 0; i < b.length(); i++) {
                bmap.put(b.charAt(i), bmap.getOrDefault(b.charAt(i), 0) + 1);
            }
            for(int i = 0; i < c.length(); i++) {
                cmap.put(c.charAt(i), cmap.getOrDefault(c.charAt(i), 0) + 1);
            }
            boolean flag = true;
            int lack = 0;
            for(Map.Entry<Character, Integer> entry : cmap.entrySet()) {
                char k = entry.getKey();
                int v = entry.getValue();
                if(! bmap.containsKey(k)) {
                    flag = false;
                    lack += v;
                }else if(bmap.get(k) < v){
                    flag = false;
                    lack += v - bmap.get(k);
                }
            }
            if(flag) {
                System.out.println("Yes "+(b.length() - c.length()));
            }else{
                System.out.println("No "+lack);
            }

        }
    }
}
