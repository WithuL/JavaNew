package Java_0703;

public class NewKe4 {
    public static void main(String[] args) {
        long sumRich = 0;
        long sumStranger = 0;
        for(int i =0; i < 30; i++) {
            sumRich += 10;
            sumStranger = sumStranger + (long)Math.pow(2,i);
        }
        System.out.println(sumRich +","+sumStranger);
    }
}
