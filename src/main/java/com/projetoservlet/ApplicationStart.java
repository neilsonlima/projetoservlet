package main.java.com.projetoservlet;

import main.java.com.projetoservlet.server.HttpServer;

public class ApplicationStart {

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(8080);
        httpServer.start();
    }
}
