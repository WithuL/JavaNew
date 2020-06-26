//package Java_0625;
//
//import java.util.Arrays;
//
//public class TestDemo6 {
//    public static void insetSort(int[] array) {
//        for(int bound = 1; bound < array.length; bound++) {
//            int tmp = array[bound];
//            int cur = bound - 1;
//            for(; cur >= 0; cur--) {
//                if(array[cur] > tmp) {
//                    array[cur + 1] = array[cur];
//                }else{
//                    break;
//                }
//            }
//            array[cur + 1] = tmp;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {3 ,2, 1};
//        insetSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//}
