package Java_0617;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int cols = sc.nextInt();
            int rows = sc.nextInt();
            int count = 0;
            for(int row = 0; row < rows; row++) {
                for(int col = 0; col < cols; col++) {
                    if(((row % 4 == 0 || row % 4 == 1) && (col % 4 == 0 || col % 4 == 1)) ||
                        ((row % 4 == 2 || row % 4 == 3 ) && (col % 4 == 2 || col % 4 == 3))
                    ) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
