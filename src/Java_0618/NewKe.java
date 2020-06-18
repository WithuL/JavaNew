package Java_0618;
import java.util.Scanner;

public class NewKe {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int asd=sc.nextInt();
        while(asd>0){
            int aaa=sc.nextInt();
            int bbb=sc.nextInt();
            int []arr=new int[2*aaa];
            for(int i=0;i<2*aaa;i++){
                arr[i]=sc.nextInt();
            }
            for(int j=0;j<bbb;j++){
                int []tmp=new int[2*aaa];
                for(int i=0;i<2*aaa;i++){tmp[i]=arr[i];}
                for(int i=0;i<2*aaa;i++){
                    if(i%2==0){arr[2*aaa-1-i]=tmp[2*aaa-1-i/2];}
                    else{arr[2*aaa-1-i]=tmp[aaa-(i+1)/2];}
                }
            }
            for(int i=0;i<2*aaa-1;i++){
                System.out.print(arr[i]+" ");}
            System.out.print(arr[2*aaa-1]);
            System.out.println();
            asd--;
        }
    }
}
