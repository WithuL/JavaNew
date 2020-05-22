package Java_0508;

public class BubbleSort {
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
    private static void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }
}
