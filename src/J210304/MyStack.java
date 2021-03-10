package J210304;

public class MyStack {
    private int[] arr = new int[100];
    private int size = 0;

    public boolean push(int x) {
        if(size == arr.length) {
            return false;
        }
        arr[size++] = x;
        return true;
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
        if(size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
