package Java_0606;
import java.util.*;
public class LeetCode {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//            String[] strs = str.split(" ");
//            int[] t = new int[4];
//            for(int i = 0; i < 4; i++) {
//                t[i] = Integer.parseInt(strs[i]);
//            }
//
//            if((t[0] + t[2]) % 2 != 0){
//                System.out.println("No");
//                return;
//            }
//
//            int a = (t[0] + t[2]) / 2;
//
//            int b = t[2] - a;
//
//            int c = t[3] - b ;
//            System.out.println(a + " " + b + " " + c);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for(int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            Arrays.sort(arr);
            System.out.println(arr[arr.length / 2]);
        }
    }
}
