package Java_0630;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] credit = new int[n];
            int[] grade = new int[n];

            for(int i =0 ; i < n; i++) {
                credit[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++) {
                grade[i] = sc.nextInt();
            }

            System.out.printf("%.2f",countGrade(credit, grade));
        }
    }

    private static double countGrade(int[] credit, int[] grade) {
        double sum = 0.0;
        double allCredit = 0.0;
        for(int i = 0; i < grade.length; i++) {
            allCredit += credit[i] * help(grade[i]);
            sum += credit[i];
        }
        return allCredit / sum;
    }

    private static double help(int grade) {
        double GPA = 0.0;
        if(grade >= 90 ) {
            GPA = 4.0;
        }else if(grade >= 85 && grade <= 89) {
            GPA =  3.7;
        }else if(grade >= 82 && grade <= 84) {
            GPA =  3.3;
        }else if(grade >= 78 && grade <= 81) {
            GPA =  3.0;
        }else if(grade >=75 && grade <= 77) {
            GPA =  2.7;
        }else if(grade >= 72 && grade <= 74) {
            GPA =  2.3;
        }else if(grade >= 68 && grade<= 71) {
            GPA =  2.0;
        }else if(grade >= 64 && grade <=67) {
            GPA =  1.5;
        }else if(grade >= 60 && grade <= 63) {
            GPA =  1.0;
        }else {
            GPA =  0.0;
        }
        return GPA;
    }

}





