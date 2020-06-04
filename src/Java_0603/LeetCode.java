package Java_0603;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String ip = sc.nextLine();
//            StringBuilder res = new StringBuilder();
//            for(int i = 0; i < ip.length(); i++) {
//                if(ip.charAt(i) >= '0' && ip.charAt(i) <= '9') {
//                    res.append((ip.charAt(i)));
//                }
//            }
//            System.out.println(res.toString());
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String ip = sc.nextLine();
//            int start = 0, end = 0, maxStart = 0, maxEnd = 0;
//            for(int i = 0; i < ip.length(); i++) {
//                if(ip.charAt(i) >= '0' && ip.charAt(i) <= '9') {
//                    end = i;
//                    if(i > 0 && (ip.charAt(i-1) < '0' || ip.charAt(i-1) >'9')){
//                        start = i;
//                    }
//                    if((end - start) > (maxStart - maxEnd)){
//                        maxStart = start;
//                        maxEnd = end;
//                    }
//                }
//            }
//            System.out.println(ip.substring(maxStart,maxEnd+1));
//        }
//    }

//    public boolean chkParenthesis(String A, int n) {
//        if (A == null || n == 0) {
//            return false;
//        }
//        int flag = 0;
//        for (int i = 0; i < A.length(); i++) {
//            if (A.charAt(i) == '(') {
//                flag++;
//            } else if (A.charAt(i) == ')') {
//                flag--;
//            } else {
//                return false;
//            }
//            if (flag < 0) {
//                return false;
//            }
//        }
//        if (flag == 0) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void help(StringBuilder max, StringBuilder cur) {
//        max.delete(0, max.length());
//        for (int i = 0; i < cur.length(); i++) {
//            max.append(cur.charAt(i));
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String in = sc.nextLine();
//            char[] tmp = in.toCharArray();
//            StringBuilder cur = new StringBuilder();
//            StringBuilder max = new StringBuilder();
//            for (char c : tmp) {
//                if (c >= '0' && c <= '9') {
//                    cur.append(c);
//                } else {
//                    if (max.length() < cur.length()) {
//                        help(max, cur);
//                    }
//                    cur.delete(0, cur.length());
//                }
//            }
//            if (max.length() < cur.length()) {
//                help(max, cur);
//            }
//            System.out.println(max);
//        }
//    }

    public static boolean chkParenthesis(String A,int n ) {
        // write code here
        char[] tmp = A.toCharArray();
        int left = 0;
        for(char c : tmp){
            if(c == '('){
                left++;
            }else if( c == ')') {
                if( left > 0) {
                    left--;
                }else {
                    return false;
                }
            }else{
                return false;
            }
        }
        return left == 0;
    }

    public static void main(String[] args) {
        System.out.println(chkParenthesis("()()()()",8));
    }

}