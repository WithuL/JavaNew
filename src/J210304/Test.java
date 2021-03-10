package J210304;

public class Test{
    public static void main(String[] args){
        Women women = new Women("yj");
        System.out.println(women.name);
        women.run();
    }
}
class Man{
    String name;
    public Man(String name){
        this.name = name;
    }
    public void run(){
        System.out.println(name + "可以奔跑");
    }
}

class Women extends Man{
    public Women(String name) {
        super(name);
    }
    @Override
    public void run(){
        System.out.println(name + "在化妆");
    }
}

