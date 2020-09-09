package Java_0908;

public class NewKe {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(dig(n));
    }
    public static int dig(int n) {
        if(n == 1) {
            return 1;
        }
        return dig(n-1) * n;
    }
}
