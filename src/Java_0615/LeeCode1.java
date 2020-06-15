package Java_0615;

public class LeeCode1 {
    class Solution {
        //每日温度
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];
            for(int i = 0; i < T.length - 1; i++) {
                for(int j = i + 1; j < T.length; j++) {
                    if(T[j] > T[i]) {
                        res[i] = j-i;
                        break;
                    }
                }
            }
            return res;
        }
    }


//    解法2
    class Solution2 {
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];
            for(int i = T.length - 2; i >= 0; i--) {
                for(int j = i + 1; j < T.length; j = j + res[j]) {
                    if(T[j] > T[i]) {
                        res[i] = j - i;
                        break;
                    }else if (res[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                        res[i] = 0;
                        break;
                    }
                }
            }
            return res;
        }
    }
}

