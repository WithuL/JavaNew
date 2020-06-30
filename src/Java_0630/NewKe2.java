package Java_0630;
import java.util.*;
public class NewKe2 {
    static String[] daxie = {"壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String n = sc.next();
            help(n);
        }
        sc.close();
    }
    public static void help(String str){
        String[] strs = str.split("\\.");
        int val = Integer.valueOf(str.split("\\.")[0]);
        StringBuffer res = new StringBuffer("人民币");
        int y = (int)(val/100000000);
        if(y!=0){
            res.append(resolveQian(y)).append("亿");
            val = val-y*100000000;
        }
        int w = (int)(val/10000);
        if(w!=0){
            res.append(resolveQian(w)).append("万");
            val = val-w*10000;
        }
        String asd = resolveQian(val);
        if(asd.length()>1){
            res.append(asd).append("元");
        }

        if(strs.length>1){
            String afterPointStr = strs[1];
            res.append(handleNumberAfterPoint(afterPointStr));
        }
        String sasd = res.toString();
        if(sasd.length()>4 && sasd.charAt(3)=='零' && sasd.charAt(4)!='元'){
            sasd = sasd.substring(0,3)+sasd.substring(4);
        }
        System.out.println(sasd);
    }
    public static String resolveQian(double temp){
        StringBuffer kok = new StringBuffer();
        int money = (int)(temp/1000);
        if(money!=0){
            kok.append(daxie[money-1]).append("仟");
            temp = temp-money*1000;
        }
        int bai = (int)(temp/100);
        if(bai!=0){
            kok.append(daxie[bai-1]).append("佰");
            temp = temp-bai*100;
        }
        if(money!=0 && bai==0){
            kok.append("零");
        }
        int shi = (int)(temp/10);
        if(shi!=0){
            if(shi!=1){
                kok.append(daxie[shi-1]);
            }
            kok.append("拾");
            temp = temp-shi*10;
        }
        if(bai!=0&&shi==0){
            kok.append("零");
        }
        int ge = (int)(temp%10);
        if(ge!=0){
            if(money==0&&bai==0&&shi==0){
                kok.append("零");
            }
            kok.append(daxie[ge-1]);
        }
        String res = kok.toString();
        return res;
    }
    public static String handleNumberAfterPoint(String str){
        String res = "";
        if(str.equals("00") ||str.equals("0")){
            res = "整";
        }else{
            if(str.charAt(0)!='0'){
                res += daxie[Integer.valueOf(str.charAt(0)+"")-1]+"角";
            }
            if(str.length()>1 && str.charAt(1)!='0'){
                res += daxie[Integer.valueOf(str.charAt(1)+"")-1]+"分";
            }
        }
        return res;
    }
}
