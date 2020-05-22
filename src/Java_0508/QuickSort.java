package Java_0508;

public class QuickSort {
    //    快速排序
    public static void quickSort(int[] array) {
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
    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }
}
