package Java_0626;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread(){
                @Override
                public void run() {
                    processConnetion(clientSocket);
                }
            };
            t.start();
        }
    }

    public void processConnetion(Socket clientSocket) {
        System.out.println("客户端上线");
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            while(true) {
                String request = bufferedReader.readLine();
                String response = request;
                bufferedWriter.write(response);
                bufferedWriter.flush();
            }
        }catch(IOException e) {
            e.printStackTrace();
            System.out.println("客户端下线");
        }
    }
    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer server = new TcpThreadEchoServer(9090);
        server.start();
    }

}
