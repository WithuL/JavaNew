package Java_0721;

import java.util.Scanner;

public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String[] strs = sc.nextLine().split("_");
            StringBuilder sb = new StringBuilder();
            sb.append(strs[0]);
            for(int i = 1; i < strs.length; i++) {
                for(int j = 0; j < strs[i].length(); j++) {
                    if(j == 0) {
                        sb.append(Character.toUpperCase(strs[i].charAt(j)));
                    }else {
                        sb.append(strs[i].charAt(j));
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
