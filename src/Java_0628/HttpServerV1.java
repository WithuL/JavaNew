package Java_0628;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while(true) {
            Socket socketClient = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(socketClient);
                }
            });
        }
    }

    private void process(Socket socketClient) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()))) {
            String firstLine = bufferedReader.readLine();
            String[] firstLineToken = firstLine.split(" ");
            String method = firstLineToken[0];
            String url = firstLineToken[1];
            String version = firstLineToken[2];
            Map<String, String> headers = new HashMap<>();
            String line = "";
            while((line = bufferedReader.readLine()) != null && line.length() != 0) {
                String[] headerTokens = line.split(": ");
                headers.put(headerTokens[0], headerTokens[1]);
            }
            System.out.printf("%s %s %s \n",method, url, version);
            for(Map.Entry<String, String> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": "+ entry.getValue());
            }
            String resp = "<h1>hello<h1>";
            System.out.println();
            bufferedWriter.write(version + " " + "200" +" " + "ok\n");
            bufferedWriter.write("Content-Type: text/html\n");
            bufferedWriter.write("Content-Lenghth: "+ resp.getBytes().length + "\n");
            bufferedWriter.write("\n");
            bufferedWriter.write("<h1>hello<h1>");
            bufferedWriter.flush();
        } catch(IOException e) {
            System.out.println("客户端退出");
        } finally {
            try{
                socketClient.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV1 httpServerV1 = new HttpServerV1(9090);
        httpServerV1.start();
    }
}
