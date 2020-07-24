package Java_0724;
import java.util.*;
public class NewKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            stickHelp(arr);
        }
    }

    private static void stickHelp(int[][] arr) {
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][0] == 1) {
                tmp.add(arr[i][1]);
            }else {
                tmp.remove(new Integer(arr[i][1]));
            }
            judege(tmp);
        }
    }

    private static void judege(List<Integer> tmp) {
        if(tmp.size() <= 2) {
            System.out.println("No");
            return;
        }
        int maxLen = 0, sum = 0;
        for(int x : tmp) {
            if(x > maxLen ) {
                maxLen = x;
            }
            sum += x;
        }
        if(sum - maxLen > maxLen) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
