package Java_0610;

import java.util.Scanner;

public class NewKe4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            reverse(ch);
            for(char c : ch) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void reverse(char[] ch) {
        int left = 0;
        int right = ch.length - 1;
        while(left < right) {
            char tmp  = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
    }
}
