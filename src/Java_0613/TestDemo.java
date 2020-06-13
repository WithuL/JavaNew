package Java_0613;

public class TestDemo{
     static class BlockingQueue {
        //普通的队列如何实现
        //有两中方式
        //1.基于链表
        //2.基于数组
        private int[] array = new int[1000];
        private int head = 0;
        private int tail = 0;
        //head 指向的是队列的队首位置
        //tail 指向的是队列的队尾的下一个位置
        //head和tail构成了一个前闭后开的区间
        //当两者重合的时候,队列可能满了,也可能为空
        //所以就需要引入一个size来表示
        private int size = 0;
        //队列的基本操作
        //1.入队列
        //2.出队列
        //这里只需实现这两个
        //阻塞版本的入队列,为了和之前的版本区分,用了不同的名字
        public void put(int value) throws InterruptedException {
            //队列先进先出,所以把value放到队尾即可
            synchronized (this) {
                //如果交易场所已经满了,但是没有消费者消费,那么此时就不能再生产了
                //就要等到消费者消费了,交易场所有空位了才能进行生产
                if(size == array.length) {
                    wait();
                    //那么在这里进行了等待
                    //如果由消费者消费了,也就是访问了take()方法,那么就可以通知当前线程进行生产
                    //也就是再take方法最后加上notify通知
                }
                array[tail] = value;
                size++;
                tail++;
                if(tail == array.length) {
                    tail = 0;
                }
                notify();
            }
        }

        public int take() throws InterruptedException {
            //取队首元素即可
            int ret = -1;
            synchronized (this) {
                //同样的
                //如果消费者消费的太快了,库存都被买光了
                //那么就要进行等待,等到生产者生产了再继续买
                //也就是size == 0 时等待
                if(size == 0) {
                    wait();
                    //既然是因为库存没了进行等待
                    //那么生产了之后就要通知线程进行消费
                    //所以在生产操作之后进行通知
                    //也就是put操作
                }
                ret =  array[head];
                size--;
                head++;
                if(head == array.length) {
                    head = 0;
                }
                notify();
                return ret;
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread producer = new Thread(){
            @Override
            public void run() {
                //生产者,生产的慢
                //此时我要生产1000个,也就是添加1000次
                for(int i = 1; i < 1000; i++) {
                    try {
                        System.out.println("正在生产第"+i+"个");
                        blockingQueue.put(i);
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread consumer = new Thread(){
            @Override
            public void run() {
                //消费者,消费者消费的快
                for(int i = 1 ; i < 1000; i++) {
                    try {
                        blockingQueue.take();
                        System.out.println("消费了"+i+"个");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        consumer.start();
    }
}