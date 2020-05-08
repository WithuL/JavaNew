package Java_0508;

import java.util.Arrays;

public class Sort {
    //插入排序
    private static void inserSort(int[] arr) {
        for(int bound = 1; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - 1;
            for(;cur >=0 ; cur--) {
                if(arr[cur] > tmp) {
                    arr[cur+1] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur+1]  = tmp;
        }
    }
    //希尔排序
    private static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            inserSortGap(arr,gap);
            gap = gap / 2;
        }
        inserSortGap(arr,1);
    }

    private static void inserSortGap(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - gap;
            for(;cur >= 0; cur -= gap) {
                if(arr[cur] > tmp) {
                    arr[cur + gap] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur + gap] = tmp;
        }
    }

    //选择排序
    private static void selectSort(int[] arr) {
        for(int bound = 0; bound < arr.length ; bound++) {
            for(int cur = bound; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    swap(arr,cur,bound);
                }
            }
        }
    }

    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }


//    堆排序
    public static void heapSort(int[] arr) {
        creatHeap(arr);
        int heapSize = arr.length;
        //在进入这个循环前就已经是一个大顶堆了，因此
        for(int i = 0; i < arr.length -1; i++) {
            swap(arr,0,heapSize -1) ;
//            因此交换完堆顶和堆尾元素之后最后一个元素就是最大的，第一小部分排序完成，直接size--，步让最后一个元素参与向下调整
            heapSize--;
//            向下调整是为了为下次将最大元素调整到队尾做准备，把堆调整好。
            shiftDown(arr,heapSize,0);
        }
    }

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

//    冒泡排序
    public static void bubbleSort(int[] array) {
        for(int bound = 0 ; bound < array.length; bound++) {
            for(int cur = array.length - 1 ; cur > bound; cur--) {
                if(array[cur - 1] > array[cur]) {
                    swap(array,cur - 1,cur);
                }
            }
        }
    }

//    快速排序
    private static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        while(i < j) {
            while(i < j && array[i] < array[right]) {
                i += 1;
            }
            while(i > j && array[j] > array[right]) {
                j -= 1;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,5,4,0,6,9,7,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
