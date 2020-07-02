package Java_0702;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class HttpRequest {
    private String method;
    private String url;
    private String version;
    private Map<String,String> headers = new HashMap<>();
    private Map<String,String> parameters = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private String body;
    public static HttpRequest vbuild (InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];

        int pos = request.url.indexOf("?");
        if(pos != -1) {
            String tmp = request.url.substring(pos+1);
            parseKV(tmp, request.parameters);
        }

        String line = "";
        while((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] tmps = line.split(": ");
            request.headers.put(tmps[0], tmps[1]);
        }

        String cookie = request.headers.get("Cookie");
        if(cookie != null) {
            parseCookie(cookie, request.cookies);
        }

        if("POST".equalsIgnoreCase(request.url) ||
            "PUT".equalsIgnoreCase((request.url))
        ) {
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));
            char[] buffer = new char[contentLength];
            int len = bufferedReader.read(buffer);
            request.body = new String(buffer, 0, len);
            parseKV(request.body, request.parameters);
        }
        return request;
    }

    private static void parseCookie(String cookie, Map<String, String> cookies) {
        String[] tmps = cookie.split("; ");
        for(String t : tmps) {
            String[] tmp = t.split("=");
            cookies.put(tmp[0], tmp[1]);
        }
    }

    public static void parseKV(String tmp, Map parameters){
        String[] tmpTokens = tmp.split("&");
        for(String t : tmpTokens) {
            String[] tm = t.split("=");
            parameters.put(tm[0], tm[1]);
        }
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

    public String getHeaders(String key) {
        return headers.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    public String getCookies(String key) {
        return cookies.get(key);
    }

    public String getBody() {
        return body;
    }
}
