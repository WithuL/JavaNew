package Java_0624;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if(n < 3) {
                System.out.println(1);
                continue;
            }
            int count = 1;
            int adult = 1;
            for(int i = 3; i <= n; i++) {
                if(i >= 5) {
                    adult++;
                }
                count += adult;
                System.out.println("月份:"+i+",成年兔:"+adult+",兔子总数:"+count);
            }
            System.out.println(count);
        }
    }
}
