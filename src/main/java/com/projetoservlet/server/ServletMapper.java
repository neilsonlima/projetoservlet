package main.java.com.projetoservlet.server;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ServletMapper {
    private final Map<String, String> servletMappings = new HashMap<>();

    public void loadServlets(String xmlFilePath) throws Exception {
        File xmlFile = new File(xmlFilePath); // carrega o arquivo
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // cria uma instancia para analisar o arquivo DOM
        DocumentBuilder builder = factory.newDocumentBuilder(); // cria o analisador para o xml
        Document document = builder.parse(xmlFile); // analisa e cria uma representacao DOM

        document.getDocumentElement().normalize();

        // Lê os elementos <servlet>
        NodeList servletList = document.getElementsByTagName("servlet");
        Map<String, String> servlets = new HashMap<>();

        for (int i = 0; i < servletList.getLength(); i++) {
            Node servletNode = servletList.item(i);
            if (servletNode.getNodeType() == Node.ELEMENT_NODE) {
                Element servletElement = (Element) servletNode;
                String servletName = servletElement.getElementsByTagName("servlet-name").item(0).getTextContent();
                String servletClass = servletElement.getElementsByTagName("servlet-class").item(0).getTextContent();
                servlets.put(servletName, servletClass);
            }
        }

        // Lê os elementos <servlet-mapping>
        NodeList mappingList = document.getElementsByTagName("servlet-mapping");

        for (int i = 0; i < mappingList.getLength(); i++) {
            Node mappingNode = mappingList.item(i);
            if (mappingNode.getNodeType() == Node.ELEMENT_NODE) {
                Element mappingElement = (Element) mappingNode;
                String servletName = mappingElement.getElementsByTagName("servlet-name").item(0).getTextContent();
                String urlPattern = mappingElement.getElementsByTagName("url-pattern").item(0).getTextContent();
                String servletClass = servlets.get(servletName);
                servletMappings.put(urlPattern, servletClass);
            }
        }
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String servletClass = servletMappings.get(request.getUrl());
        if (servletClass != null) {
            try {
                HttpServlet servlet = (HttpServlet) Class.forName(servletClass).getDeclaredConstructor().newInstance();
                servlet.service(request, response);
            } catch (Exception e) {
                System.out.println("Error no handle request: " + e.getMessage());
            }
        } else {
            // Enviar a linha de status de resposta HTTP
            response.getOutputStream().println("HTTP/1.1 404 Not Found");
            response.getOutputStream().println("Content-Type: application/json");
            response.getOutputStream().println("Content-Length: 0");
            response.getOutputStream().println("");
        }
    }
}