package main.java.com.projetoservlet.servlet;
import java.io.PrintWriter;

import main.java.com.projetoservlet.server.HttpServlet;

public class ExampleServlet implements HttpServlet {

    @Override
    public void doGet(PrintWriter out){
        // Enviar a linha de status de resposta HTTP
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: application/json");
        String httpResponse = "{ \"message\": \"ExampleServlet executado com sucesso!\", \"method\": \"GET\" }";
        out.println("Content-Length: " + httpResponse.length());
        out.println("");
        out.println(httpResponse);
    }

    @Override
    public void doPost(PrintWriter out){
        // Enviar a linha de status de resposta HTTP
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: application/json");
        String httpResponse = "{ \"message\": \"ExampleServlet executado com sucesso!\", \"method\": \"Post\" }";
        out.println("Content-Length: " + httpResponse.length());
        out.println("");
        out.println(httpResponse);
    }

    @Override
    public void service(String method, PrintWriter out){
        if("GET".equalsIgnoreCase(method)){
            doGet(out);
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost(out);
        } else {
            // Enviar a linha de status de resposta HTTP
            out.println("HTTP/1.1 405 Method Not Allowed");
            out.println("Content-Type: application/json");
            out.println("Content-Length: 0");
            out.println("");
        }

    }
}
