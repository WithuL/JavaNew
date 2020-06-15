package Java_0615;

import java.util.Scanner;

public class NewKe2 {
    //超长整数相加
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            int add = 0;
            int sum = 0;
            StringBuffer res = new StringBuffer();
            if(b.length() > a.length()) {
                String c = a;
                a = b;
                b = c;
            }
            int indexA = a.length() - 1;
            int indexB = b.length() - 1;
            while(indexB >= 0) {
                int up = Integer.parseInt(a.substring(indexA,indexA+1));
                int down = Integer.parseInt(b.substring(indexB,indexB+1));
                sum = up + down + add;
                add = sum / 10;
                res.append(String.valueOf(sum % 10).toCharArray());
                indexA--;
                indexB--;
            }
            while(indexA >= 0) {
                int up = Integer.parseInt(a.substring(indexA,indexA+1));
                sum = add + up;
                add = sum / 10;
                res.append(String.valueOf(sum % 10).toCharArray());
                indexA--;
            }
            if(add > 0) {
                res.append(String.valueOf(add).toCharArray());
            }
            res.reverse();
            System.out.println(res.toString());
        }
    }
}
