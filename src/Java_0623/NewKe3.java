package Java_0623;

import java.util.HashMap;
import java.util.Scanner;

public class NewKe3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int N = sc.nextInt();
            if(N == 0) {
                return ;
            }
            int[] res = new int[N];
            for(int i = 0; i < N; i++) {
                res[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            int count = 0;
            for(int i = 0; i < N; i++) {
                if(target == res[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
