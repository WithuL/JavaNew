package Java_0708;

import java.util.Scanner;

public class ShuZi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = a * a;
            System.out.print(help(a)+" ");
            System.out.println(help(b));
        }
    }

    private static int help(int a) {
        int res = 0;
        while( a != 0) {
            res += a%10;
            a /= 10;
        }
        return res;
    }
}
