package Java_0508;

public class InserSort {
    //插入排序
    public static void inserSort(int[] arr) {
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
}
