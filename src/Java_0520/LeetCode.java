package Java_0520;

public class LeetCode {
    //下一个排列;
    class Solution1 {
        public void nextPermutation(int[] nums) {
            if(nums.length == 1) {
                return ;
            }
            int left = nums.length - 2;
            int right = nums.length - 1;
            int tmp = nums.length - 1;
            while(left >= 0 && nums[left] >= nums[right] ) {
                left--;
                right--;
            }
            if(left >= 0) {
                while(nums[left] >= nums[tmp]) {
                    tmp--;
                }
                int cur = nums[left];
                nums[left] = nums[tmp];
                nums[tmp] = cur;
            }
            for(int i = right,j = nums.length - 1; i < j; i++,j--) {
                int cur = nums[i];
                nums[i] = nums[j];
                nums[j] = cur;
            }
        }
    }

//    搜索旋转排序数组
    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length == 0) {
                return -1;
            }
            int start = 0;
            int end = nums.length - 1;
            int mid;
            while(start <= end) {
                mid = (start + end) / 2;
                if(nums[mid] == target) {
                    return mid;
                }
                if(nums[start] <= nums[mid]) {
                    if(nums[start] <= target && target < nums[mid]) {
                        end = mid-1;
                    }else {
                        start = mid +1;
                    }
                }else {
                    if(nums[mid] < target && target <= nums[end]) {
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
