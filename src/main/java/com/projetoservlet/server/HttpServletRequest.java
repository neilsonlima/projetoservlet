package main.java.com.projetoservlet.server;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
    private String method;
    private String url;
    private String httpVersion;
    private Map<String, String> parameters = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();

    public HttpServletRequest(String method, String url, String httpVersion){
        this.method = method;
        this.url = url;
        this.httpVersion = httpVersion;
    }

    public String getMethod(){
        return this.method;
    }

    public String getUrl(){
        return this.url;
    }

    public String getHttpVersion(){
        return this.httpVersion;
    }

    public void addParameter(String name, String value){
        this.parameters.put(name, value);
    }

    public String getParameter(String name){
        return this.parameters.get(name);
    } 

    public void addHeader(String name, String value){
        this.headers.put(name, value);
    }

    public String getHeader(String name){
        return this.headers.get(name);
    }

}
