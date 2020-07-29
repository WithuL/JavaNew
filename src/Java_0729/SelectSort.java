package Java_0729;

public class SelectSort {
    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public void selectSort(int[] arr){
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = bound; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    swap(arr, bound, cur);
                }
            }
        }
    }
//
//    public static void main(String[] args) {
//        SelectSort selectSort = new SelectSort();
//        int[] arr = {9,5,2,7,3,6,8};
//        selectSort.selectSort(arr);
//        for(int x : arr) {
//            System.out.print(x+" ");
//        }
//    }
}
