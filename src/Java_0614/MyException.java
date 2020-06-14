package Java_0614;

import javax.activity.ActivityRequiredException;

public class MyException {
    static void test( ) {
        int a = 10;
        if(a == 10) {
            throw new ArithmeticException();
        }
    }
    public static void main(String[] args) {
        test();
    }
}
