package Java_0704;
import java.util.*;

public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.next();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                byte tmp = (byte) (c - '\0');
                System.out.println(help(tmp));
            }
        }
    }

    private static String help(byte tmp) {
        String binary = Integer.toBinaryString(tmp);
        int count = 0;
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                count++;
            }
        }
        int s = 7-binary.length();
        String res = "";
        while(s > 0) {
            res = res+"0";
            s--;
        }
        if(count % 2 == 0) {
            res = "1" + res + binary;
        }else {
            res = "0" + res + binary;
        }
        return res;
    }
}
