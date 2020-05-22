package Java_0508;

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
