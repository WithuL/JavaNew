package Java_0915;

public class LeetCode {
//    class Node {
//        int val;
//        Node next;
//        public Node(int val){
//            this.val = val;
//        }
//    }
//    Node root = null;
//    Node tail = null;
//    int size = 0;
//    public void addFirst(int val) {
//        Node node = new Node(val);
//        if(size == 0) {
//            root = node;
//            tail = node;
//        }else {
//            node.next = root;
//            root = node;
//        }
//        size++;
//    }

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }
    public static void quickSortHelper(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        quickSortHelper(arr, left, index);
        quickSortHelper(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        while(l < r) {
            while(l < r && arr[l] <= arr[right]) {
                l++;
            }
            while(l < r && arr[r] >= arr[right]) {
                r--;
            }
            swap(arr, l , r);
        }
        swap(arr,l , right);
        return l;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
