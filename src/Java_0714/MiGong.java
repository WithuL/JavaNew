package Java_0714;

import java.util.Scanner;

public class MiGong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int[][] ge = new int[n][m];
            boolean[][] step = new boolean[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    ge[i][j] = sc.nextInt();
                }
            }
            System.out.println(miGong(0, 0, p, ge, step));
        }
    }

    private static boolean miGong(int n, int m, int p, int[][] ge, boolean[][] step) {
        if(n >= ge.length || n < 0 || m < 0 || m >= ge[0].length) {
            return false;
        }
        if(step[n][m]) {
            return  false;
        }
        step[n][m] = true;
        if(p == 0){
            if(n == 0 && m == ge[0].length -1) {
                return true;
            }
            return false;
        }
        if(p < 0) {
            return false;
        }
        boolean res =miGong(n-1, m, p -3, ge, step) ||
                miGong(n+1, m, p, ge, step) ||
                miGong(n, m - 1,p - 1 , ge, step) ||
                miGong(n, m + 1, p - 1, ge, step);
        return res;
    }
}
