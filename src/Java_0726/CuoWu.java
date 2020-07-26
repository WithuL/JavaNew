package Java_0726;
import java.util.*;
public class CuoWu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Map<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNextLine()) {
            String str = sc.next();
            String[] strs = str.split("\\\\");
            String path = strs[strs.length - 1];
            if(path.length() > 16) {
                path = path.substring(path.length() - 16);
            }
            path += " " + sc.next();
            map.put(path, map.getOrDefault(path, 0) + 1) ;
        }
        int count = 0;
        for(String s  : map.keySet()) {
            count++;
            if(count > map.size() - 8) {
                System.out.println(s + " " + map.get(s));
            }
        }
    }
}
