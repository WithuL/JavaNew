package Java_0629.Test2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    private ServerSocket serverSocket;

    public HttpServerV3(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executor = Executors.newCachedThreadPool();
        while(true) {
            Socket clientSocket = serverSocket.accept();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });

        }
    }

    private void process(Socket clientSocket) {
        try{
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            if("GET".equalsIgnoreCase(request.getMethod())) {
                doGet(request, response);
            } else if("POST".equalsIgnoreCase(request.getMethod())) {
                doPost(request, response);
            } else {
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        if(request.getUrl().startsWith("/index.html")) {
            InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while((line = bufferedReader.readLine()) != null ) {
                response.writeBody(line+"\n");
            }
            bufferedReader.close();
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if(request.getUrl().startsWith("/login")) {
            String userName = request.getParameters("username");
            String passWord = request.getParameters("password");
            System.out.println("userName:" + userName);
            System.out.println("passWord:" + passWord);

        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 httpServerV3 = new HttpServerV3(9090);
        httpServerV3.start();
    }
}
