/* _  Crie uma cópia das classes criadas durante a atividade ATP47.
   _  Altere a classe1 para utilizar preparedStatement.
   _  Altere a classe2 para receber os parâmetros nome e descrição através de variáveis e troque o Statement para PreparedStatement.
   _  Altere a classe3 para  receber os nomes das categorias que serão alteradas, através de variáveis e troque o Statement para PreparedStatement.
   _  Altere a classe4 para receber o Id da categorias a ser deletada através de variável e troque o Statement para PreparedStatement..
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class View_Classe4_Delete {
   public static void main(String[] args) {
      try {
         String driverType = "jdbc";
         String driverName = "postgresql";
         String host = "localhost";
         int port = 5432;
         String database = "postgres";
         String user = "postgres";
         String pwd = "123789";
         String connectionString = String.format("%s:%s://%s:%d/%s", driverType, driverName, host, port, database);
         String sql = "DELETE FROM Categoria WHERE id = ? ";

         // Conectando no Banco de Dados
         Connection conn = DriverManager.getConnection(connectionString, user, pwd);

         // Query SQL
         PreparedStatement prepStatement = conn.prepareStatement(sql);

         int idDeletar = 6;
         prepStatement.setInt(1, idDeletar);

         prepStatement.execute();

         // Verificando quantas linhas foram afetadas pelo método DELETE
         int linhasAfetadas = prepStatement.getUpdateCount();
         System.out.println(linhasAfetadas);

         // Fechando a conexão 
         conn.close();

     } catch (SQLException e) {
         System.out.println("Desculpe, não foi possível conectar.");
     }
   }
}   