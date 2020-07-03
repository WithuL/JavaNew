package Java_0703;

public class Heap {
    int[] arr;
    int size = 0;
    public Heap() {
        arr = new int[20];
    }
    public void createHeap() {
        for(int i = (arr.length - 1 -1 ) / 2; i >= 0; i--) {
            shiftDown(arr, size, i);
        }
    }
    public void offer(int x) {
        arr[size++] = x;
    }
    public Integer poll() {
        if(isEmpty()) {
            return null;
        }
        int res = arr[0];
        arr[0] = arr[--size];
        shiftDown(arr, size, 0);
        return res;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
    public void shiftDown(int[] arr, int size, int index) {
        int paraent = index;
        int child = paraent*2 +1;
        while(child < size) {
            if(child + 1 < size && arr[child +1 ] > arr[child]) {
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
            child = paraent * 2 + 1;
        }
    }
    public void shiftUp(int[] arr, int size, int index) {
        int child = index;
        int paraent = (child - 1) / 2;
        while(child > 0) {
            if(arr[child] > arr[paraent]) {
                int tmp = arr[child];
                arr[child] = arr[paraent];
                arr[paraent] = tmp;
            }else {
                break;
            }
            child = paraent;
            paraent = (child - 1) / 2;
        }
    }
}
