package Java_0630;

import java.util.Scanner;

public class NewKe3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int pf = n*n;
            System.out.print(help(n) + " ");
            System.out.println(help(pf));
        }
    }
    public static int help(int n) {
        int sum = 0;
        while(n != 0) {
            int tmp = n % 10;
            sum += tmp;
            n /= 10;
        }
        return sum;
    }
}
