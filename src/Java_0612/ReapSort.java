package Java_0612;

import java.util.Arrays;

public class ReapSort {
    public static void heapSort(int[] arr) {
        //1.先建立堆
        createHeap(arr);
        //记录此时对的大小
        int heapSize = arr.length;
        for(int i = 0; i < arr.length - 1; i++) {
            //2.交换堆顶元素和堆中的最后一个元素
            swap(arr, 0, heapSize - 1);
            //3.把堆中的最后一个元素逻辑上删除 (因为属于已排序就不用再参与排序了)
            heapSize--;
            //4.针对当前的堆从根节点开始向下调整
            shiftDown(arr, heapSize,0);
        }
    }

    private static void createHeap(int[] arr) {
        //从最后一个非叶子节点往前出发,从后往前遍历.依次向下调整
        for(int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
    }

    private static void shiftDown(int[] arr, int heapSize, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while(child < heapSize) {
            //当前是建立大堆,所以要找出左右子树的较大值,然后再和根节点比较
            if(child + 1 < heapSize && arr[child+1] > arr[child]) {
                child = child + 1;
            }
            //经历了这个条件之后,child是左子树还是右子树,已经不知道了,但是child一定指向其中的较大值
            if(arr[parent] < arr[child]) {
                swap(arr, parent,  child);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));;
    }
}
