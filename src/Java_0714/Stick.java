package Java_0714;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Stick {
    static long max = 0;
    static long len = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            List<Long> sticks = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                long val = sc.nextInt();
                if(tmp == 1) {
                    if(val > max) {
                        max = val;
                    }
                    len += val;
                    sticks.add(val);
                    judege(sticks);
                }else{
                    delete(sticks, val);
                }
            }
        }
    }

    public static void judege(List<Long> sticks) {
        if((len - max) > max && sticks.size() >= 3) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static void delete(List<Long> sticks, long val) {
        int index = sticks.indexOf(val);
        sticks.remove(index);
        Collections.sort(sticks);
        len -= val;
        max = sticks.get(sticks.size()-1);
        judege(sticks);
    }
}
