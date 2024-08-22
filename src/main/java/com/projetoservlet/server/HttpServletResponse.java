package main.java.com.projetoservlet.server;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpServletResponse {
    private String httpVersion;
    private int statusCode = 200;
    private String statusMessage = "OK";
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

    public void addHeader(String name, String value){
        headers.put(name, value);
    }

    public void writeBody(String content) {
        this.body.append(content);
    }

    public void send(PrintWriter out) {
        out.println(httpVersion + " " + statusCode + " " + statusMessage);
        for (Map.Entry<String, String> header : headers.entrySet()) {
            out.println(header.getKey() + ": " + header.getValue());
        }
        out.println(); // Linha em branco separando cabeçalhos do corpo
        out.println(body.toString());
    }

    public PrintWriter getOutputStream(){
        return this.outputStream;
    }

}
