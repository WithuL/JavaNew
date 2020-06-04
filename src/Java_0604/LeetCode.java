package Java_0604;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode {
//    买苹果
    public static void newKe() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int ip = sc.nextInt();
            if(ip % 2 == 1 || ip < 6 ){
                System.out.println("-1");;
            }else if(ip == 6 || ip == 8) {
                System.out.println("1");;
            }else {
                int[] nums = new int[ip + 1];
                Arrays.fill(nums,0,ip + 1,1000);
                nums[6] = 1;
                nums[8] = 1;
                for(int i = 7; i <= ip; i++) {
                    if(check(i)){
                        if(i >8) {
//                            System.out.println("nums["+(i-6)+"]"+"="+nums[i-6]);
//                            System.out.println("nums["+(i-8)+"]"+"="+nums[i-8]);
                            nums[i] = Math.min(nums[i-8] +1,nums[i-6] + 1);
                        }else if(i == 8) {
                            continue;
                        }
                        else{
                            nums[i] = nums[i-6];
                        }
                    }
                }
                String res = nums[ip] == Integer.MAX_VALUE ? "-1" : String.valueOf(nums[ip]);
                System.out.println(res);
            }
        }
    }
    public static boolean check(int nums){
        int f1 = nums-6;
        int f2 = nums-8;
        if(f1 % 6 != 0 && f1 % 8 != 0&&
           f2 % 6 != 0 && f2 % 8 != 0) {
            return false;
        }
        return true;
    }

    
}
