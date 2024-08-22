package main.java.com.projetoservlet.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class RequestHandler implements Runnable{
    private Socket cliSocket;
    private ServletMapper servletMapper;

    public RequestHandler(Socket cliSocket, ServletMapper servletMapper){
        this.cliSocket = cliSocket;
        this.servletMapper = servletMapper;
    }

    @Override
    public void run() {
        
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(cliSocket.getInputStream()));
            PrintWriter outputStream = new PrintWriter(cliSocket.getOutputStream(), true)
        ){
             System.out.println("Conexao recebida: " + LocalDateTime.now());


            String requestLine = reader.readLine();

            if (requestLine == null || requestLine.isEmpty()){
                return;
            }

            String[] requestParts = requestLine.split(" ");
            String httpMethod = requestParts[0];
            String httpUri = requestParts[1];
            String httpVersion = requestParts[2];

            HttpServletRequest httpServletRequest = new HttpServletRequest(httpMethod, httpUri, httpVersion);
            HttpServletResponse httpServletResponse = new HttpServletResponse(outputStream, httpVersion);


            //     System.out.println("");
            //     while(!(requestLine = in.readLine()).isEmpty()){
            //         System.out.println(requestLine);
            //     }
  
            servletMapper.handleRequest(httpServletRequest, httpServletResponse);
            
        } catch (Exception e) {
            System.out.println("Erro no RequestHandler" + e.getMessage());
        } finally {
            try {
                cliSocket.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
            
        }
    }
}
