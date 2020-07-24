package Java_0724;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MiGong {
    static int n = 0;
    static int m = 0;
    static int power = 0;
    static int maxPower = 0;
    static int[][] arr;
    static LinkedList<String> path = new LinkedList<>();
    static String p = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNextInt()) {
            n = sc.nextInt();
            m = sc.nextInt();
            power = sc.nextInt();
            arr = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j <m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            zouMiGong(0,0,power);
            System.out.println(p.substring(1));
        }
    }

    private static void zouMiGong(int i, int j, int now) {
        if(i < 0 || j < 0 || i >= n || j >= m || arr[i][j] != 1) {
            return;
        }
        path.offer("["+i+","+j+"]");
        arr[i][j] = 0;
        if(i == 0 && j == m-1 && now > maxPower) {
            maxPower = now;
            pathHelp();
        }
        zouMiGong(i-1,j,now-3);
        zouMiGong(i+1, j,now);
        zouMiGong(i, j-1,now-1);
        zouMiGong(i,j+1,now-1);
        arr[i][j] = 1;
        path.removeLast();
    }

    private static void pathHelp() {
        for(String s : path) {
            p = p + "," + s;
        }
    }
}
