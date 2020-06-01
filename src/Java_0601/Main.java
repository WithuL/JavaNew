package Java_0601;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        // 创建一个BufferedReader对象
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        String[] strs = line.trim().split(" ");
//        int n = Integer.parseInt(strs[0]);
//        int m = Integer.parseInt(strs[1]);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        String[] str = line.trim().split(" ");
//        int len = Integer.parseInt(str[0]);
//        int m = Integer.parseInt(str[1]);
//        line = br.readLine();
//        str = line.trim().split(" ");
//        int[] nums = new int[len];
//        for(int i = 0; i < len ; i++) {
//            nums[i] = Integer.parseInt(str[i]);
//        }
//        System.out.println(Arrays.toString(nums));

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("使用next()方法,将空格符' '作为分隔符,输入为: ");
//        while(scanner.hasNext()){
//            System.out.println("输出为: ");
//            String sc = scanner.next();
//            System.out.println(sc);
//        }

        /*
         * 循环连续输入和输出
         * 输入：一个数字 3
         *     一个数组 1 2 3
         */
        Scanner x=new Scanner(System.in);
        while(x.hasNext()){
            int m=x.nextInt();
            //System.out.println(m);
            int[] number=new int[m];
            for(int i=0;i<m;i++){
                number[i]=x.nextInt();
            }
            // Arrays.sort(number);
            System.out.println(Arrays.toString(number));
        }
    }
}
