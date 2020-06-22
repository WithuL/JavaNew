package Java_0622;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    // 对于一个服务器程序来说, 核心流程也是要分成两步.
    // 1. 进行初始化操作 (实例化 Socket 对象)
    // 2. 进入主循环, 接受并处理请求. (主循环就是一个 "死循环")
    //   a) 读取数据并解析
    //   b) 根据请求计算响应
    //   c) 把响应结果写回到客户端.
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        //new这个Socket对象的时候,就会让当前的socket对象和一个ip地址和一个端口号进行绑定
        //未来客户端就按照这个ip+端口来访问服务器
        //如果在socket的时候没有写ip地址,那么默认的ip地址就是0.0.0.0(特殊ip,表示会关联到这个主机的所有网卡的ip,一个主机可能会有多个网卡)
        socket = new DatagramSocket(port);
        //socket本质上是一个文件,这个文件是网卡的抽象
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            // a) 读取请求并解析.
            //DatagramPacket是UDPSocket发送接收数据的基本单位
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            //程序启动之后,马上就能执行到receive操作
            //服务器启动了之后,此时客户端不一定发送了请求
            //所以调用reveive时,客户端可能还没发数据
            //此时receiver操作就会阻塞,一直阻塞到真的有数据过来了为止.
            //当真的有客户端的数据过来了之后,此时receiver就会把收到的数据放到DatagramPacket对象的缓冲区中
            socket.receive(requestPacket);
            //此处是要把请求数据转成一个String(本来请求是一个byte数组,经过new String后转成string,使用trim 方法是因为
            // 用户输入的数据可能远远小于4096,而此处的getLength的带的长度就是4096,通过trim可以删除不必要的空白符)
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength()).trim();
            // b) 根据请求计算响应
            String response = process(request);
            // c) 把响应写回给客户端, 响应数据就是 response, 需要包装成一个 Packet 对象
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            //↑这个最后一个参数就代表这个包要发给谁,此处的address地址就是客户端的地址和端口,这两个信息已经包含在requestPacket内部了;
            socket.send(responsePacket);

            // [这是一个锦上添花的操作] 打印一条请求日志.
            System.out.printf("[%s:%d] req: %s; resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    public String process(String request) {
        // 由于此处是一个 echo server, 请求内容是啥, 响应内容就是啥.
        // 如果是一个更复杂的服务器, 此处就需要包含很多的业务逻辑来进行具体的计算.
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
