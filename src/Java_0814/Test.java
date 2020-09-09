package Java_0814;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Test {
    public static void main(String[] args) {
        int n = 1000 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
    }
}
