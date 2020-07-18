package Java_0718;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class TestDemo2 {
    //线程池要有 线程, 还要有任务
    //用有限阻塞队列管理任务
    //用list管理线程们
    //用final管理线程数量

    static class Woker extends Thread{
        PriorityBlockingQueue<Runnable> queue = null;

        public Woker(PriorityBlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while(!currentThread().isInterrupted()) {
                    Runnable runnable = queue.take();
                    runnable.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class MyThreadPool {
        private PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        private List<Woker> wokers = new ArrayList<>();
        private final static int MAX_WOKER_COUNT = 10;

        public void excute (Runnable mission) {
            if(wokers.size() < MAX_WOKER_COUNT) {
                Woker woker = new Woker(queue);
                woker.start();
                wokers.add(woker);
            }
            queue.put(mission);
        }

        public void shutdown() throws InterruptedException {
            for(Woker woker : wokers) {
                woker.interrupt();
            }
            for(Woker woker : wokers) {
                woker.join();
            }
        }
    }
}