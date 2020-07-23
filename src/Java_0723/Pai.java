package Java_0723;
import java.util.*;

public class Pai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> res = new LinkedHashMap<>();
        while(sc.hasNext()) {
            String lujing = sc.next();
            String path = null;
            int index = lujing.lastIndexOf('\\');
            path = index == -1 ? lujing : lujing.substring(index+1, lujing.length()+1);
            String line = sc.next();
            String fin = path + " " + line;
            res.put(fin, res.getOrDefault(fin, 0) + 1);
        }
        int count = 1;
        for(Map.Entry<String, Integer> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            count++;
            if(count == 8) {
                return;
            }
        }
    }
}
