package Java_0619;

import java.io.*;

public class TestDemo2 {
    public static void main(String[] args) {
        copyFile("e:/BaiduNetdiskDownload/wallpaper.jpg", "e:/BaiduNetdiskDownload/wallpaper2.jpg");
    }
    private static void copyFile(String srcPath, String destPath) {
        //需要创建的实例时BufferedInputStream和BufferedOutputStream.
        //要创建这样的实例,要先创建FileInputStream和FileOutputStream.
        //因为BufferInputStream只能传入流对象,不能直接传入String文件
        try(FileInputStream fileInputStream = new FileInputStream(srcPath);
            FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {

            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0 , len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
