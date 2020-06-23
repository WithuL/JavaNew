package Java_0623;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket;
    private String serverIp;
    private int port;

    public UdpEchoClient(String serverIp, int port) throws SocketException {
        this.socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.port = port;
    }

    public void start() throws IOException{
        System.out.println("->");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String request = sc.nextLine();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,InetAddress.getByName(serverIp), port);
            socket.send(requestPacket);
            DatagramPacket respond = new DatagramPacket(new byte[4096],4096);
            String response = new String(respond.getData(),0,respond.getLength()).trim();
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException{
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }
}
