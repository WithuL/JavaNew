package Java_0612;

class Singleton1 {
    //把构造方法变成私有,此时外部就无法访问到构造方法,也就无法new这个类实例了

    private static Singleton1 instance = new Singleton1();
    private Singleton1() {
    }
    public static Singleton1 getInstance() {
        return instance;
    }
}
public class LeetCode {
    //首先创建一个表示单例的类,
    //所谓单例就是要求只能有一个实例
    //饿汉模式的饿也就是说只要类被加载就会创建实例
    public static void main(String[] args) {
    }
}

