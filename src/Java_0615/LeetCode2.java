package Java_0615;

public class LeetCode2 {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = nums[left];
            // 区间里可能会有一些互相抵销的元素
            for (int right = left +1; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subarraySum(arr,3);
    }
}

