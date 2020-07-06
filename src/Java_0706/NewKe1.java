package Java_0706;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String a = sc.nextLine().trim();
            String[] b = a.split(" ");
            for(int i = b.length - 1 ; i> 0; i--) {
                System.out.print(b[i]+ " ");
            }
            System.out.println(b[0]);
        }
    }
}
