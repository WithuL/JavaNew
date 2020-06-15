package Java_0615;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TestDemo {
    //使用这个类来描述当前的工作线程
    static class Woker extends Thread {
        //每个woker线程都要从任务队列中取出一个任务进行执行
        private BlockingQueue<Runnable> queue = null;

        public Woker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            //此处的try把while包裹进去了
            //只要线程收到异常,jiu'hui立刻结束run
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Runnable mission = queue.take();
                    mission.run();
                }
            }catch (InterruptedException e) {
                //线程被结束
                System.out.println("线程被终止");
            }
        }
    }


    //本质上就是一个生产者消费者模型
    //调用execute的代码就是生产者,产生了任务
    //worker就是消费者,消费了队列中的任务
    //交易场所就是BlockingQueue 
    static class MyThreadPool {
        //注意这里是阻塞队列,不是优先阻塞队列
        //这个用来组织任务,线程会从这个队列中取任务执行
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //这个线性表用来组织若干个工作线程
        private List<Woker> wokers = new ArrayList<>();
        //线程池的线程数目是根据实际情况确定的
        private static final int maxWokerCount = 10;
        //实现excute和shutdown方法
        public void excute(Runnable mission) throws InterruptedException {
            //也是使用延时加载的方式创建线程
            //当线程池中的线程数目比较少的时候,新创建的线程来作为工作线程
            //如果线程多了(达到了预定的阈值)就不用新建线程了
            if(wokers.size() < maxWokerCount) {
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
            //等待线程结束
            for(Woker woker : wokers) {
                woker.join();
            }
        }
    }
}

