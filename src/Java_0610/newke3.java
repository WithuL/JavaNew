package Java_0610;

import java.util.Scanner;

public class newke3 {
    //末尾0的个数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            long res = 1;
            for(int i = 1; i <= n; i++) {
                res *= i;
            }
            int count = 0;
            while(res != 0) {
                if(res % 10 == 0) {
                    count++;
                }
                res /= 10;
            }
            System.out.println(count);
        }
    }
}
