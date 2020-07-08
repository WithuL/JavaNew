package Java_0708;

public class Fib {
    public static void main(String[] args) {

    }
    public int countWays(int n) {
        // write code here
        if(n <= 2) {
            return n;
        }
        if(n == 3) {
            return 4;
        }
        long a = 1;
        long b = 2;
        long c = 4;
        long res = 0;
        for(int i = 3; i < n; i++) {
            res = (a + b + c ) % 1000000007;
            a = b;
            b = c;
            c = res ;
        }
        return (int)res;
    }
}
