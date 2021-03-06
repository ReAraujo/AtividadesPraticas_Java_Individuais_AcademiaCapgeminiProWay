/*_  Utilize o projeto construido ate a atividade ATP53 como base para este projeto.
  _  Altere os servlets de produto e categoria para que possam ler os parâmetros da requisição e 
      imprima os valores dos parâmetros na resposta.
  _  Para categoria, leia os parâmetros nome e descrição.
  _  Para produto, leia os parâmetros nome, valor e id_categoria.
  _  Utilize o método printf da classe PrintWriter para imprimir, na resposta, os parâmetros lidos.
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
        PrintWriter out = resp.getWriter();
    
        String nomeProd = req.getParameter("nome");
        String parametroValor = req.getParameter("valor");
        String parametroID = req.getParameter("id_categoria");
            
        out.println("Modulo Produto");
    
        // Leitura e envio dos parâmetros nome e descrição por requisição pela url da página
        if(parametroID != null && parametroValor != null){
            // A leitura de parâmetro via url retorna um tipo String então 
            // é necessário fazer a conversão para tipos numéricos 
            int id_categoria = Integer.parseInt(parametroID);
            double valorProd = Double.parseDouble(parametroValor);
            out.printf("\nInformacoes do Produto:\nNome: %s - ID: %d - Valor: %.2f", nomeProd, id_categoria, valorProd);
        } else{
            out.printf("\nInformacoes do Produto: Nome: %s", nomeProd);
        }
    }
        
}    
