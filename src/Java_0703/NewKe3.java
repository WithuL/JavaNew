package Java_0703;

import java.util.Scanner;

public class NewKe3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            int n = sc.nextInt();
            int max = 0;
            String l = str.substring(0,n);
            for(int i = 0; i < str.length() - n; i++) {
                String tmp = str.substring(i,n+i);
                int t = 0;
                for(int j = 0; j < n; j++) {
                    if (tmp.charAt(j) == 'G' || tmp.charAt(j) == 'C') {
                        t++;
                    }
                }
                if(t > max) {
                    l = tmp;
                    max = t;
                }
            }
            System.out.println(l);
        }
    }
}
