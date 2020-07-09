package Java_0709;
import java.util.*;
public class JianDancuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Map<String, Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()) {
            String  path = sc.next();
            int id = path.lastIndexOf('\\');
            String file = id == -1 ? path : path.substring(id+1);
            int line = sc.nextInt();
            String key = file + " " + line;
            map.put(key, map.getOrDefault(key, 0) + 1);
            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

        }
        int m = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(m >= 8) {
                break;
            }
            String[] str = entry.getKey().split(" ");
            String filename = str[0];
            if(str[0].length() > 16) {
                filename = (str[0].substring(str[0].length()-16)+" ");
            }
            String n = str[1];
            int count = entry.getValue();
            System.out.printf("%s %s %d%n",filename,n,count);
            m++;
        }
    }
}
