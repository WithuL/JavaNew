package Java_0508;

public class SelectSort {
    //选择排序
    public static void selectSort(int[] arr) {
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
    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }
}
