package Java_0809;

import Java_0703.Heap;

public class HeapSort {
    public void heapSort(int[] arr) {
        createHeap(arr);
        int heapSize = arr.length;
        for(int i = arr.length -1; i > 0; i--) {
            heapSize--;
            swap(arr,0,i);
            shiftDown(arr,0,heapSize);
        }
    }

    private void createHeap(int[] arr) {
        for(int i = (arr.length - 1 -1) /2; i >= 0; i--) {
            shiftDown(arr, i , arr.length);
        }
    }

    private void shiftDown(int[] arr, int i, int length) {
        int parent = i;
        int child = i * 2 + 1;
        while(child < length) {
            if(child + 1 < length && arr[child+1] > arr[child]) {
                child += 1;
            }
            if(arr[child] > arr[parent]) {
                swap(arr, child, parent);
            }
            parent = child;
            child = parent*2+1;
        }
    }

    private void swap(int[] arr, int child, int parent) {
        int tmp = arr[child];
        arr[child] = arr[parent];
        arr[parent] = tmp;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] res = {9,5,2,7,3,6,8};
        sort.heapSort(res);
        for(int x : res) {
            System.out.print(x+" ");
        }
    }
}
