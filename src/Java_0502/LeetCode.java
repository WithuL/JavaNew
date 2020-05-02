package Java_0502;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode {
    //字符串的排列
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    //n整数中1出现的次数
    class Solution {
        public int countDigitOne(int n) {
            return help(n);
        }
        public int help(int n) {
            if(n <= 0) {
                return 0;
            }
            String s = String.valueOf(n);
            int high = s.charAt(0) - '0';
            int pow = (int)Math.pow(10,s.length() - 1);
            int last = n - high * pow;
            if(high == 1) {
                return help(pow - 1) + help(last) + last + 1;
            }else{
                return pow + high * help(pow - 1) + help(last);
            }
        }
    }

}
