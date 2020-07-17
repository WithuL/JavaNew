package Java_0717;

import java.util.Scanner;

public class HuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            String res = "NO";
            for(int i = 0; i < str.length(); i++) {
                if(i == 0) {
                    if(reverse(str.substring(1, str.length()))){
                        res = "YES";
                        break;
                    }
                }
                String tmp = str.substring(0, i) + str.substring(i+1, str.length());
                if(reverse(tmp)){
                    res = "YES";
                    break;
                }
            }
            System.out.println(res);
        }
    }
    public static boolean reverse(String str) {
        for(int left = 0, right = str.length()-1; left < right; left++ , right--) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
