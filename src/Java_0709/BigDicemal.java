package Java_0709;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class BigDicemal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger[] b = new BigInteger[n];
            for(int i = 0; i < n; i++) {
                b[i] = sc.nextBigInteger();
            }
            Arrays.sort(b);
            for(int i = 0; i < n; i++) {
                System.out.println(b[i]);
            }
        }
    }
}
