package Java_0701;
import java.util.*;
public class NewKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String ip = sc.nextLine();
            String ips = sc.nextLine();
            ipHelp(ip);
            ipsHelp(ips);
        }
    }

    private static void ipHelp(String ip) {
        String[] strs = ip.split("\\.");
        long tmp = Long.parseLong(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            tmp <<= 8;
            tmp += Long.parseLong(strs[i]);
        }
        System.out.println(tmp);
    }

    private static void ipsHelp(String ips) {
        String tmp = Long.toBinaryString(Long.parseLong(ips));
        StringBuilder stringBuilder = new StringBuilder();
        if(tmp.length() < 32) {
            for(int i = 0; i < 32 - tmp.length(); i++) {
                stringBuilder.append("0");
            }
        }
        stringBuilder.append(tmp);
        for(int i = 0; i < 32 - 8; i += 8) {
            System.out.print(Integer.parseInt(stringBuilder.substring(i,i+8),2) + ".");
        }
        System.out.println(Integer.parseInt(stringBuilder.substring(stringBuilder.length()-8,stringBuilder.length()),2));
    }
}
