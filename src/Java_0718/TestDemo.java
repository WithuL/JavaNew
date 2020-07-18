package Java_0718;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TestDemo {
    static class Task implements Comparable<Task>{
        public Runnable command = null;
        public long time = 0;

        public Task(Runnable command, long time) {
            this.command = command;
            this.time = time;
        }

        public void run() {
            command.run();
        }

        public int compareTo(Task o ) {
            return (int) (this.time - o.time);
        }
    }

    static class Woker extends Thread{
        PriorityBlockingQueue<Task> queue = null;
        public Woker(PriorityBlockingQueue<Task> priorityQueue) {
            this.queue = priorityQueue;
        }
        @Override
        public void run() {
            while(true) {
                try {
                    Task task = queue.take();
                    long time = System.currentTimeMillis();
                    if(time > task.time) {
                        queue.put(task);
                    }else{
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Timer {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        public Timer() {
            Woker woker = new Woker(queue);
            woker.start();
        }
        public void schedule (Runnable command, long time) {
            Task task = new Task(command, time);
            queue.put(task);
        }
    }
}
