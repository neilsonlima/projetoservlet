package main.java.com.projetoservlet.server;

public interface HttpServlet {
    void doGet(HttpServletRequest request, HttpServletResponse response);
    void doPost(HttpServletRequest request, HttpServletResponse response);
    void service(HttpServletRequest request, HttpServletResponse response);
}
