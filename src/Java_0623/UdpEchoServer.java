package Java_0623;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
public class UdpEchoServer {
    private DatagramSocket socket;

    public UdpEchoServer(int port) throws SocketException {
         socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength()).trim();
            String respond = process(request);
            DatagramPacket respondPacket = new DatagramPacket(respond.getBytes(), respond.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(respondPacket);
            System.out.printf("[%s:%d] req : %s; resp: %s \n",requestPacket.getAddress(), requestPacket.getPort(),
                    request,respond
            );

        }
    }
    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException, SocketException{
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
