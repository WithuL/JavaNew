package Java_0708;

import java.util.Scanner;

public class XiaoYi {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] b = new int[n] ;
            for(int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                if(b[i] <= a) {
                    a += b[i];
                }else {
                    a += help(a,b[i]);
                }
            }
            System.out.println(a);
        }
    }
    public static int help(int a, int b) {
        int x = a;
        int y = b;
        int z = x % y;
        while(z != 0) {
            z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
}
