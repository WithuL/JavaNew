package Java_0624;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' ') {
                    res.append(' ');
                }else if(str.charAt(i) - 5 < 'A') {
                    int k = 4 - (str.charAt(i) - 'A');
                    res.append((char)('Z' - k));
                }else{
                    res.append((char) (str.charAt(i) - 5));
                }
            }
            System.out.println(res.toString());
        }
    }
}
