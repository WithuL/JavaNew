package Java_0725;
import java.util.*;
public class Da {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
        while(sc.hasNextInt()){
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                arr[1] = 29;
            }
            int days = 0;
            for(int i = 0 ;i < m-1 ; i++) {
                days += arr[i];
            }
            days += d;
            System.out.println(days);
        }
    }
}
