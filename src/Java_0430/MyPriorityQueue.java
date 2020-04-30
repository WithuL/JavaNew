package Java_0430;

public class MyPriorityQueue {
    //暂不考虑扩容
    int[] array = new int[100];
    int size = 0;

    //插入方法
    public void offer(int x) {
        array[size++] = x;
        shiftUp(array,size,size-1);
    }

    //出队首元素
    public Integer poll() {
        //如果优先队列为空直接返回null
        if(this.size == 0) {
            return null;
        }
        //先记录队首元素
        int ret = this.array[0];
        //让队尾元素替代队首元素，避免损坏堆的结构
        this.array[0] = this.array[size-1];
        size--;
        //已用空间--
        //调整一遍堆
        shiftDown(this.array,this.size,0);
        //返回原队首元素
        return ret;
    }
    //判空
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
    //此方法是用来将一个不是堆的完全二叉树构造成堆
    public void creatHeap(int[] newArray) {
        //newArray.length - 1得到了最后一个节点的下标
        //然后再 -1 / 2 就是根据最后一个节点的下标找到其父结点的下标
        for(int i = (newArray.length - 1 - 1) / 2; i >= 0; i--) {
            //从最后一个非叶子节点开始进行排序，依次网上排序，保证循环到根节点时，其左子树右子树都满足堆的性质
            shiftDown(array,size,i);
        }
    }
    public void shiftDown(int[] array, int size, int index) {
        //记录父节点位置
        int parent = index;
        //计算左子树的位置
        int child = index * 2 + 1;
        //当子树下标超过或等于数组长度时即为操作结束
        while(child < size) {
            //首先比较左子树和右子树谁的值比较大，如果右子树存在并且右子树的值大于左子树则替换child
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            //然后比较子树和父结点谁的值较大，如果子树的值大则将父节点的值和子树的值交换
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            //由于比较此父结点之前，其左子树和右子树都已满足堆的性质（大顶堆就是任意节点的值都要大于其子树的值
            // 小顶堆是任意节点的值都要小于其左右子树的值），所以如果此时父结点的值比其左右子树的值都要大则不用向下比较
            }else {
                break;
            }
            //如果父结点的值比子树的值小，则完成交换后还要进行更新，并进行循环以确保交换后子树满足堆的性质
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public void shiftUp(int[] array, int size, int index) {
        //记录子树的位置
        int child = index;
        //找到父节点的位置
        int parent = (child - 1) / 2;
        //由于是向上调整，子树可能会因为更新而寻找到根结点
        while(child > 0) {
            //此时不需要再进行左右子树值的比较，因为一般用于插入操作，所以只需对新增节点进行判断，而之前的节点已经排好序
            //只比较父结点和当前子树的值
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
}
