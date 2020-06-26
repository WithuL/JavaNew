package Java_0626;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket ;

    public TcpEchoClient(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
    }

    public void start() {
        System.out.println("客户端启动");
        Scanner sc = new Scanner(System.in);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            while(true) {
                System.out.println(">");
                String request = sc.nextLine();
                bufferedWriter.write(request+"\n");
                bufferedWriter.flush();
                String response = bufferedReader.readLine();
                System.out.println(response);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
