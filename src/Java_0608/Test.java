package Java_0608;

public class Test {
////    Runnable本身就描述了一段要执行的代码
//    static class MyRunnable implements Runnable{
//        @Override
//        public void run() {
//            System.out.println("我是个线程");
//        }
//    }
//    public static void main(String[] args) {
//        Thread t = new Thread(new MyRunnable());
//        t.start();
//    }
//}

//    public static void main(String[] args) {
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是一个线程");
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();
//
//    }
//    public static void main(String[] args) {
//        Thread t = new Thread("浪客秦昊线程") {
//            @Override
//            public void run() {
//                for(int i = 0 ; i < 5; i++) {
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                //run方法的执行过程就代表着系统内的线程的生命周期
//                //run方法执行中,内核的线程就存在.
//                //run方法执行完毕,内核中的线程就随之销毁
//                System.out.println("线程退出了");
//            }
//        };
//        //这组属性只要线程创建好,属性就不变了
//        System.out.println(t.getName());
//        System.out.println(t.getPriority());//获取线程的优先级;
//        System.out.println(t.isDaemon());//是否后台线程
//        System.out.println(t.getId());//获取id
//        //这两个属性会随着线程的运行而发生改变
//        System.out.println(t.isAlive());//是否存活
//        System.out.println(t.isInterrupted());//是否中断
//        System.out.println(t.getState());//获取线程的状态
//        t.start();
//
//        //当线程还存活的时候输出状态
//        //输出是否被中断
//        while(t.isAlive()){
//            System.out.println("浪客秦昊正在运行");
//            System.out.println(t.getState());
//            System.out.println(t.isInterrupted());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    private static boolean isQuit = false;
//    public static void main(String[] args) {
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                while(!isQuit){
//                    System.out.println("线程正在运行");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        t.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        isQuit = true;
//        System.out.println("线程run完结束");
//    }
//    public static void main(String[] args) {
//        Thread tr = new Thread() {
//            @Override
//            public void run(){
//                while(!Thread.currentThread().isInterrupted()){
//                    System.out.println("线程正在执行");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
//                }
//                System.out.println("线程意外结束");
//            }
//        };
//        tr.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("线程将被中断");
//        tr.interrupt();
//    }
//public static void main(String[] args) {
//    Thread tr = new Thread() {
//        @Override
//        public void run(){
//            for(int i = 0; i < 10 ; i++) {
//                System.out.println(Thread.currentThread().isInterrupted());
//            }
//        }
//    };
//    tr.start();
//    tr.interrupt();
//}
//public static void main(String[] args) {
//    Thread tr = new Thread() {
//        @Override
//        public void run(){
//            while(true){
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("1线程");
//            }
//        }
//    };
//    tr.start();
//    while(true){
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("0线程");
//    }
//}
public static void main(String[] args) throws InterruptedException {
    Thread tr1 = new Thread() {
        @Override
        public void run(){
            for(int i = 0; i < 5;i++) {
                System.out.println("线程1");
            }
        }
    };
    Thread tr2 = new Thread() {
        @Override
        public void run(){
            for(int i = 0; i < 5;i++) {
                System.out.println("线程2");
            }
        }
    };
    tr1.start();
    tr2.start();
    tr1.join();
    tr2.join();
}
}
