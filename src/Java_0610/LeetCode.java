package Java_0610;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode {
    //找到所有数组中消失的数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        HashSet<Integer> h = new HashSet<>();
        for (int x : nums) {
            h.add(x);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!h.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
