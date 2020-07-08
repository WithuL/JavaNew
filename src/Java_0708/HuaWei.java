package Java_0708;

import java.util.Scanner;

public class HuaWei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] stu = new int[n];
            for(int i = 0; i < n; i++) {
                stu[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++) {
                String tmp = sc.next();
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(tmp.equals("Q")) {
                    int s = Math.min(a, b);
                    int e = Math.max(a, b);
                    int max = stu[s-1];
                    for(int index = s; index < e; index++) {
                        if(stu[index] > max) {
                            max = stu[index];
                        }
                    }
                    System.out.println(max);
                }else {
                    stu[a-1] = b;
                }
            }
        }
    }
}
