package main.java.com.projetoservlet.servlet;
import main.java.com.projetoservlet.server.HttpServlet;
import main.java.com.projetoservlet.server.HttpServletRequest;
import main.java.com.projetoservlet.server.HttpServletResponse;

public class HelloServlet implements HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        // Enviar a linha de status de resposta HTTP
        response.getOutputStream().println("HTTP/1.1 200 OK");
        response.getOutputStream().println("Content-Type: application/json");
        String httpResponse = "{ \"message\": \"HelloServlet executado com sucesso!\", \"method\": \"GET\" }";
        response.getOutputStream().println("Content-Length: " + httpResponse.length());
        response.getOutputStream().println("");
        response.getOutputStream().println(httpResponse);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        // Enviar a linha de status de resposta HTTP
        response.getOutputStream().println("HTTP/1.1 200 OK");
        response.getOutputStream().println("Content-Type: application/json");
        String httpResponse = "{ \"message\": \"HelloServlet executado com sucesso!\", \"method\": \"Post\" }";
        response.getOutputStream().println("Content-Length: " + httpResponse.length());
        response.getOutputStream().println("");
        response.getOutputStream().println(httpResponse);
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){
        if("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request, response);
        } else if ("POST".equalsIgnoreCase(request.getMethod())) {
            doPost(request, response);
        } else {
            // Enviar a linha de status de resposta HTTP
            response.getOutputStream().println("HTTP/1.1 405 Method Not Allowed");
            response.getOutputStream().println("Content-Type: application/json");
            response.getOutputStream().println("Content-Length: 0");
            response.getOutputStream().println("");
        }

    }
}
