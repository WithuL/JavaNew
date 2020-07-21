package Java_0721;
import java.util.*;
public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if((tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z')) {
                    sb.append(tmp);
                } else {
                    tmp = ' ';
                    sb.append(tmp);
                }
            }
            String[] strs = sb.toString().trim().split(" ");
            for(int i = strs.length -1 ; i > 0; i--) {
                System.out.print(strs[i]+" ");
            }
            System.out.print(strs[0]);
        }
    }
}

