package Java_0707;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int result = 0;
            int high = 0, cur = 0, low = 0, i = -1, flag = 0;
            while(flag != 1) {
                i++;
                int m = (int) Math.pow(10, i);
                high = n / m;
                cur = high % 10;
                high = high / 10;
                if(i == 0) low = 0;
                else low = n % m;
                if(cur < 2) result += high * m;
                if(cur == 2) result += high * m + low + 1;
                if(cur > 2) result += (high + 1) * m;
                if(high == 0) flag = 1;
            }
            System.out.println(result);
        }
    }
    public int countNumberOf2s(int n) {
        // write code here
        int result = 0;
        int high = 0, cur = 0, low = 0, i = -1, flag = 0;
        while(flag != 1) {
            i++;
            int m = (int) Math.pow(10, i);
            high = n / m;
            cur = high % 10;
            high = high / 10;
            if(i == 0) low = 0;
            else low = n % m;
            if(cur < 2) result += high * m;
            if(cur == 2) result += high * m + low + 1;
            if(cur > 2) result += (high + 1) * m;
            if(high == 0) flag = 1;
        }
        return result;
    }
}
