package Java_0508;
/* 堆排序的基本思想
把数组建一个大堆，然后根节点都是最大的那个值，排完以后把堆顶元素和堆尾元素互换，然后把堆尾元素删除，
再从堆顶来向下调整，再构建一个大堆，以此往复排出升序。
 */

/* 建大堆
从最后一个非叶子节点开始，往下调整，遇到比根节点小的进行交换，然后更新，继续向下调整，依次循环，从右
到左，从下到上每个非叶子节点都进行这样的调整，最终建立一个大堆
 */

/*
然后进行互换，把堆顶元素和堆尾元素进行互换，让最大的那个数移动到数组的末尾处，然后删除队尾元素，再从
堆顶进行向下调整
 */
public class HeapSort {
    //堆排序
    public static void heapSort(int[] array) {
        creatHeap(array);
        //创建一个大堆
        int heapSize = array.length;
        //记录此时堆的大小
        for(int i = 0; i < array.length - 1; i++) {
            swap(array,0,heapSize-1);
            //交换堆首和堆尾元素
            heapSize--;
            //调整堆的大小，让最后一个元素不再参与排序
            shiftDown(array,heapSize,0);
            //调整堆的结构让其符合大堆
        }
    }
    //以下为堆的基本操作不再做讲述，前期博客有记录
    private static void creatHeap(int[] arr) {
        for(int i = (arr.length - 1 - 1 ) / 2; i >= 0 ; i-- ) {
            shiftDown(arr,arr.length,i);
        }
    }

    private static void shiftDown(int[] arr, int size, int i) {
        int parent = i;
        int child = i * 2 + 1;
        while(child < size) {
            if(child + 1 < size && arr[child + 1] > arr[child]) {
                child += 1;
            }
            if(arr[child] > arr[parent]) {
                swap(arr,child,parent);
            }else{
                break;
            }
            parent = child;
            child = parent * 2 +1;
        }
    }
    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }
}
