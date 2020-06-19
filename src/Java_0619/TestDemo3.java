package Java_0619;

import java.io.*;

public class TestDemo3 {
    public static void main(String[] args) {
        copyFile();
    }
    private static void copyFile() {
        try(FileReader fileReader = new FileReader("E:/BaiduNetdiskDownload/test.txt");
            FileWriter fileWriter = new FileWriter("E:/BaiduNetdiskDownload/test2.txt");
        ) {
            char[] buffer = new char[1024];
            int len = -1;
            while((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0 , len);
            }
        }catch (IOException e ) {

        }
    }
    private static void copyFile2() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("E:/BaiduNetdiskDownload/test.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:/BaiduNetdiskDownload/test2.txt"))
        ) {
            char[] buffer = new char[1024];
            int len = -1;
            while((len = bufferedReader.read()) != -1) {
                bufferedWriter.write(buffer, 0 , len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile3() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("E:/BaiduNetdiskDownload/test.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:/BaiduNetdiskDownload/test2.txt"))
        ) {
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

