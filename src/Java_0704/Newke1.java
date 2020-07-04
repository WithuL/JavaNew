package Java_0704;
import java.util.*;
public class Newke1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
            String[] strs = new String[n];
            for(int i = 0; i < n; i++) {
                strs[i] = scanner.nextLine();
                map.put(strs[i], strs[i].length());
            }
            ArrayList<String> arr = new ArrayList<>(map.keySet());
            Collections.sort(arr,(String o1,String o2) -> help(o1,o2,map));
            for (String s : arr) {
                System.out.println(s);
            }
        }
    }
    public static int help(String o1, String o2, Map<String,Integer> map) {
        int len1 = map.get(o1);
        int len2 = map.get(o2);
        if(len1 == len2) {
            return o1.compareTo(o2);
        }
        return len1 - len2;
    }
}
