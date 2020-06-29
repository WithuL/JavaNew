package Java_0628;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoClient {
    private Socket socket ;
    ExecutorService excutorService = Executors.newCachedThreadPool();
    public TcpEchoClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }
    public void start() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            while(true) {
                System.out.print("-> ");
                Scanner sc = new Scanner(System.in);
                String request = sc.nextLine();
                if(request.equals("exit")) {
                    break;
                }
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                String responce = bufferedReader.readLine();
                System.out.println(responce);
            }
        }catch(IOException e) {
            System.out.println("会话结束");
        }
    }

    public static void main(String[] args) throws IOException{
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}
