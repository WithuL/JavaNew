package Java_0614;

import javafx.concurrent.Worker;

import java.util.concurrent.PriorityBlockingQueue;

public class TestDemo {
    static class Task implements Comparable<Task>{
        //runnable是用来描述要做的事情 通过重写run方法实现
        private Runnable mission = null;
        private long time ;

        public Task(Runnable mission, long after) {
            this.mission = mission;
            this.time = System.currentTimeMillis() + after;
        }

        public void run() {
            mission.run();
        }
        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }

    static class Woker extends Thread {
        private PriorityBlockingQueue<Task> queue = null;
        private Object help = null;

        public Woker(PriorityBlockingQueue<Task> queue, Object help) {
            this.queue = queue;
            this.help = help;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Task task = queue.take();
                    long curTime = System.currentTimeMillis();
                    if(curTime < task.time) {
                        queue.put(task);
                        synchronized(help) {
                            help.wait(task.time - curTime);
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

    //主要完成使用优先级队列建立任务安排,同时提供添加任务的操作
    static class Timer{
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        private Object help = new Object();
        public Timer() {
            Woker woker = new Woker(queue, help);
            woker.start();
        }

        public void schedule(Runnable mission, int after) {
            Task task = new Task(mission, after);
            queue.add(task);
            synchronized (help) {
                help.notify();
            }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("哇哦我好帅");
            }
        }, 1000);
    }
}