//package Java_0608;
//
//public class TestDemo2 {
//    static class Counter {
//        private static int count;
//        synchronized public static void increse(){
//            count++;
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread() {
//            @Override
//            public void run(){
//                for(int i = 0; i < 50000; i++) {
//                    Counter.increse();
//                }
//            }
//        };
//        Thread t2 = new Thread() {
//            @Override
//            public void run(){
//                for(int i = 0; i < 50000; i++) {
//                    Counter.increse();
//                }
//            }
//        };
//        Counter counter = new Counter();
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(Counter.count);
//    }
//}
