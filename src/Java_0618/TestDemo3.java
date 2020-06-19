package Java_0618;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestDemo3 {
    public static void main(String[] args) throws IOException {
        //一次性写一个数组
        FileOutputStream outputStream = new FileOutputStream("e:/BaiduNetdiskDownload/test3.txt");
        String string = "Hello Mars";
        byte[] bytes = string.getBytes();
        outputStream.write(bytes);
        outputStream.close();
    }
}
