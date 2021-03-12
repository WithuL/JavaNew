package Java_0508;


//希尔排序的基本思想： 把一个较长的数组分成数量较少的几个组，针对每个组进行插入排序，以此增加排序效率，分组排序完成后对最后一个组进行排序，效率更高。
//时间复杂度o(n^1.3) 空间复杂度o1; 不稳定排序
/*
    默认把一个组分成数组元素的一半，即最开始是两个数进行插入排序,此时分的组数就是gap
    分完组后的数据，每隔一个组数的元素属于同一组，比如有8个数据，第一次分了4组，那么1和5是一组，2.6  3.7  4.8
    针对每次分组进行一次插入排序，这里bound = gap,就相当于普通的插入排序时分组为1  gap = 1，bouund = 1,
    在这里bound每次取的是每组的第2个元素，然后cur = bound - gap是每组的第一个元素位置，然后进行组内的排序
    然后每排完一次序就让gap再等于原来的一半，再次进行排序，直到gap <= 1
    gap = 1 以后再让
 */

public class ShellSort {
    //希尔排序
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while(gap > 1) {
            inserSortGap(arr,gap);
            gap = gap / 2;
        }
        inserSortGap(arr,1);
    }

    private static void inserSortGap(int[] arr, int gap) {
        for(int bound = gap; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - gap;
            for(;cur >= 0; cur -= gap) {
                if(arr[cur] > tmp) {
                    arr[cur + gap] = arr[cur];
                }else{
                    break;
                }
            }
            arr[cur + gap] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        shellSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
