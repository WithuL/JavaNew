package Java_0608;

import java.util.Scanner;

public class TestDemo3 {
//    static class Test {
//        public void method() {
//                //显示
//            synchronized(this) {
//                System.out.println("hehe");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Test t = new Test();
//        t.method();
//    }
public static void main(String[] args) {
    //下面的代码意义是
    //演示锁的相关特性
    //如果线程1获取到锁以后,不进行输入操作的话,就会占着锁不放
    //此时线程2是不能获取到锁的,等到线程1释放锁以后,线程2才能获取到锁
    Object locker = new Object();
    Thread t1 = new Thread() {
        @Override
        public void run(){
            Scanner sc = new Scanner(System.in);
            synchronized(locker){ //先尝试加锁.然后读取数据
                System.out.println("线程1获取到锁");
                System.out.println("请输入一个整数:");
                int num = sc.nextInt(); //如果用户不输入,那么就会一直阻塞在nextInt,这个锁就会一直被占有
                System.out.println(num);
            }
        }
    };
    Thread t2 = new Thread() {
        @Override
        public void run(){
            while(true){
                synchronized (locker){
                    System.out.println("线程2获取到锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    };
    t1.start();
    t2.start();
}
}
