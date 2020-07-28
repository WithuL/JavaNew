package Java_0728;

public class MyStack {
    private int[] arr = new int[5];
    private int size = 0;

    public void push(int val) {
        if(size == arr.length) {
            kuorong();
        }
        arr[size++] = val;
    }

    public int pop() {
        if(size == 0) {
            return -1;
        }
        return arr[--size];
    }

    public int peek() {
        if(size == 0) {
            return -1;
        }
        return arr[size -1];
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void kuorong() {
        int[] tmp = new int[arr.length * 2];
        System.arraycopy(arr,0,tmp,0,arr.length);
        arr = tmp;
    }
}
