package Java_0826;

public class Code {
    private static void inserSort(int[] arr) {
        //直接从无序区间的第一个元素开始，bound为有序和无序区间的边界
        for(int bound = 1; bound < arr.length; bound++) {
            //先记录此时无序区间第一个位置的元素
            int tmp = arr[bound];
            //找到有序区间的最后一个位置
            int cur = bound - 1;
            //可以一直比较到有序区间的第1个元素
            for(;cur >=0 ; cur--) {
                //如果有序区间内元素大于无序区间的第一个元素
                if(arr[cur] > tmp) {
                    //那么直接进行此覆盖操作，此操作会覆盖掉无序区间的的第一个元素
                    arr[cur+1] = arr[cur];
                }else{ //如果被比较的元素小于无序区间的第一个元素，则直接break，无需再比较
                    break;
                }
            }
            //最后插入tmp
            arr[cur+1]  = tmp;
        }
    }
    private static void shellSort(int[] arr) {
        //gap一般先取数组长度的1/2，然后每排序完一次再取1/2，直到gap = 1
        int gap = arr.length / 2;
        while(gap > 1) {
            //一个帮助方法
            inserSortGap(arr,gap);
            gap = gap / 2;
        }
        //最终gap等于1时进行最后的排序
        inserSortGap(arr,1);
    }

    private static void inserSortGap(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            //记录无序区间的第一个元素
            int tmp = arr[bound];
            //记录有序区间的最后一个元素的位置
            int cur = bound - gap;
            //操作同上免得直接插入排序，但是此时cur循环时不是-1，而是- gap,每次跳过gap个元素
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

}
