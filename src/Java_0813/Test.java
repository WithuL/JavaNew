package Java_0813;

class T1 {
    int val;
    T2 next;
}
class T2 {
    int val;
}

public class Test {
    public static void main(String[] args) {
        T1 a = new T1();
        a.val = 10;
        a.next = new T2();
        a.next.val = 10;

        T1 b = new T1();
        b.val = a.val;
        b.next = a.next;



        System.out.println(a);
        System.out.println(b);
    }
}
