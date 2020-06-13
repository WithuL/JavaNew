package Java_0613;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int target = sc.nextInt();
            int pre = 0;
            int cur = 1;
            for(int i = 2; i <= 1000_1000; i++) {
                int tmp = pre + cur;
                pre = cur;
                cur = tmp;
                if(cur >= target){
                    break;
                }
            }
            System.out.println(Math.min(target - pre, cur - target));;
        }
    }
}
