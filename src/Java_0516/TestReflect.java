package Java_0516;

//创建一个Cat类辅助我们理解反射
class Cat{
    private String name;

    private void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }

    public Cat(String name) {
        this.name = name;
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类对象，获取到Cat类的说明书
        //第一种获取方式是最灵活的，写代码是不需要知道类名，在实际运行时再获取类名。
        //后面两种是写代码时就要知道类名
        // 1.直接通过全限定类名获取        *包名.类型 *
        // 这里的参数是一个字符串,意味着这是需要运行时获取的
        //这样的内容可能是代码写死的，也可能是用户输入的，也可能是从文件读到的，也可能是从网络上获取的
        Class catClass = Class.forName("Java_0516.Cat");
        //2.通过类的实例来获取
        Cat cat = new Cat("咪咪");
        Class catClass2 = cat.getClass();
        //3.通过类来直接获取
        Class catClass3 = Cat.class;
        System.out.print(catClass == catClass2);
        System.out.print(catClass2 == catClass3);
        //输出true true;
        //说明上面三个（catClass...）是同一个类对象，也就说明类对象是一个单例，只有一个实例
        //“==” 代表比较像等，在比较身份。
    }
}
