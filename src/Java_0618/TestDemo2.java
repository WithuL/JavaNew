package Java_0618;

import java.io.*;

public class TestDemo2 {
    public static void main(String[] args) throws IOException {
        copyFile("e:/BaiduNetdiskDownload/wallpaper.jpg", "e:/BaiduNetdiskDownload/wallpaper2.jpg");
    }
    private static void  copyFile(String srcPath, String destPath) throws IOException {
        //0.先打开文件,才能够读写,(创建inputSteam/OutputStream对象的过程)
        //很多编程语言要对文件进行输入输出之前必须要先打开,java直接new相关对象就可以进行操作了
        //这是文件输入流
        FileInputStream fileInputStream = new FileInputStream(srcPath);
            //实例化这个对象的时候,可以使用字符串路径来实例化,也可以使用一个File对象来实例化,并且要处理异常
        //这是文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);

        //1.需要读取srcPath对应的文件内容
        byte[] buffer = new byte[1024];
        //单次读取的内容是存在上限的(缓存区的长度),要想把整个文件都读完,需要搭配循环来使用
        int len = -1;
        //如果读到的length时-1,说明读取结束,循环就结束了
        while((len = fileInputStream.read(buffer) )!= -1) {
            //读取成功,就把读到的内容写到另一个文件中即可
            //因为len的值不一定就是和缓冲区一样长
            //2.把读取到的内容写入到destPath对应的文件中
            fileOutputStream.write(buffer, 0, len);
        }
        //3.关闭文件
        fileInputStream.close();
        fileOutputStream.close();
    }
}
