package Java_0708;

import java.util.Scanner;

public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()) {
            String ip = sc.nextLine();
            String[] ips = ip.split("\\.");
            int c = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for(String s : ips) {
                sb.append(help(s));
            }
            System.out.println(sb);
            asd(c);
        }
    }

    private static String help(String ip) {
        String tmp = Integer.toBinaryString(Integer.parseInt(ip));
        int count = tmp.length();
        StringBuilder sb = new StringBuilder();
        while(count < 8) {
            sb.append("0");
            count++;
        }
        sb.append(tmp);
        return sb.toString();
    }

    private static void asd(int c) {
        String tmp = Integer.toBinaryString(c);
        int count = tmp.length();
        StringBuilder sb = new StringBuilder();
        while(count < 32) {
            sb.append("0");
            count++;
        }
        sb.append(tmp);
        String[] strs = new String[4];
        for(int i = 0; i < 32; i+=8) {
            strs[i] = sb.toString().substring(i,i+8);
        }
        for(int i = 0; i < 3; i++) {
            System.out.print(Integer.parseInt(strs[i])+".");
        }
        System.out.print(Integer.parseInt(strs[3])+".");
    }
}
