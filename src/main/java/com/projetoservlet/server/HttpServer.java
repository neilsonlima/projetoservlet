package main.java.com.projetoservlet.server;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    private int port;
    private ServletMapper servletMapper;

    public HttpServer(int port){
        this.port = port;
    }

    public void start() {
        
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Servidor iniciado na porta: " + port);

            this.servletMapper = loadServletMapper();
            
            while(true){
                Socket clientSocket = serverSocket.accept(); // Bloqueante

                RequestHandler requestHandler = new RequestHandler(clientSocket, servletMapper);

                new Thread(requestHandler).start();
     
            }
        } catch(Exception e) {
            System.out.println("Erro ao criar servidor: " + e.getMessage());
        }

    }

    private static ServletMapper loadServletMapper() throws Exception {
        //Faz o mapeamento dos Servlets
        ServletMapper servletMapper = new ServletMapper();
        servletMapper.loadServlets("src/main/resources/web.xml");
        return servletMapper;
    }

}