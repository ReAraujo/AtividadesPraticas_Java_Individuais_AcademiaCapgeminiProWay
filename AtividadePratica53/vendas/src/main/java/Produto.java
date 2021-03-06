/*_ Crie um projeto maven utilizando o archetype: maven-archetype-webapp.
  _ Utilize o projeto construido ate a atividade ATP52 como base para este projeto. 
  _ Adicione ao POM.XML as dependencias e plugins necessários para criar e 
   rodar uma aplicação java web com servlet no tomcat.
  _ Crie uma página principal com links para /<nome_app>/categoria e /<nome_app>/produto.
  _ Crie dois servlets que respondem aos endereços /categoria e /produto. 
     Estes servlets devem retornar uma frase simples com os nomes: Módulo Categoria e Módulo Produto.
*/

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto") // Endereço do qual o Servlet responde = "/produto"
public class Produto extends HttpServlet {
    // Protocolo HTTP/HTTPS: 
        // Request = Solicitação do usuário - Exemplo: o usuário acessando end. via Chrome 
        // Response = Resposta do servidor ao usuário - Exemplo: carregar a página web no Chrome
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter(); // Objeto da classe PrintWriter para poder escrever resposta
        out.println("Modulo Produto"); // Resposta da página que será enviada ao usuário
    }
}
