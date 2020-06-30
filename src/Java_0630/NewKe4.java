package Java_0630;
import java.util.*;
public class NewKe4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int n = sc.nextInt();
            Map<String, Integer> map = new LinkedHashMap<>();
            sc.nextLine();
            String str1 = sc.nextLine();
            String[] strs1 = str1.split(" ");
            for(String s : strs1) {
                map.put(s, 0);
            }
            map.put("Invalid", 0);
            int k = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            for(String s : strs) {
                if(map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }else {
                    map.put("Invalid", map.get("Invalid") + 1);
                }
            }
            for(Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
