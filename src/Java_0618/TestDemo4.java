package Java_0618;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDemo4 {
    //一次性读一个数组
    public static void main(String[] args) throws IOException {
        File file = new File("e:/BaiduNetdiskDownload/test.txt");//创建对象描述文件
        FileInputStream fileInputStream = new FileInputStream("e:/BaiduNetdiskDownload/test.txt");//创建一个字节输入流对象
        //每次只读一个字节,如果没读完就返回下一个数据字节,如果读完了就返回-1,读完了就退出循环
        byte[] bytes = new byte[1024];//根据文件大小来创建数组
        StringBuffer sb = new StringBuffer();
        int len = -1;
        while((len = fileInputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len));
        }
        fileInputStream.close();
    }
}
