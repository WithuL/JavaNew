package Java_0717;
import java.util.Scanner;
public class GongG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            String tmp = sc.nextLine();
            char[] arr = str.toCharArray();
            for(int i = 0; i < str.length(); i++) {
                if(!tmp.contains(String.valueOf(arr[i]))) {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }
    }
}
