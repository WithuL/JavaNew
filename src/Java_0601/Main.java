package Java_0601;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) throws IOException {
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
//        Scanner x=new Scanner(System.in);
//        while(x.hasNext()){
//            int m=x.nextInt();
//            //System.out.println(m);
//            int[] number=new int[m];
//            for(int i=0;i<m;i++){
//                number[i]=x.nextInt();
//            }
//            // Arrays.sort(number);
//            System.out.println(Arrays.toString(number));
//        }
//    }

    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            StringBuilder res = new StringBuilder();
            int count = 0;
            for(int i = 0; i < a.length()+1; i++) {
                String tmp = a.substring(0,i) + b+ a.substring(i,a.length());
                StringBuffer sb = new StringBuffer(tmp);
                if(sb.reverse().toString().equals(tmp)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static int revr(String str,int count) {
        int left = 0;
        int right = str.length()-1;
            while(left < right) {
            if(str.charAt(left) != str.charAt(right)){
                return 0;
            }
            left++;
            right--;
        }
        return count+1;
    }


    public class FindKthNum {

        private  int findKthNum(int[] num, int len, int k) {
            return quickSort(num, 0, len-1, k);
        }

        private  int quickSort(int[] num, int low, int high, int k){
            if(low <= high){
                int pos = partition(num, low, high);
                if(pos == k-1)
                    return num[pos];
                else if(pos > k-1)
                    return quickSort(num, low, pos-1, k);
                else
                    return quickSort(num, pos+1, high, k);
            }else
                return -1;
        }

        private  int partition(int[] num, int low, int high) {
            int tmp = num[low];
            while(low < high){
                while((low < high) && tmp >= num[high])//（1）
                    high--;
                num[low] = num[high];
                while((low < high) && tmp <= num[low])//（2）
                    low++;
                num[high] = num[low];
            }
            num[low] = tmp;
            return low;
        }

}
