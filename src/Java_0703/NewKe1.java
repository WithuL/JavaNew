package Java_0703;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            double n = sc.nextInt();
            double a = count(n);
            double b = factorial(n);
            double res = (a / b) * 100;
            System.out.printf("%.2f",res );
            System.out.println("%");
        }
    }

    private static double count(double n) {
        if(n == 2) {
            return 1;
        }
        if(n == 1) {
            return 0;
        }
        return (n-1)*(count(n-1)+count(n-2));
    }

    private static double factorial(double n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
