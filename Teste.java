import java.sql.Connection;
import java.sql.SQLException;
 
public class Teste {
	/**
	 * Propositalmente sem acentuacao
	 */
   public static void main(String[] args) {
      Connection conn = null;
      Temperatura temperatura;
   
      try {
           conn = ConexaoBD.obtemConexao().getConnection();
           conn.setAutoCommit(false);
      
      	// *** Inclusao de 100 temperaturas aleatorias entre 0 e 40 graus ***
         for(int i = 0; i < 100; i++){
        	 temperatura = new Temperatura();
        	 //nao vai configurar o id por causa do autoincremento
        	 temperatura.setValor(40*Math.random());
        	 temperatura.incluir(conn);
         }
         conn.commit();
               } 
      catch (Exception e) {
         e.printStackTrace();
         if (conn != null) {
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      } 
    }
}
