package Java_0724;
import java.util.*;

public class TiHuan {
    public String replaceSpace(String iniString, int length) {
        // write code here
        char[] ch = iniString.toCharArray();
        if(ch == null || ch.length == 0) {
            return null;
        }
        int sum = 0;
        int kg = 0;
        int i = 0;

        while(i < ch.length ) {
            ++sum;
            if(ch[i] == ' ') {
                kg++;
            }
            ++i;
        }

        int newL = sum + 2 * kg;
        char[] ch2 = new char[newL];
        System.arraycopy(ch, 0 , ch2, 0, sum);

        int oIndex = i-1;
        int nIndex = newL-1;

        while(oIndex < nIndex && oIndex >= 0) {
            if(ch[oIndex] == ' ') {
                ch2[nIndex--] = '0';
                ch2[nIndex--] = '2';
                ch2[nIndex--] = '%';
            }else {
                ch2[nIndex--] = ch[oIndex];
            }
            --oIndex;
        }
        return String.copyValueOf(ch2);
    }

    public static void main(String[] args) {
        TiHuan tiHuan = new TiHuan();
        System.out.println(tiHuan.replaceSpace("Mr John Smith", 13));
    }
}
