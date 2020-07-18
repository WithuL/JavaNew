package Java_0718;

class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {
    }
    public static Singleton getInstance() {
        return instance;
    }
}

public class Test{
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
    }
}

class Singleton2 {
    private static volatile Singleton2 instance = null;
    private Singleton2() {
    }
    public  static Singleton2 getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
