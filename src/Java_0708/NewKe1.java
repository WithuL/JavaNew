package Java_0708;

import java.util.*;

public class NewKe1 {
    static class  Lei {
        int y ;
        int p ;
        int s ;
        Map<String, Integer> map= new LinkedHashMap<>();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];
            Lei al = new Lei();
            Lei bl = new Lei();
            for(int i = 0; i < n; i++) {
                a[i] = sc.next();
                b[i] = sc.next();
                helper(a[i],b[i], al, bl);
            }
            List<String> ar = new LinkedList<>(al.map.keySet());
            List<String> br = new LinkedList<>(bl.map.keySet());
            Collections.sort(ar, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int i = (int) al.map.get(o1);
                    int b = (int) al.map.get(o2);
                    if( i != b) {
                        return b - i;
                    }else {
                        return o1.compareTo(o2);
                    }
                }
            });
            Collections.sort(br, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int i = (int) bl.map.get(o1);
                    int b = (int) bl.map.get(o2);
                    if (i != b) {
                        return b - i;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            });
            System.out.println(al.y + " "+al.p+" "+al.s);
            System.out.println(bl.y + " " + bl.p + " "+ bl.s);
            System.out.println(ar.get(0)+" "+ br.get(0));
        }
    }
    public int compare(String o1, String o2, Lei al) {
        int i = (int) al.map.get(o1);
        int b = (int) al.map.get(o2);
        if( i != b) {
            return i - b;
        }else {
            return o1.compareTo(o2);
        }
    }
    public static void helper(String a, String b,Lei al,Lei bl) {
        if(a.equals("C")) {
            if(b.equals("C")) {
                al.p += 1;
                bl.p += 1;
            }else if(b.equals("J")) {
                al.y += 1;
                bl.s += 1;
                al.map.put(a, al.map.getOrDefault(a, 0) + 1);
            }else {
                al.s += 1;
                bl.y += 1;
                bl.map.put(b, bl.map.getOrDefault(b, 0) + 1);
            }
        }else if(a.equals("J")){
            if(b.equals("C")) {
                al.s += 1;
                bl.y += 1;
                bl.map.put(b, bl.map.getOrDefault(b, 0) + 1);
            }else if(b.equals("J")) {
                al.p += 1;
                bl.p += 1;
            }else {
                al.y += 1;
                bl.s += 1;
                al.map.put(a, al.map.getOrDefault(a, 0) + 1);
            }
        }else {
            if(b.equals("C")) {
                al.y += 1;
                bl.s += 1;
                al.map.put(a, al.map.getOrDefault(a, 0) + 1);
            }else if(b.equals("J")) {
                al.s += 1;
                bl.y += 1;
                bl.map.put(b, bl.map.getOrDefault(b, 0) + 1);
            }else {
                al.p += 1;
                bl.p += 1;
            }
        }
    }
}
