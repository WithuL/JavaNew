package Java_0610;

import java.util.Scanner;

public class TestDemo {
    static class Counter {
        public volatile int counter = 0;

    }
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1  = new Thread(){
            @Override
            public void run() {
                while(counter.counter == 0) {
                }
                System.out.println("循环结束");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入一个整数");
                counter.counter =  sc.nextInt();

            }
        };
        t1.start();
        t2.start();
    }
}
