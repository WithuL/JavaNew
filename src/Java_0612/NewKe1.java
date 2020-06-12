package Java_0612;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            int[] res = new int[10];
            for(int i = 0; i < str.length(); i++){
                int tmp = Integer.parseInt(String.valueOf(str.charAt(i)));
                res[tmp] += 1;
            }
            for(int i = 0; i < 10; i++) {
                if(res[i] != 0) {
                    System.out.println(i+":"+res[i]);
                }
            }
        }
    }
}
