package Java_0726;

import java.util.*;

public class ShunShi {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] res = new int[n*m];
        int up = 0, down = n-1, left = 0, right = m-1, index = 0;
        while(left <= right && up <= down) {
            for(int i = 0; i <= right ;i++) {
                res[index++] = mat[up][i];
            }
            ++up;
            for(int i = up; i <= down ;i++) {
                res[index++] = mat[i][right];
            }
            right--;
            for(int i = right; i >= left; i--) {
                res[index++] = mat[down][i];
            }
            down--;
            for(int i = down; i >= up ;i--) {
                res[index++] = mat[i][left];
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        ShunShi   shunShi = new ShunShi();
        int[][] mat = {{4,46,89},{28,66,99},{26,21,71}};
        int[] res = new int[9];
        res = shunShi.clockwisePrint(mat, 3, 3);
        for(int x : res) {
            System.out.print(x+" ");
        }
    }
}