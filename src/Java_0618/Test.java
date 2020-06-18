package Java_0618;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/BaiduNetdiskDownload");
        listAllFiles(file);
    }
    private static void listAllFiles(File f) {
        if(f.isDirectory()) {
            File[] files = f.listFiles();
            for(File file : files) {
                listAllFiles(file);
            }
        }else {
            System.out.println(f);
        }
    }
}
