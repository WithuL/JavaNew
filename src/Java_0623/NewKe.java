package Java_0623;

import java.util.*;

public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        while(groups-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] res = new int[n*2];
            for(int i = 0; i < n*2; i++) {
                int tmp = i+1;
                for(int j = 0; j < k; j++) {
                    if(tmp <= n) {
                        tmp = 2*tmp - 1;
                    }else {
                        tmp = 2 * (tmp -n);
                    }
                }
                res[tmp-1] = sc.nextInt();
            }
            for(int i = 0; i < 2*n - 1; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println(res[2*n-1]);
        }
    }
}
