package Java_0729;

public class MergeSort {
    public void mergerSort(int[] arr) {
        mergerSortHelper(arr, 0 , arr.length);
    }

    private void mergerSortHelper(int[] arr, int left, int right) {
        if(right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergerSortHelper(arr, left,mid);
        mergerSortHelper(arr, mid, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left];
        int i = 0;
        int cur1 = left;
        int cur2 = mid;
        while(cur1 < mid && cur2 < right) {
            if(arr[cur1] < arr[cur2]) {
                tmp[i++] = arr[cur1];
                cur1++;
            }else {
                tmp[i++] = arr[cur2];
                cur2++;
            }
        }
        while(cur1 < mid) {
            tmp[i++] = arr[cur1];
            cur1++;
        }
        while(cur2 < right) {
            tmp[i++] = arr[cur2];
            cur2++;
        }
        for(int j = 0; j < tmp.length; j++) {
            arr[left + j] = tmp[j];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {9,5,2,7,3,6,8};
        mergeSort.mergerSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
