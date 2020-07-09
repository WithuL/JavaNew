package Java_0709;

import java.util.Scanner;

public class JiOu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()) {
            String str = sc.next();
            char[] ch = str.toCharArray();
            for(int i = 0 ; i < ch.length; i++) {
                help(ch[i]);
            }
        }
    }

    private static void help(char ch) {
        int tmp = ch-'\0';
        String res = Integer.toBinaryString(tmp);
        int count = 0;
        while(tmp != 0) {
            if((tmp) % 2 == 1){
                count++;
            }
            tmp >>= 1;
        }
        if(count % 2 ==0) {
            System.out.print("1");
        }else {
            System.out.print("0");
        }
        count = res.length();
        while(count < 7) {
            System.out.print("0");
            count++;
        }
        System.out.println(res);
    }
}
