package Java_0705;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(help(n));
        }
    }

    private static int help(int n) {
        if(n <= 2) {
            return 1;
        }
        return help(n-1) + help(n-2);
    }
}
