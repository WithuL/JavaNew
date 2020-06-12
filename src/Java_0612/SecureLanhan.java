package Java_0612;

class Singleton3 {
    //使用懒汉模式时,Singleton类被加载的时候,不会立刻被实例化
    //等到第一次使用这个实例的时候再实例化.
    private volatile static Singleton3 instance = null;
    private Singleton3() {
    }
    public static Singleton3 getInstance() {
        if(instance == null) {
            synchronized(Singleton3.class) {
                if(instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
public class SecureLanhan {

}


