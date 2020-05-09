package Java_0508;

import java.util.Arrays;

public class Sort {
    //插入排序
    private static void inserSort(int[] arr) {
        //[0,bound)为已排序区间
        //[bound,array.length)为未排序区间
        for(int bound = 1; bound < arr.length; bound++) {
            //先记录边界元素
            int tmp = arr[bound];
            //找到已排序元素的最后一个位置
            int cur = bound - 1;
            //开始比较
            for(;cur >=0 ; cur--) {
                //如果排序的大于后面的则进行替换
                if(arr[cur] > tmp) {
                    arr[cur+1] = arr[cur];
                }else{
                    break;
                }
            }
            //替换cur+1处的元素为tmp
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
            //此时已经借助bound把数组分成两个取件了
            //[0,bound)是已排序区间
            //[bound,arr.length)是未排序区间
            //接下来就是要在未排序区间找到最小值，并放到bound位置上。
            for(int cur = bound; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    //以bound位置为基准
                    //拿后面的元素跟bound比较
                    //如果后面元素小于bound位置，则替换bound位置的元素
                    swap(arr,cur,bound);
                }
            }
        }
    }
    //交换方法
    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }

    //堆排序
    private static void heapSort(int[] array) {
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

//    冒泡排序
    public static void bubbleSort(int[] array) {
        //从后往前遍历，每次找到最小的元素放到前面
        //[0,bound)已排序区间
        //[bound,array.length)未排序区间
        for(int bound = 0 ; bound < array.length; bound++) {
            //接下来就找未排序区间的最小值
            //找法就是比较相邻元素，看是否符升序要求，如果不符合就交换元素
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
        //如果区间内没有元素或者只有一个元素的时候就结束
        if(left >= right) {
            return;
        }
        //index记录基准值经过一次操作后最后的调整到的位置
        int index = partition(array,left,right);
        //对左边区间进行快排
        quickSortHelper(array,left,index-1);
        //对右边区间进行快排
        quickSortHelper(array,index,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        //基准值就为 最后一个元素
        while(i < j) {
            //从左侧找到大于基准值的元素（的位置）
            while(i < j && array[i] < array[right]) {
                i += 1;
            }
            //从右侧找到小于基准值的元素（的位置）
            while(i > j && array[j] > array[right]) {
                j -= 1;
            }
            swap(array,i,j);
        }
        //最后交换i位置和末尾元素
        swap(array,i,right);
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,5,4,0,6,9,7,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
