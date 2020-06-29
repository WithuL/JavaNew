package Java_0629.Test1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV2 {
    private ServerSocket serverSocket ;

    public HttpServerV2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start () throws IOException {
        System.out.println("服务器启动!");

        ExecutorService executorService =  Executors.newCachedThreadPool();
        while(true) {
            Socket socket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(socket);
                }
            });
        }
    }

    public void process(Socket socket) {
        try{
            HttpRequest request = HttpRequest.build(socket.getInputStream());
            System.out.println("request:" + request);
            HttpResponse response = HttpResponse.build(socket.getOutputStream());
            response.setHeaders("Content-Type", "text/html");
            if(request.getUrl().startsWith("/hello")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>Help</h1>");
            }else if(request.getUrl().startsWith("/calc")) {
                String aStr = request.getParameters("a");
                String bStr = request.getParameters("b");
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int result = a+b;
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>result" + result + "</h1>");
            }else if(request.getUrl().startsWith("/cookieUser")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Set-Cookie: ","user=lcp");
                response.writeBody("<h1>set cookieUser</h1>");
            }else if(request.getUrl().startsWith("/cookieTime")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Set-Cookie", "time="+ System.currentTimeMillis() /1000);
                response.writeBody("<h1>set cookieTime</h1>");
            }else {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("defalut");
            }
            response.flush();
        } catch(IOException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV2 httpServerV2 = new HttpServerV2(9090);
        httpServerV2.start();
    }
}
