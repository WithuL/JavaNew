package Java_0611;

import java.util.Scanner;
//斐波那契数列
public class Newke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int target = sc.nextInt();
            if(target <= 3) {
                System.out.println("0");
                return;
            }
            int min = 0;
            int max = 1;
            int cur = 0;
            for(int i = 2; i <= 1000_000; i++) {
                cur = max + min;
                min = max;
                max = cur;
                if(cur >= target) {
                    break;
                }
            }
            int count = Math.min(max - target, target - min);
            System.out.println(count);
        }
    }
}
