package Java_0706;


import java.util.*;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while(sc.hasNext()) {
            String name = sc.next();
            int num = sc.nextInt();
            String[] temp = name.split("\\\\");
            String last = temp[temp.length-1];
            last = last.substring(last.length()-16);
            map.put(last+" "+num, map.getOrDefault(last+" "+num, 0) + 1);
        }
        help(map);
    }

    private static void help(Map<String, Integer> map) {
        int count = 0;
        for(String key : map.keySet()) {
            count++;
            if(count > (map.keySet().size()-8)) {
                System.out.println(key+" "+map.get(key));
            }
        }
    }
}
