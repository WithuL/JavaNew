package Java_0617;

import java.util.Scanner;

public class NewKe1 {
    //n个数里出现次数大于等于n/2的数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for(int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            int count = 0;
            int pre = arr[0];
            for(int i = 1; i < strs.length; i++) {
                if(arr[i] == pre) {
                    count++;
                }else if(count > 0) {
                    count--;
                }else {
                    pre = arr[i];
                }
            }
            System.out.println(pre);
        }
    }

}
