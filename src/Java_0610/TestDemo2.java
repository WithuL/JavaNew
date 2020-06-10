package Java_0610;

import java.util.Scanner;

public class TestDemo2 {
    //wait方法
//    public static void main(String[] args) throws InterruptedException {
//        Object  object = new Object();
//            System.out.println("等待前");
//            object.wait();
//            System.out.println("等待后");
//    }


//    public static void main(String[] args) throws InterruptedException {
//        Object  object = new Object();
//        synchronized (object){
//            System.out.println("等待前");
//            object.wait();
//            System.out.println("等待后");
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        Object  locker = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (locker) {
                    while(true) {
                        try {
                            //针对哪个对象锁,就要调用哪个对象的wait方法
                            System.out.println("进入阻塞等待");
                            System.out.println("wait方法开始");
                            locker.wait();
                            System.out.println("wait方法结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (locker) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("输入任意数执行notify");
                    int num = sc.nextInt();
                    System.out.println("notify开始");
                    locker.notify(); //这里还是要对应
                    System.out.println("notyfy结束");
                }
            }
        };
        t2.start();
    }


}
