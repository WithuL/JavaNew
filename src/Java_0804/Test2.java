package Java_0804;

public class Test2 {
    public void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0 ,arr.length);
    }
    public void mergeSortHelper(int[] arr, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid, right);
        merge(arr,left , mid,right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-mid];
        int k = 0;
        int curL = left;
        int curR = mid;
        while(curL < mid && curR < right) {
            if(arr[curL] <= arr[curR]) {
                tmp[k++] = arr[curL++];
            }else {
                tmp[k++] = arr[curR++];
            }
        }
        while(curL < mid) {
            tmp[k++] = arr[curL++];
        }
        while(curR < right) {
            tmp[k++] = arr[curR++];
        }
        for(int i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
    }


}
