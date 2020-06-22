package Java_0622;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int a = n * (n - 1) +1;
            while(n > 0) {
                if(n != 1) {
                    System.out.print(a + "+");
                }else {
                    System.out.println(a);
                }
                a = a +2;
                n--;
            }
        }
    }
}
