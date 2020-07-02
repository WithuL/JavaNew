package Java_0702;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.OutputStream;
public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    private Map<String,String> headers = new HashMap<>();
    private StringBuilder body;
    private OutputStream outputStream;

    public static HttpResponse build(OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;
        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeaders(String key,String value) {
        this.headers.put(key, value);
    }

    public void wirteBody(String key) {
        this.body.append(key);
    }

    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version+" "+status+" "+message);
        headers.put("Content-Type",body.toString().getBytes().length + "");
        for(Map.Entry<String, String> entry : headers.entrySet() ) {
            bufferedWriter.write(entry.getKey()+": "+entry.getKey()+"\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
