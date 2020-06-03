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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String ip = sc.nextLine();
            int start = 0, end = 0, maxStart = 0, maxEnd = 0;
            for(int i = 0; i < ip.length(); i++) {
                if(ip.charAt(i) >= '0' && ip.charAt(i) <= '9') {
                    end = i;
                    if(i > 0 && (ip.charAt(i-1) < '0' || ip.charAt(i-1) >'9')){
                        start = i;
                    }
                    if((end - start) > (maxStart - maxEnd)){
                        maxStart = start;
                        maxEnd = end;
                    }
                }
            }
            System.out.println(ip.substring(maxStart,maxEnd+1));
        }
    }

    public boolean chkParenthesis(String A, int n) {
        if(A == null || n == 0){
            return false;
        }
        int flag = 0;
        for(int i = 0 ; i < A.length() ; i++){
            if(A.charAt(i) == '('){
                flag++;
            }else if(A.charAt(i) == ')'){
                flag--;
            }else{
                return false;
            }
            if(flag < 0){
                return false;
            }
        }
        if(flag == 0){
            return true;
        }
        return false;
    }
}

