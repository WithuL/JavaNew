package Java_0705;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class NewKe1 {
    public int getValue(int[] gifts, int n) {
//        // write code here
//        int res = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int x : gifts) {
//            map.put(x, map.getOrDefault(x, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() > (n / 2)) {
//                res = entry.getKey();
//            }
//        }
//        return res;

//        Arrays.sort(gifts);
//        int res = gifts[n / 2], nums = 0;
//        for(int i = 0; i < n; i++) {
//            if(gifts[i] == res) {
//                nums++;
//            }
//        }
//        return nums > (n/2) ? gifts[n/2] : 0;
        if(gifts.length == 0) {
            return 0;
        }
        if(gifts.length < n) {
            return 0;
        }
        int count = 0, temp = 0;
        for(int i = 0; i < n; i++) {
            if(count == 0) {
                temp = gifts[i];
                count++;
            }
            if(gifts[i] != temp) {
                count--;
            }else{
                count++;
            }
        }
        int size = 0;
        for(int i = 0; i < n; i++) {
            if(temp == gifts[i]) {
                size++;
            }
        }
        return size > (n/2) ? temp : 0;
    }
}
