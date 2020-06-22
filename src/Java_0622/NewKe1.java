package Java_0622;
import java.util.*;

public class NewKe1 {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
        }
        for(int i = 0; i < n; i++) {
            if(set.contains(p[i])) {
                res[i] = true;
            }
        }
        for(boolean x : res) {
            System.out.println(x);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"a","b","d","d"};
        chkSubStr(strs,4,"abc");

    }
}
