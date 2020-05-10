package Java_0510;

import java.util.HashMap;
import java.util.Map;

public class Set {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"you");
        map.put(3,"good mornning");
        System.out.println(map.get(99));
        for(Integer x : map.keySet()) {
            System.out.println(x);
        }
        for(String x : map.values()) {
            System.out.println(x);
        }

    }
}