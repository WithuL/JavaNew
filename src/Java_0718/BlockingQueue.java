package Java_0718;

public class BlockingQueue {
    private int[] arr = new int[1000];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public void add(int val) throws InterruptedException {
        synchronized(this) {
            if(size == arr.length) {
                wait();
            }
            arr[tail] = val;
            size++;
            tail++;
            if(tail == arr.length) {
                tail = 0;
            }
            notify();
        }
    }

    public int take() throws InterruptedException {
        synchronized (this) {
            if(size == 0) {
                wait();
            }
            int res = arr[head];
            head++;
            size--;
            if(head == arr.length) {
                head = 0;
            }
            return res;
        }
    }
}
