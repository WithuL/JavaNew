package Java_0615;

import java.util.Arrays;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a);
        return a[n-K];
    }
}
