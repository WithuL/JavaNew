package Java_0617;

import java.util.*;

public class NewKe4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < str.length(); i++) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) + 1);
            }
            List<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list, new Comparator<Character>(){
                @Override
                public int compare(Character o1, Character o2){
                    return o1 - o2;
                }
            });
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i)+":"+map.get(list.get(i)));
            }
        }
    }
}
