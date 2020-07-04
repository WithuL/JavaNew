package Java_0703;

public class Sort {
    public void insertSort(int[] arr, int i) {
        for(int bound = 1; bound < arr.length ; bound++) {
            int tmp = arr[bound];
            int cur = bound -1 ;
            for(; cur >= 0; cur--) {
                if(arr[cur] > arr[bound]) {
                    arr[cur+1] = arr[cur];
                }else {
                    break;
                }
            }
            arr[cur+1] = tmp;
        }
    }

    public void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            insertSortGap(arr, gap);
            gap /= 2;
        }
        insertSort(arr, 1);
    }

    private void insertSortGap(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur -= gap) {
                if(arr[cur] > arr[bound]) {
                    arr[cur+bound] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur+bound] = tmp;
        }
    }

    public void selectSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for (int cur = bound + 1; cur < arr.length; cur++) {
                if(arr[cur] < arr[bound]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[bound];
                    arr[bound] = tmp;
                }
            }
        }
    }

    public void heapSort(int[] arr) {
        creatHeap(arr);
        int heapSize = arr.length;
        for(int i = 0; i < arr.length -1; i++) {
            swap(arr,i , heapSize -1);
            heapSize--;
            shiftDown(arr,heapSize,0);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = tmp;
    }

    private void creatHeap(int[] arr) {
        for(int paraent = (arr.length -1 -1) /2 ; paraent >= 0; paraent--) {
            shiftDown(arr, arr.length, paraent);
        }
    }

    private void shiftDown(int[] arr, int length, int index) {
        int paraent = index;
        int child = paraent * 2 + 1;
        while(child < length) {
            if(child + 1 < length && arr[child+1] > arr[child]) {
                child = child +1;
            }
            if(arr[child] > arr[paraent]) {
                int tmp = arr[child];
                arr[child] = arr[paraent];
                arr[paraent] = tmp;
            }else {
                break;
            }
            paraent = child;
            child = paraent* 2 + 1;
        }
    }

    public void bubbleSort(int[] arr) {
        for(int bound = 0; bound < arr.length; bound++) {
            for(int cur = arr.length - 1; cur > bound; cur--) {
                if(arr[cur-1] > arr[cur]) {
                    swap(arr, cur-1, cur);
                }
            }
        }
    }

}
