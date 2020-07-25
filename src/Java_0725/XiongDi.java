package Java_0725;
import java.util.*;
public class XiongDi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            int count = 0;
            for(int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            String target = sc.next();
            char[] keyChar = target.toCharArray();
            Arrays.sort(keyChar);
            int k = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int c = check(target, arr[i], keyChar);
                count += c;
                if(c == 1) {
                    list.add(arr[i]);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            if(k <= count) {
                System.out.println(list.get(k-1));
            }
        }
    }
    private static int check(String target, String word, char[] keyChar) {
        if(target.equals(word) || target.length() != word.length()) {
            return 0;
        }
        char[] ws = word.toCharArray();
        Arrays.sort(ws);
        return Arrays.equals(ws, keyChar) ? 1 : 0;
    }
}
