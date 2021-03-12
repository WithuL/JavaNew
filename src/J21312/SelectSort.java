package J21312;

//时间o(n^2),空间o1,稳定排序

/*
选择排序相对于插入排序来说，他是在边界位置和未排序区间的元素一个一个去比，在未排序区间找到了比边界位置小的就放到边界位置，
然后一直比到最后的未排序元素，再向后更新边界位置。
 */
public class SelectSort {
    public static void SelectSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = bound + 1; cur < arr.length; cur++) {
                if(arr[bound] > arr[cur]) {
                    int tmp = arr[bound] ;
                    arr[bound] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }
}
