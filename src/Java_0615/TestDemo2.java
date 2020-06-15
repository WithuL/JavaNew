package Java_0615;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.LinkedList;
public class TestDemo2 {
    static class Woker extends Thread {
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        public Woker(BlockingQueue queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            //代码解释,线程运行的这段代码表示
            //当前的线程在没有被中断的情况下
            //会循环的取阻塞队列中的第一个任务
            //等到第一个任务执行完成后,此线程又会尝试取取新阻塞队列的第一个任务
            //如果此时已经没有新的任务了,那么就会触发InterruptedException异常
            //此时就不会执行try中的代码 即不会在执行while循环
            //而是在catch中捕获到了InterruptedException异常
            //随后执行catch中的代码
            //catch执行完后就退出run,线程就被销毁了.
            try{
                while(!Thread.currentThread().isInterrupted()) {
                    Runnable mission = queue.take();
                    mission.run();
                }
            }catch(InterruptedException a) {
                System.out.println("线程被终止");
            }
        }
    }
    static class MyThreadPoll {
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        List<Woker> wokers = new LinkedList<>();
        private static final int MAX_WOKERS_COUNGT = 10;
        public void excute(Runnable mission) throws InterruptedException {
            if(wokers.size() < MAX_WOKERS_COUNGT ) {
                Woker woker = new Woker(queue);
                woker.start();
                wokers.add(woker);
            }
            queue.put(mission);
        }
        public void shutdown() throws InterruptedException {
            for(Woker woker : wokers) {
                //interrut()方法本质上是给该线程触发一个异常,将Thread.currentThread().isInterrupted()的标志位置为true
                woker.interrupt();
            }
            //给每个线程出发异常后还需要等待
            for(Woker woker : wokers) {
                woker.join();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPoll myThreadPoll = new MyThreadPoll();
        myThreadPoll.excute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
    }
}
