//package Java_0602;
//
//import java.util.Scanner;
//
//public class LeetCode {
//    public static void main(String[] args) {
//        int[] A = {1,2,3,4,5,6,7,0};
//        System.out.println(AntiOrder.count(A,8));
//    }
//}
//class AntiOrder {
//    public static int count(int[] A, int n) {
//        // write code here
//        int count = 0;
//        for(int end = n-1; end > 0; end--) {
//            for(int pre = end - 1; pre >= 0; pre--) {
//                if(A[pre] > A[end]) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//}
// class NewKe{
//    public static void main (String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()){
//            int ds = sc.nextInt();
//            int count = 0;
//            int use = 0,left = 0;
//            while(ds > 1) {
//                if(use + left == 2) {
//                    count += 1;
//                    break;
//                }
//                use = ds / 3;
//                left = ds % 3;
//                count += use;
//                ds = use + left;
//            }
//            System.out.println(count);
//        }
//    }
//}
//
