package Java_0622;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    // 1. 初始化服务器
    // 2. 进入主循环
    //   1) 先去从内核中获取到一个 TCP 的连接
    //   2) 处理这个 TCP 的连接
    //     a) 读取请求并解析
    //     b) 根据请求计算响应
    //     c) 把响应写回给客户端
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        // 这个操作和前面的 UDP 类似, 也是要绑定端口号.
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            // 1) 先从内核中获取到一个 TCP 连接
            Socket clientSocket = serverSocket.accept();
            // 2) 处理这个连接
            processConnection(clientSocket);

            //TCP的连接管理是由操作系统内核管理的
            //所谓的管理就是描述+组织
            //通过通信中的五元组进行描述(协议类型....)
            //组织就是使用一个阻塞队列来组织若干个连接对象

            //客户端和服务器建立连接的过程,完全由内核进行负责,应用程序完全感觉不到
            //当连接建立成功时,内核已经把这个连接对象放到阻塞队列中了.
            //代码中调用的accept就是从阻塞队列中取出一个连接对象(在应用程序中的化身就是socket对象)
            //后续数据读写都是针对clientSocket这个对象来进行展开的

            //如果服务器启动之后,没有客户端建立连接,此时代码调用accept就会阻塞,阻塞到真的有客户端建立连接之后

        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        // 通过 clientSocket 来和客户端交互, 先做好准备工作. 获取到 clientSocket 中的流对象
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            // 进一步的就可以完成后面的逻辑 TODO
            // 1. 读取请求并解析
            // 2. 根据请求计算响应
            // 3. 把响应写回到客户端
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
