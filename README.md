# Simulação de Servidor Web Simples em Java

Este repositório contém o `projetoservlet`, uma simulação simples de um servidor web em Java, projetada para fins educacionais. O servidor emula funcionalidades básicas de HTTP, permitindo que os usuários explorem o funcionamento interno de servlets, requisições e respostas HTTP em um ambiente controlado. Ele também inclui uma implementação mock de `HttpServletRequest` e `HttpServletResponse` para simular interações de servlets sem a necessidade de um servidor de aplicação completo como Tomcat.

## Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── projetoservlet/
│   │           ├── ApplicationStart.java
│   │           ├── server/
│   │           │   ├── HttpServer.java
│   │           │   ├── HttpServlet.java
│   │           │   ├── HttpServletRequest.java
│   │           │   ├── HttpServletResponse.java
│   │           │   └── ServletMapper.java
│   │           └── servlet/
│   │               ├── ExampleServlet.java
│   │               └── HelloServlet.java
│   └── resources/
│       └── web.xml
└── test/
    └── java/
        └── com/
            └── projetoservlet/
                └── ServletTest.java
```

- **`ApplicationStart.java`**: Classe principal que contém o método `main` para iniciar o servidor.
- **`server/`**: Contém classes principais que simulam o servidor web e manipulam requisições HTTP.
- **`servlet/`**: Abriga implementações de servlets de exemplo.
- **`resources/`**: Contém o arquivo `web.xml` para configuração de mapeamento de servlets.
- **`test/`**: Contém testes unitários para a simulação do servidor.

## Principais Funcionalidades

- **Servidor HTTP Simulado**: Um servidor HTTP básico que escuta em uma porta especificada e manipula requisições HTTP recebidas.
- **Simulação de Servlets**: Servlets simples que manipulam requisições `GET` e `POST`, demonstrando o processamento básico de requisições.
- **Objetos HTTP Mock**: Implementações personalizadas de `HttpServletRequest` e `HttpServletResponse` para facilitar testes e aprendizado.
- **Mapeamento de Servlets**: Mapeamentos de servlets configuráveis via `web.xml` para direcionar requisições aos servlets apropriados.

## Primeiros Passos

### Pré-requisitos

- **Kit de Desenvolvimento Java (JDK)**: Certifique-se de ter o JDK 8 ou superior instalado em sua máquina.

## Executando o Servidor

1. **Compile o Projeto** (caso esteja fora de uma IDE):
   ```bash
   javac -d out/ -sourcepath src/main/java src/main/java/com/suaproject/ApplicationStart.java
   ```

2. **Execute o Servidor através da IDE**:
   - Abra o projeto na sua IDE favorita (por exemplo, IntelliJ IDEA, Eclipse).
   - Navegue até a classe `ApplicationStart` no pacote `com.suaproject`.
   - Clique com o botão direito na classe `ApplicationStart` e selecione a opção `Run` ou `Executar`.
   - O servidor será iniciado, escutando em uma porta configurada.

3. **Acesse o Servidor**:
   Abra seu navegador ou use `curl` para enviar requisições para `http://localhost:8080/example` ou outro URL mapeado com base na sua configuração em `web.xml`.

## Melhorias Futuras

- **Customização de Protocolos**: Ampliar o servidor para suportar protocolos mais dinâmicos e configuráveis.
- **Funcionalidades Avançadas de Servlet**: Implementar gerenciamento de sessões, cookies e outras funcionalidades de servlets.
- **Integração com Full Stack**: Combinar este servidor com frameworks front-end para uma ferramenta educacional mais completa.

## Contribuindo

Sinta-se à vontade para clonar este repositório, criar issues ou enviar pull requests para ajudar a melhorar o projeto.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

