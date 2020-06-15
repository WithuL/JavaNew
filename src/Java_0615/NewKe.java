package Java_0615;

import java.util.Scanner;
public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        for(int i = 0; i < (n+1) / 2; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == (n+1) / 2 - 1 || j == 0 || j == n-1) {
                    System.out.print(a);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}