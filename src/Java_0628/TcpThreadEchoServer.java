package Java_0628;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while(true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread(){
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            };
            t.start();
        }
    }
    private void processConnection(Socket clientSocket) {
        System.out.printf("客户端上线: [%s:%d]", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {

            while(true) {
                String request = bufferedReader.readLine();
                String response = request;
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req:%s res:%s \n", clientSocket.getInetAddress().toString(),clientSocket.getPort(),request , response);
            }

        }catch(IOException e ) {
            System.out.println("客户端下线.");
        }
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer tcpThreadEchoServer = new TcpThreadEchoServer(9090);
        tcpThreadEchoServer.start();
    }
}
