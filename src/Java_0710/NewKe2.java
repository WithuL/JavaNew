package Java_0710;

import java.util.Scanner;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next().substring(2);
            int a = 'A' - 10;
            int res = 0;
            for(int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if(tmp >= 'A' && tmp <= 'F') {
                    res += (tmp - a) * Math.pow(16, (str.length() -1 - i));
                }else {
                    res += Integer.parseInt(String.valueOf(tmp)) * Math.pow(16, (str.length() -1 - i));
                }
            }
            System.out.println(res);
        }
    }
}
