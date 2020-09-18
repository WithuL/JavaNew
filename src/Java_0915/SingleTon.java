package Java_0915;

import java.util.logging.StreamHandler;

//懒汉
public class SingleTon {
    private static volatile SingleTon instance = null;
    private SingleTon() {

    }
    public static SingleTon getInstance() {
        if(instance == null) {
            synchronized(SingleTon.class) {
                if(instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }


    static class MyThread extends Thread{
       @Override
       public void run() {
           System.out.println("你好");
       }
    }
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("这是Runnable");
        }
    }
    public static void main(String[] args) {
        //继承线程的方式
        MyThread myThread = new MyThread();
        myThread.start();
        //继承runnable的方式
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();;
        //匿名内部类实现Runnable的方式
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是匿名内部类");
            }
        };
        Thread  thread1 = new Thread(runnable);
        thread1.start();
        //匿名内部类实现Thread的方式
        Thread thread2 = new Thread() {
            @Override
            public void run(){
                System.out.println("匿名THread");
            }
        };

    }
}
//饿汉
class SingleTonEhan {
    private static SingleTonEhan instance = new SingleTonEhan();
    private SingleTonEhan() {

    }
    public static SingleTonEhan getInstance() {
        return instance;
    }

}

