package main.java.com.projetoservlet.server;
import java.io.PrintWriter;

public interface HttpServlet {
    void doGet(PrintWriter out);
    void doPost(PrintWriter out);
    void service(String method, PrintWriter out);
}
