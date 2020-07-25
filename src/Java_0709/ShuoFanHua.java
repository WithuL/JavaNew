package Java_0709;

import java.util.Scanner;

public class ShuoFanHua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String a = sc.nextLine();
            String[] b =a.split(" ");
            for(int i = b.length-1; i > 0; i--) {
                System.out.print(b[i]+" ");
            }
            System.out.println(b[0]);
        }
    }
}
