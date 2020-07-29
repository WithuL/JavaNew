package Java_0729;

import Java_0703.Heap;

public class HeapSort {
    //堆排序
    public void heapSort(int[] arr) {
        createHeap(arr);
        int heapSize = arr.length;
        for(int i = 0; i < arr.length - 1;i++) {
            //交换队首队尾
            int tmp = arr[0];
            arr[0] = arr[heapSize -1];
            arr[heapSize-1] = tmp;
            //
            heapSize--;
            shiftDown(arr, heapSize, 0);

        }
    }

    private void createHeap(int[] arr) {
        for(int i = (arr.length - 1 -1 )/ 2; i >= 0; i--) {
            shiftDown(arr, arr.length , i);
        }
    }

    private void shiftDown(int[] arr, int size, int i) {
        int parent = i;
        int child = parent * 2+ 1;
        while(child < size) {
            if(child + 1 < size && arr[child+1] > arr[child]) {
                child++;
            }
            if(arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = parent * 2 +1;
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {9,5,2,7,3,6,8};
        heapSort.heapSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
