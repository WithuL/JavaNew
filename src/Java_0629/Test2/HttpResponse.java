package Java_0629.Test2;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    private Map<String, String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    private OutputStream outputStream = null;

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

    public void setHeader(String k, String v) {
        this.headers.put(k, v);
    }

    public void writeBody(String content) {
        this.body.append(content);
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version + " "+status+" "+message+"\n");
        headers.put("Content-Length", body.toString().getBytes().length + "");
        for(Map.Entry<String, String> entry : headers.entrySet()) {
            bufferedWriter.write(entry.getKey()+": " +entry.getValue() +"\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
