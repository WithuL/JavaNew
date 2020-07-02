package Java_0701;

import java.util.Scanner;

public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] t = new int[n];
            for(int i = 0; i < n; i++) {
                t[i] = sc.nextInt();
            }
            int a = sc.nextInt();
            for(int i = 0; i < n; i++) {
                if(a == t[i]) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("-1");
        }
    }
}
