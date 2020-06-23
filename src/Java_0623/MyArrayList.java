package Java_0623;

import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private static final int DEFAULT_SIZE = 10;
    private int usedSize = 0;

    public MyArrayList() {
        elem = new int[DEFAULT_SIZE];
    }

    public boolean isFull( ) {
        if(this.usedSize == elem.length ) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(this.usedSize == 0) {
            return true;
        }
        return false;
    }

    public boolean check(int index) {
        if(index < 0 || index  >= elem.length) {
            return false;
        }
        return true;
    }

    public void grow() {
        Arrays.copyOf(elem, elem.length * 2);
    }

    public int serach(int key) {
        for(int i = 0; i < this.usedSize ; i++) {
            if(key == elem[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int key) {
        for(int i = 0; i < this.usedSize; i++) {
            if(key == elem[i]) {
                return true;
            }
        }
        return false;
    }

    public int getPos(int pos) {
        if(!check(pos)) {
            return -1;
        }
        return elem[pos];
    }


    public void add(int key) {
        if(isFull()) {
            grow();
        }
        elem[this.usedSize] = key;
        this.usedSize++;
    }

    public void add(int index, int key) {
        if(isFull()) {
            grow();
        }
        for(int i = this.usedSize - 1; i >= index; i--) {
            elem[i+1] = elem[i];
        }
        elem[index] = key;
        this.usedSize++;
    }

    public void remove(int key) {
        if(!contains(key)) {
            return;
        }
        int t = serach(key);
        for(int i = t; i <this.usedSize-1; i++ ) {
            elem[i] = elem[i+1];
        }
        this.usedSize--;
    }
 }
