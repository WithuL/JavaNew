package Java_0916;

import java.util.*;

public class ZI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            if(str1.length() < str2.length()) {
                String tmp = str1;
                str1 = str2;
                str2 = str1;
            }
            String strM = "";
            int max = 0;
            Map<StringBuilder, Integer> map = new HashMap<>();
            for(int i = 0; i < str1.length(); i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = i; j < str1.length(); j++) {
                    char c = str1.charAt(j);
                    for(int k = 0; k < str2.length(); k++) {
                        char d = str2.charAt(k);
                        if(d == c) {
                            sb.append(d);
                        }
                    }
                }
                if(sb.length() > strM.length()) {
                    strM = sb.toString();
                    max = strM.length();
                }
            }
            System.out.println(max);
        }
    }
}
