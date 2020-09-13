package Java_0913;

public class LeetCode {
    public static void main(String[] args) {
        for(int i = 2;i <= 100; i++) {
            if(isHeshu(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isHeshu(int i) {
        for(int j = 2; j < Math.sqrt(i); j++) {
            if(i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
