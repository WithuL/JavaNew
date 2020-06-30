package Java_0629.Test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
public class HttpRequest {
    private String method;
    private String url;
    private String version;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private String body;

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String firsLine = bufferedReader.readLine();
        String[] firstLineTokens = firsLine.split(" ");

        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];

        int pos = request.url.indexOf("?");
        if(pos != -1) {
            String queryString = request.url.substring(pos + 1);
            parseKV(queryString, request.parameters);
        }

        String line = "";
        while((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0], headerTokens[1]);
        }

        String cookie = request.headers.get("Cookie");
        if(cookie != null) {
            parseCookie(cookie, request.cookies);
        }

        if("POST".equalsIgnoreCase(request.method) ||
            "PUT".equalsIgnoreCase(request.method)
        ) {
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));
            char[] buffer = new char[contentLength];
            int len = bufferedReader.read(buffer);
            request.body = new String(buffer, 0 ,len);
            parseKV(request.body, request.parameters);
        }
        return request;
    }

    private static void parseCookie(String cookie, Map<String, String> cookies) {
        String[] KVTokens = cookie.split("; ");
        for(String kv : KVTokens) {
            String[] result = kv.split("=");
            cookies.put(result[0], result[1]);
        }
    }

    private static void parseKV(String queryString, Map<String, String> parameters) {
        String[] KvTokens = queryString.split("&");
        for(String kv: KvTokens) {
            String[] result = kv.split("=");
            parameters.put(result[0],result[1]);
        }
    }

    public String getBody() {
        return body;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getCookie(String key) {
        return cookies.get(key);
    }
}
