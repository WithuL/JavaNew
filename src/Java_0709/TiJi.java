package Java_0709;

import java.util.Scanner;

public class TiJi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextDouble()) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double z = sc.nextDouble();
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            System.out.printf("%.3f ",getR(x,y,z,a,b,c));;
            System.out.printf("%.3f\n", getV(x,y,z,a,b,c));;
        }
     }

    private static double getR(double a, double b, double c, double e, double f, double g) {
        return Math.sqrt((double)(a-e)*(a-e)+(b-f)*(b-f)+(c-g)*(c-g));
    }

    private static double getV(double x, double y, double z, double a, double b, double c) {
        return 4*Math.acos(-1)*(Math.pow(getR(x,y,z,a,b,c), 3))/3;
    }
}
