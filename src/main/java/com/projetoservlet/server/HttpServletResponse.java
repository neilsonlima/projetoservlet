package main.java.com.projetoservlet.server;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpServletResponse {
    private String httpVersion;
    private int statusCode = 200;
    private String statusMessage = "OK";
    private String contentType;
    private Map<String, String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    private PrintWriter outputStream;

    public HttpServletResponse(PrintWriter outputStream, String statusVersion){
        this.httpVersion = statusVersion;
        this.outputStream = outputStream;
    }

    public void setStatusCode(int statusCode, String statusMessage){
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getContentType(){
        return this.contentType;
    }
    public void setContentType(String contentType){
        this.contentType = contentType;
    }

    public void addHeader(String name, String value){
        headers.put(name, value);
    }

    public void writeBody(String content) {
        this.body.append(content);
    }

    public void send(String msg) {
        outputStream.println(httpVersion + " " + statusCode + " " + statusMessage);
        outputStream.println("ContentType: " + this.contentType);
        outputStream.println("Content-Length: " + msg.length());
        for (Map.Entry<String, String> header : headers.entrySet()) {
            outputStream.println(header.getKey() + ": " + header.getValue());
        }
        outputStream.println(); 
        outputStream.println(msg.toString());
    }

    public PrintWriter getOutputStream(){
        return this.outputStream;
    }

}
