package Java_0629.Test2;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private String version = "HTTP/1.1";
    private String status;
    private String message;
    private Map<String, String> header = new HashMap<>();
    private StringBuffer body;
    private OutputStream outputStream;

    public static HttpResponse build(OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;
        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String k, String v) {
        this.header.put(k, v);
    }

    public void setBody(String content) {
        this.body.append(content);
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version + " "+status+" "+message+"\n");
        header.put("Content-Length", body.toString().getBytes().length + "");
        for(Map.Entry entry : header.entrySet()) {
            bufferedWriter.write(entry.getKey()+": " +entry.getValue() +"\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
