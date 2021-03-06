package Java_0611;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1 {
//    5. 最长回文子串
    //暴力法
//    public static void main(String[] args) {
//        class Solution {
//            public String longestPalindrome(String s) {
//                int len = s.length();
//                if (len < 2) {
//                    return s;
//                }
//                char[] ch = s.toCharArray();
//                int maxLen = 1;
//                int start = 0;
//                //[i,j]是一个闭区间
//                for (int left = 0; left < len - 1; left++) {
//                    //只看长度大于1的情况
//                    for (int right = left + 1; right < len; right++) {
//                        if (right - left + 1 > maxLen && reverse(ch, left, right)) {
//                            //不加1的话是right和left 之间相隔的元素个数,+1的话就是这之间所有的元素个数
//                            maxLen = right - left + 1;
//                            start = left;
//                        }
//                    }
//                }
//                return s.substring(start, start + maxLen);
//            }
//
//            public boolean reverse(char[] ch, int left, int right) {
//                while (left < right) {
//                    if (ch[left] != ch[right]) {
//                        return false;
//                    }
//                    left++;
//                    right--;
//                }
//                return true;
//            }
//        }
//    }
//    //动态规划法  填表
//    class Solution {
//        public String longestPalindrome(String s) {
//            int len = s.length();
//            if(len < 2) {
//                return s;
//            }
//            int maxLen = 1;
//            int begin = 0;
//            boolean[][] dp = new boolean[len][len];
//            char[] ch = s.toCharArray();
//            for(int j = 1; j < len; j++) {
//                for(int i = 0; i < j; i++) {
//                    if(ch[i] != ch[j]) {
//                        dp[i][j] = false;
//                    }else if(j - i + 1 < 4) {
//                        dp[i][j] = true;
//                    }else {
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                    if(j - i + 1 > maxLen && dp[i][j]) {
//                        maxLen = j - i + 1;
//                        begin = i;
//                    }
//                }
//            }
//            return s.substring(begin, begin + maxLen);
//        }
//    }

    public static int countSubstrings(String s) {
        int len = s.length();
        if(len < 2) {
            return len;
        }
        int count = len;
        char[] ch = s.toCharArray();
        for(int left = 0; left < len - 1; left++) {
            for(int right = left + 1; right < len; right++) {
                if(reverse(ch, left, right)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean reverse(char[] ch, int left, int right) {
        while (left < right) {
            if (ch[left] != ch[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(countSubstrings(str));
    }

//杨辉三角
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res=new ArrayList<List<Integer>>();
            for(int i = 0; i < numRows; i++) {
                List<Integer> tmp = new ArrayList<>();
                for(int j = 0; j <= i; j++) {
                    if(j == 0 || j == i) {
                        tmp.add(1);
                    }else{
                        tmp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                    }
                }
                res.add(tmp);
            }
            return res;
        }
    }
}
