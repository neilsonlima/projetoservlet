package main.java.com.projetoservlet.server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class HttpServer {

    static final int port = 8080;

    public static void start() {
        
        try (ServerSocket serverSocket = new ServerSocket(HttpServer.port)){
            System.out.println("Servidor iniciado na porta: " + HttpServer.port);

            ServletMapper servletMapper = loadServletMapper();
            
            while(true){
                Socket clientSocket = serverSocket.accept(); // Bloqueante

                System.out.println("Conexao recebida: " + LocalDateTime.now());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String requestLine = in.readLine();

                System.out.println("Requisição: " + requestLine);

                if(requestLine != null && !requestLine.isEmpty()){

                    // Extrai o caminho da URL
                    String[] requestParts = requestLine.split(" ");
                    String method = requestParts[0];
                    String url = requestParts[1];
                    String httpVersion = requestParts[2];

                    // Cria o HttpServletRequest 
                    HttpServletRequest httpServletRequest = new HttpServletRequest(method, url, httpVersion);
                    System.out.println("");
                    while(!(requestLine = in.readLine()).isEmpty()){
                        System.out.println(requestLine);
                    }
                    // Cria o HttpServletResponse
                    HttpServletResponse httpServletResponse = new HttpServletResponse(httpVersion);

                    // Processa a requisição com base no mapeamento de servlets
                    // TODO mudar para passar o request e o response como parametros
                    servletMapper.handleRequest(url,method, out);
                }
     
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