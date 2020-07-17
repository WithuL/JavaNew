package Java_0717;

import java.util.Arrays;

public class DanDiao {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        for(int i = n-1; i >= 0; i--) {
            int x = 0, y = i;
            while(x < n && y < n) {
                res[index++] = arr[x][y];
                x++;
                y++;
            }
        }
        for(int i = 1; i < n; i++) {
            int x = i, y = 0;
            while(x < n && y < n) {
                res[index++] = arr[x][y];
                x++;
                y++;
            }
        }
        return res;
    }
}

//[[1,  2,  3,  4]
// [5,  6,  7,  8]
// [9, 10, 11, 12]
// [13,14, 15, 16]]