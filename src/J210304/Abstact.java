package J210304;

public class Abstact {
    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.fly();
        girl.run();
    }
}

interface IHunman{
    void run();
    static String name = "艾萌";
}

abstract class Birds{
    abstract void fly();
}
class Girl extends Birds implements IHunman{
    @Override
    public void fly(){
        System.out.println(name + "会飞");
    }
    @Override
    public void run(){
        System.out.println(name + "会跑");
    }

}