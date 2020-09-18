package Java_0918;
import java.util.*;
public class LeetCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            if(str.length() > 50) {
                System.out.println(0);
                continue;
            }
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c >= 'a' && c <= 'z') {
                    if(c == 'a') {
                        System.out.print( "Z");
                    }else {
                        c = (char)(c - 1 - 32);
                        System.out.print(c);
                    }
                } else if(c >= 'A' && c <= 'Z') {
                    if(c == 'A') {
                        System.out.print( "z");
                    }else {
                        c = (char)(c - 1 + 32);
                        System.out.print(c);                    }
                } else if(c >= '0' && c <= '9') {
                    if( c == '0') {
                        System.out.print("9");
                    }else {
                        System.out.print( Integer.parseInt(String.valueOf(c))-1);
                    }
                }
            }
            System.out.println();
        }
    }
}

