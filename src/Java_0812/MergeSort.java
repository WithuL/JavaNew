package Java_0812;

public class MergeSort {
    public void mergeSort(int[] arr) {
        mergetSortHelp(arr, 0, arr.length);
    }

    private void mergetSortHelp(int[] arr, int left, int right) {
        if(right - left == 1) {
            return ;
        }
        int mid = (left + right) / 2;
        mergetSortHelp(arr, left, mid);
        mergetSortHelp(arr, mid, right);
        merge(arr, left, mid ,right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] our = new int[right- left];
        int k = 0;
        int cur1 = left;
        int cur2 = mid;
        while(cur1 < mid && cur2 < right) {
            if(arr[cur1] < arr[cur2]) {
                our[k++] = arr[cur1++];
            }else{
                our[k++] = arr[cur2++];
            }
        }
        while(cur1 < mid) {
            our[k++] = arr[cur1++];
        }
        while(cur2 < right) {
            our[k++] = arr[cur2++];
        }
        k = 0;
        while(k < our.length) {
            arr[left + k] = our[k++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {9,5,2,7,3,6,8};
        mergeSort.mergeSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
