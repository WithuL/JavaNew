package Java_0703;

import java.util.Arrays;

public class Substr {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(s.contains(p[i])) {
                res[i] = true;
            }else {
                res[i] = false;
            }
        }
        return res;
    }
}
