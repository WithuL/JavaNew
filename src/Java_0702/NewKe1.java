package Java_0702;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int c = n*n;
            String s = String.valueOf(c);
            String sb = s.substring(1);
            if(sb.equals(n+"") || n == 1){
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
}
