package Java_0723;
import java.util.Arrays;

public class ShuZi {
        public int MoreThanHalfNum_Solution(int [] array) {
            int count = 1, pre = array[0];
            for(int i = 1; i < array.length; i++) {
                if(array[i] != pre) {
                    count--;
                }else {
                    count++;
                }
                if(count == 0) {
                    count = 1;
                    pre = array[i];
                }
            }
            count = 0;
            for(int i = 0; i < array.length; i++) {
                if(array[i] == pre) {
                    count++;
                }
            }
            return count > (array.length / 2) ? pre : 0;
        }
}
