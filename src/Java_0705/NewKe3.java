package Java_0705;


import java.util.Scanner;

public class NewKe3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String strs = scanner.nextLine();
            char[] ch = strs.toCharArray();
            for(int i = 0; i < ch.length; i++) {
                if(ch[i] != ' '){
                    //如果字符大于E,则可以直接-5拿到相应字符
                    //如果字符小于E,直接-5得到的数是不可知的,但是可以+21拿到对应的数字.
                    ch[i] = (char)(ch[i] > 'E' ? ch[i] - 5 : ch[i] + 21);
                }
            }
            System.out.println(new String(ch));
        }
    }
}
