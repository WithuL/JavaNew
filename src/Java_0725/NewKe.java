package Java_0725;
import java.util.*;

public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()) {
            String s = sc.next();
            isH(s);
        }
    }

    private static void isH(String s) {
        for(int i = 0; i < s.length(); i++) {
            String l = s.substring(0,i) + s.substring(i+1, s.length());
            if(new StringBuffer(l).reverse().toString().equals(l)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
