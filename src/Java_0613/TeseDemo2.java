package Java_0613;

import java.util.concurrent.PriorityBlockingQueue;

public class TeseDemo2 {

    static class Task implements Comparable<Task> {
        // 优先队列中的元素必须是可比较的~
        // 比较规则的指定主要是两种方式:
        // 1. 让 Task 实现 Comparable 接口
        // 2. 让优先队列构造的时候, 传入一个比较器对象 (Comparator).
        //Runnable中有一个run方法,可以借助这个run方法来描述要执行的具体的任务是什么.
        private Runnable command;
        //time表示什么时候来执行command
        private long time;
        //构造方法的参数表示,多少毫秒之后执行,表示的是一个相对时间,在代码里面要转化成一个绝对时间
        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }
        //执行任务
        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            //这里的比较逻辑是谁的执行时间小,谁先执行
            return (int)(this.time - o.time);
        }
    }

    static class Woker extends Thread{
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;
        public Woker(PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }
        @Override
        public void run() {
            //实现具体的线程执行内容
            //这里是用来循环扫描阻塞队列的首元素是否到达时间
            while(true) {
                //1.取出队首元素,检查时间是否到了
                try {
                    Task task = queue.take();
                //2.检查当前任务时间是否到了
                    long curTime = System.currentTimeMillis();
                    if( task.time > curTime ) {
                        //说明还没到时间
                        //再把队列塞回去
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time - curTime);
                        }

                    }else{
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    static class Timer {
        //为了避免忙等,需要使用wait方法
        //使用一个单独的对象来辅助进行wait
        private Object  mailBox = new Object();

        //定时器的结构由三部分
        //1.使用一个类来描述"任务"
        //2.用一个阻塞优先队列来组织若干个任务,让队首元素就是执行时间最早的任务
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        //3.用一个线程来扫描当前阻塞队列的首元素,如果时间到了,就执行指定的任务
        public Timer() {
            Woker woker = new Woker(queue, mailBox);
            woker.start();
        }
        //4.还需要提供一个方法,让调用者能把任务给"安排进来"
        public void schedule(Runnable command, long after) {
            Task task = new Task(command, after);
            queue.put(task);
            synchronized (mailBox) {
                mailBox.notify();
            }
        }

        public static void main(String[] args) {
            Timer timer = new Timer();
            timer.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("屏幕前的你最帅");
                    timer.schedule(this, 500);
                }
            }, 2000);
        }
    }
}
