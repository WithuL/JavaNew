package Java_0530;

public class LeetCode {
    //寻找重复数
    static class Solution1 {
        public static int findDuplicate(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            for(int index = 0 ; index < nums.length; index++) {
                if(nums[index] != index +1 ) {
                    if(nums[index] == nums[nums[index] - 1]) {
                        return nums[index];
                    }
                    swap(nums,index,nums[index] - 1);
                }
                index--;
            }
            return 0;
        }
        private static void swap(int[] nums,int i,int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


}
