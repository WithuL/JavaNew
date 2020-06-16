package Java_0616;

import java.util.Scanner;

public class NewKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(help(n));
        }
    }

    public static String help(int tmp){
        int mid = 0;
        int beg = 0;
        String res = "";
        mid = tmp*tmp;
        beg = mid-tmp+1;
        for(int i=0;i<tmp;i++){
            res+=beg+2*i;
            if(i!=tmp-1){
                res+="+";
            }
        }
        return res;
    }
}
