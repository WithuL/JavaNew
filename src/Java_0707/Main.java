package Java_0707;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weath = {29*17, 29 , 1};
        String[] pay = sc.next().split("\\.");
        String[] give = sc.next().split("\\.");
        int[] pays = {Integer.parseInt(pay[0]), Integer.parseInt(pay[1]), Integer.parseInt(pay[2])};
        int[] gives = {Integer.parseInt(give[0]), Integer.parseInt(give[1]), Integer.parseInt(give[2])};
        int payKnut = pays[0] * weath[0] + pays[1] * weath[1] + pays[2] * weath[2];
        int givesKnut = gives[0] * weath[0] + gives[1] * weath[1] + gives[2] * weath[2];
        int diff = givesKnut - payKnut;
        if(diff < 0) {
            System.out.print("-");
            diff *= -1;
        }
        System.out.println(diff / weath[0] + "." + diff % weath[0]/weath[1] + "." + diff % weath[0] % weath[1] / weath[2]);
    }
}