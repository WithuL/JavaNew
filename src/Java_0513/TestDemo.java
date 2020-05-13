package Java_0513;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class TestDemo {
//    旧键盘
//    1.这个问题需要自己手动处理输入输出，并且方法是main方法，类名是Main
//    2.因为大写字母小写字母都只对应一个键
//    3.所以检测到同一字母大小写不同时只打印一次
//    4.因此可以将实际输入和理论输入都转换成大写字母
//    5.再将实际输入放到Set中，达到去重的操作
//    6.再创建一个brokenKey用来保存坏件
//    7.遍历理论输出
//    8.如果某字母理论输出中有而实际输出中没有，则将该字母放到brokenKey中并打印
//    9.如果该字母已在brokenKey中，那么直接跳过，进行下次循环
//    10.最后打印一个换行
    public static void Solution() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1. 处理输入, 读取输入字符串
            String expected = scanner.next();
            String actual = scanner.next();
            // 2. 把两个字符串都转成 大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 3. 把 actual 中的字符放到一个 set 中
            Set<Character> setActual = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                setActual.add(actual.charAt(i));
            }
            // 4. 遍历预期输出的字符串, 看这里的字符哪些没有在 setActual 中出现. 没出现的字符就是坏键
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (setActual.contains(c)) {
                    // 存在就不是坏键
                    continue;
                }
                // 这是一个坏键, 输出之. 但是别忘了, 坏键不需要重复输出
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }
    }
}

