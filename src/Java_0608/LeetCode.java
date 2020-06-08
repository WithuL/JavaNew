package Java_0608;

import java.util.Scanner;

public class LeetCode {
//    最大公倍数
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int mutil = a * b;
//            int c = 1;
//            while(a % b != 0) {
//                c = a % b;
//                a = b > c ? b : c;
//                b = b <= c ? b : c;
//            }
//            c = mutil / b;
//            System.out.println(c);
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] cake = new int[m][n];
            int count = 0;
            int flag = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //先对即将判断的位置的合法性进行检查:
                    if (check(i, j, flag) > 0) {
                        if (flag == 3) {
                            if (cake[i - 2][j] == 0 && cake[i][j - 2] == 0) {
                                cake[i][j] = 1;
                                count++;
                            }
                            continue;
                        }else if( flag == 1) {
                            if (cake[i - 2][j] == 0) {
                                cake[i][j] = 1;
                                count++;
                            }
                            continue;
                        }else{
                            if (cake[i][j - 2] == 0) {
                                cake[i][j] = 1;
                                count++;
                            }
                            continue;
                        }
                    } else { //如果上面的位置不合法,那么就说明处于最开始的几个位置,可以直接加;
                        cake[i][j] = 1;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static int  check(int i ,int j,int flag) {
        if(i - 2 >= 0 && j - 2 >= 0) {
            return 3;
        }else if(i - 2 >= 0) {
            return 1;
        }else if(j - 2 >= 0) {
            return 2;
        }
        return -1;
    }
}

