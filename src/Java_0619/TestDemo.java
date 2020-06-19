package Java_0619;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDemo {
    public static void main(String[] args) {
        copyFile2("e:/BaiduNetdiskDownload/wallpaper.jpg", "e:/BaiduNetdiskDownload/wallpaper2.jpg");
    }
    private static void copyFile(String srcPath, String destPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0, len);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileInputStream != null) {
                    fileInputStream.close();
                }
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile2(String srcPath, String destPath) {
        try(FileInputStream fileInputStream = new FileInputStream(srcPath);
            FileOutputStream fileOutputStream = new FileOutputStream(destPath)
        ){
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
