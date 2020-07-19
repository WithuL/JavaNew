package Java_0719;
import java.io.File;
import java.io.IOException;
public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/FFOutput");
        listAllFiles(file);
    }
    public static void listAllFiles(File file) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File tmp : files) {
                listAllFiles(tmp);
            }
        }else {
            System.out.println(file);
        }
    }
}
