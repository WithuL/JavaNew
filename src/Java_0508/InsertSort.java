package Java_0508;

public class InsertSort {
    //插入排序
    public static void inserSort(int[] arr) {
        //[0,bound)为已排序区间
        //[bound,array.length)为未排序区间

        /*
            先记录边界元素
            先拿边界位置的元素（未排序区间的第一个元素tmp和排序区间的最后一个元素arr[cur]进行对比，如果发现
            最后一个排序元素大于边界元素，那么就让排序区间的元素往后移动一个位置，让arr[cur+1] = arr[cur]，
            空出来的位置留给边界元素进行插入，如果最后一个排序元素没有大于边界元素，那就说明已经排好了，直接打断。
            cur的循环结束以后，一定是因为cur--了不符合规则才进行推出，有可能是因为cur等于-1了，也有可能是arr[cur]小于tmp了,
            由于之前的比较操作让arr[cur+1] = arr[cur]，所有arr[cur]的值重复了，所以让arr[cur+1]等于tmp
        */
        //时间复杂度o^2,空间o1,稳定排序
        //数组有序时，或者数量少时排序速度快，反之则慢

        for(int bound = 1; bound < arr.length; bound++) {
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
