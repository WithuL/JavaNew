package Java_0616;

import java.util.Arrays;
import java.util.Scanner;

public class NewKe3 {
    static int n ;
    static int[] weight;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            n = sc.nextInt();
            weight = new int[n];
            for(int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }
            helper(40,n-1);
            System.out.println(count);
        }
    }
    private static void helper(int i, int j) {
        if(i == 0) {
            ++count;
            return;
        }
        if(j < 0 || (j > 0 && i < 0)) {
            return;
        }
        helper(i - weight[j], j-1);
        helper(i, j-1);
    }
}
