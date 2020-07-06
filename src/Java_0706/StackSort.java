package Java_0706;

import java.util.Arrays;
import java.util.Stack;

public class StackSort {


    private static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push((array.length - 1));
        while( !stack.empty()) {
            int right = stack.pop();
            int left = stack.pop();
            if(left >= right) {
                continue;
            }
            int index = partition(array, left , right);
            stack.push(left);
            stack.push(index - 1);
            stack.push(index + 1);
            stack.push(right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int base = array[right];
        int i = left;
        int j = right;
        while( i < j ) {
            while(i < j && array[i] <= base) {
                i++;
            }
            while(i < j && array[j] >= base) {
                j--;
            }
            if(i < j) {
                swap(array, i, j);
            }
        }
        swap(array, i , right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        // quickSortByLoop(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
