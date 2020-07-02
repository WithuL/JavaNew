package Java_0702;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            isRight(str);
        }
    }

    private static void isRight(String str) {
        if(str.length() <= 8) {
            System.out.println("NG");
            return;
        }

        int a = 0,b = 0,c = 0,d = 0;
        for(int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp <= 'Z' && tmp >= 'A') {
                a = 1;
            }else if (tmp <= 'z' && tmp >= 'a' ) {
                b = 1;
            }else if( tmp <= '9' && tmp >= '0') {
                c = 1;
            }else {
                d = 1;
            }
        }
        if((a + b + c + d) < 3) {
            System.out.println("NG");
            return;
        }

        for(int i = 0; i < str.length() -3; i++) {
            if(str.substring(i+1).contains(str.substring(i, i+3))) {
                System.out.println("NG");
                return;
            }
        }

        System.out.println("OK");
    }
}
