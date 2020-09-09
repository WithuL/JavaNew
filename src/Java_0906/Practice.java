package Java_0906;

public class Practice {
//    百万富翁的问题
//    public static void main(String[] args) {
//        int rich = 10 * 30;
//        int stranger = 0;
//        for(int i = 0; i < 30 ; i++) {
//            stranger += (int)Math.pow(2, i);
//        }
//        System.out.println(rich + " " + stranger);
//    }

//    斐波那契问题
    public int Fibonacci(int n) {
        if(n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int res = 0;
        while(n >= 2) {
            res = (a + b) % 1000_000_007;
            a = b;
            b = res;
            n--;
        }
        return res;
    }

    public int fib(int n ) {
        if( n == 1) {
            return n ;
        }
        return n * fib(n-1);
    }

    public void solution(int n ) {
        n = fib(n);
        int count = 0;
        while(n != 0) {
            if(n % 10 == 0) {
                count++;
            }
            n /= 10;
        }
        System.out.println(count);
    }
}
