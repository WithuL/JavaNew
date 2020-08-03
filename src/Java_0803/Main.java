package Java_0803;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            String line = sc.next();
//            String str = "";
//            for(char ch : line.toCharArray()) {
//                if(ch > '9' || ch < '0') {
//                    str += 'z';
//                }else {
//                    str += ch;
//                }
//            }
//            String[] arr = str.split("z");
//            int max = 0;
//            for(int i = 0; i < arr.length; i++) {
//                if(arr[i].length() > max) {
//                    max = i;
//                }
//            }
//            System.out.println(arr[max]);
//        }
//    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int len = input.length - 1;
        for(int i = 0; i < input.length; i++) {
            for(int j = len ; j >i; j--) {
                if(input[j] < input[j-1]) {
                    int tmp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = tmp;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        for(int x : GetLeastNumbers_Solution(arr, 4)) {
            System.out.print(x+ " ");
        }
    }
}
