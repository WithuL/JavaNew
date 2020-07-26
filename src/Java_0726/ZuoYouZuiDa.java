package Java_0726;

public class ZuoYouZuiDa {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }
        return max - A[0] > max - A[n-1] ? max-A[0] : max - A[n-1];
    }
}
