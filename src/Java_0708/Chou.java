package Java_0708;

import java.util.Scanner;

public class Chou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            double b = digui(n);
            double a = cuo(n);
            double res =  a / b;
            System.out.printf("%.2f",res*100);
            System.out.println("%");
        }
    }

    private static int cuo(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return (n-1) * (cuo(n-1) + cuo(n-2));
    }

    private static int digui(int n) {
        if(n == 1) {
            return 1;
        }
        return n * digui(n-1);
    }
}
