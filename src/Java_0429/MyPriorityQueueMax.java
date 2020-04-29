package Java_0429;


//利用堆来构造优先级队列，大顶堆
public class MyPriorityQueueMax {
    //创建堆所需的数组和大小
    private int[] array = new int[100];
    private int size = 0;//已存数组个数
    //插入元素操作
    public void offer(int x) {
        //直接插到最后一个位置(最后一个非叶子结点的下方)
        this.array[size++] = x;
        //插入完成后进行向上调整操作，保证堆的规范性
        shiftUp(array,size,size-1);
    }

    //向上调整，调整的是最后插入的那个元素
    private void shiftUp(int[] array, int size, int index) {
        //根据插入的元素的下表找到其父结点的元素下标
        int parent = (index - 1) / 2;
        int child = index;
        //然后开始进行大小比较，下面的循环会从插入位置开始一路比较到根结点,index = 0 是说明parent = 0 已经操作过了，所以
        while(index > 0) {
            if(array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else{
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    //取队首元素
    public Integer poll() {
        //如果优先队列为空直接返回null
        if(this.size == 0) {
            return null;
        }
        //先记录对手元素
        int ret = this.array[0];
        //让队尾元素替代对手元素，避免损坏堆的结构
        this.array[0] = this.array[size-1];
        size--;
        //已用空间--
        //调整一遍堆
        shiftDown(this.array,this.size,0);
        //返回原队首元素
        return ret;
    }
    //向下调整
    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        //由于是向下调整，孩子节点是往下寻找的，孩子节点的下标必须小于已用数组长度，否则就越界了
        while(child < size) {
            if(child + 1 < size && array[child+1] > array[child]) {
                child = child + 1;
            }
            if(array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else{
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    private Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[0];
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    private void creatHeap (int arr[]) {
        for(int i = (arr.length - 1 - 1)/2; i >= 0; i--) {
            shiftDown(arr,arr.length,i);
        }
    }

    public static void main(String[] args) {
        MyPriorityQueueMax myPriorityQueueMax = new MyPriorityQueueMax();
        myPriorityQueueMax.offer(5);
        myPriorityQueueMax.offer(8);
        myPriorityQueueMax.offer(9);
        myPriorityQueueMax.offer(4);
        myPriorityQueueMax.offer(3);
        myPriorityQueueMax.offer(6);
        myPriorityQueueMax.offer(19);
        myPriorityQueueMax.offer(17);
        while(!myPriorityQueueMax.isEmpty()) {
            System.out.print(myPriorityQueueMax.poll()+ " ");
        }
    }
}













