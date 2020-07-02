package Java_0702;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    static class User {
        public String name;
        public String school;
    }

    private ServerSocket serverSocket;
    private Map<String, User> sessions = new HashMap<>();

    public HttpServerV3(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动咯:>");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    pocess(clientSocket);
                }
            });
        }
    }

    private void pocess(Socket clientSocket) {
        try{
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build((clientSocket.getOutputStream()));
            if("GET".equalsIgnoreCase(request.getMethod())) {
                doGet(request, response);
            }else if("POST".equalsIgnoreCase(request.getMethod())) {
                doPost(request, response);
            }else {
                response.setStatus(200);
                response.setMessage("OK");
            }
            response.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) throws IOException {
        if(request.getUrl().startsWith("/index.html")) {
            String sessionId = request.getCookies("sessionId");
            User user = sessions.get(sessionId);
            if(sessionId == null || user == null) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while((line = bufferedReader.readLine() )!= null&& line.length() != 0 ) {
                    response.wirteBody(line);
                }
                bufferedReader.close();
            } else {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                response.wirteBody("<html>");
                response.wirteBody("<div>欢迎回来,"+user.name+"哥哥</div>");
                response.wirteBody("</html>");
            }
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if(request.getUrl().startsWith("/login")) {
            String userName = request.getParameters("username");
            String passWord = request.getHeaders("password");
            if(userName.equals("lcp") && passWord.equals("153")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                String sessionId = UUID.randomUUID().toString();
                User user = new User();
                user.name = "李存平";
                sessions.put(sessionId, user);
                response.setHeaders("Set-Cookie", "sessionId="+sessionId);
                response.wirteBody("<html>");
                response.wirteBody("<div>成功登录!</div>");
                response.wirteBody("</html>");
            }else {
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                response.wirteBody("<html>");
                response.wirteBody("<div>登陆失败!</div>");
                response.wirteBody("</html>");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 h = new HttpServerV3(9090);
        h.start();
    }
}















