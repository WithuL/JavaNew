package J210304;

public class selectSort {
    public void SelectSort(int[] arr) {
        for(int bound = 0; bound <arr.length; bound++ ) {
            for(int cur = bound + 1; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    swap(arr,cur,bound);
                }
            }
        }
    }

    private void swap(int[] arr, int cur, int bound) {
        int tmp = arr[cur];
        arr[cur] = arr[bound];
        arr[bound] = tmp;
    }
}
