package Java_0630.MyStack;

public class MyStack {
    private int[] arr = new int[100];
    private int size ;

    public boolean push(int key) {
        if(size == arr.length) {
            return false;
        }
        arr[size] = key;
        size++;
        return true;
    }

    public int pop() {
        if(size == 0) {
            return -1;
        }
        size--;
        return arr[size];
    }

    public int peek() {
        if(size == 0) {
            return -1;
        }
        return arr[size-1];
    }

    public boolean empty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
