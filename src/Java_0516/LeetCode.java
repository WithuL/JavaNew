package Java_0516;

import java.util.HashMap;
import java.util.Map;

public class LeetCode {
    //无重复字符的子字符串
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() == 0 ) {
                return 0;
            }
            //用一个哈希表保存字符和其对应下表
            Map<Character,Integer> map = new HashMap<>();
            //max用来表示最大无重复子字符串元素个数
            int max = 0;
            //left为左边界
            int left = 0;
            //i表示有边界
            for(int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if(map.containsKey(tmp)) {
                    //left是当遇到了之前出现的字符，就更新左边界，
                    left = Math.max(left,map.get(tmp) + 1);
                }
                //记录当前字符和下标
                map.put(tmp,i);
                max = Math.max(max,i - left + 1);
            }
            return max;
        }
    }
}
