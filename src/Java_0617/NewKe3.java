package Java_0617;

import java.util.Scanner;

public class NewKe3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n ; i++) {
                arr[i] = i;
            }
            help(arr, n);
        }
    }
    public static int index(int i,int n) {
        if(i + 1 == n) {
            return 0;
        }
        return i+1;
    }
    public static void help(int[] arr, int n) {
        int i = 0;
        int step = 0;
        int pre = 0;
        while(n > 0) {
            pre = i;
            if(arr[i] == -1) {
            }else if(step != 2) {
                step += 1;
            }else{
                arr[i] = -1;
                step = 0;
                n--;
            }
            i = index(i, arr.length);
        }
        System.out.println(pre);
    }
}
