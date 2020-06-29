package Java_0629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class HttpRequest {
    private String method;
    private String url;
    private String version;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();

    public static HttpRequest build (InputStream inputSteam) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputSteam));
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        int pos = request.url.indexOf("?");
        if(pos != -1) {
            String parameter = request.url.substring(pos);
            parseKV(parameter, request.parameters);
        }
        String line = "";
        while((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTOkens = line.split(": ");
            request.headers.put(headerTOkens[0], headerTOkens[1]);
        }
        return request;
    }

    private static void parseKV(String parameter, Map<String, String> parameters) {
        String[] KVtokens = parameter.split("&");
        for(String x : KVtokens) {
            String[] res = x.split("=");
            parameters.put(res[0], res[1]);
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

    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                ", parameters=" + parameters +
                '}';
    }
}
