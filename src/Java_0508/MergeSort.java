package Java_0508;

public class MergeSort {
    //    归并排序
    public void mergeSort(int[] array) {
//        这是归并排序的主方法，其他的都是辅助方法
//        在这只需要传入待排序的数组
//        需要一个帮助方法完成排序操作
//        此排序操作针对待排序数组，排序区间进行操作
//        排序区间为左闭右开
        mergeSortHelper(array,0,array.length);
    }

    private void mergeSortHelper(int[] array, int left, int right) {
//        如果排序区间只有一个元素或者没有元素则不需要再进行排序
        if(right - left <= 1) {
            return;
        }
//        找到中间位置
        int mid = (left + right) / 2;
//        对左区间进行排序 (左闭右开)
        mergeSortHelper(array,left,mid);
//        在对右区间进行排序
        mergeSortHelper(array,mid,right);
//        然后将左区间和右区间进行排序归并
        merge(array,left,mid,right);
    }

    private void merge(int[] array, int left, int mid, int right) {
//        那么当前有两个序列
//        [left,mid)
//        [mid,right)
//        cur1代表左侧区间元素的下标
//        cur2代表右侧区间元素的下标
        int cur1 = left;
        int cur2 = mid;
//        创建一个临时数组用来保存两个序列合并后的情况
        int[] output = new int[right - left];
//        outputIndex 为当前操作的临时数组的下标
        int outputIndex = 0;
//        当两个序列都未被遍历完时
        while(cur1 < mid && cur2 < right){
//            如果左侧区间操作的数据小于等于右侧区间操作的数据
//            则将左侧区间的数据存入临时数组
            if(array[cur1] <= array[cur2]){
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            }else{
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
//        如果上面的循环结束左侧区间还有剩余元素，则全部加入到临时数组
        while(cur1 < mid) {
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
//        如果不是左侧区间有余而是右侧区间有余那么就将右侧剩余数据加入到临时数组
        while(cur2 < right) {
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
//        最后将临时数组的数据复制到原数组中
        for(int i = 0; i < output.length; i++) {
//            因为传入的array是从下标 left 开始的，所以需要用i加上left
            array[i + left] = output[i];
        }
    }

}
