package Java_0610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NewKe {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()) {
//            int len = sc.nextInt();
//            if(len > 1000) {
//                len = 1000;
//            }
//            List<Integer> arr = new ArrayList<>();
//            for(int i = 0; i < len; i++) {
//                arr.add(i);
//            }
//            int index = 0;
//            while(arr.size() > 1) {
//                index = (index + 2) % arr.size();
//                arr.remove(index);
//            }
//            System.out.println(arr.get(0));
//        }
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length - 1];
            for(int i = 0; i < strs.length - 1; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            int k = Integer.parseInt(strs[strs.length - 1]);
            Arrays.sort(arr);
            for(int i = 0; i < k-1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[k-1]);
        }
    }
}
