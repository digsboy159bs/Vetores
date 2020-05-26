import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {

   private static ConexaoBD conexaoBD;
   
   
    
		
	// Obtém conexão com o banco de dados
	public static ConexaoBD obtemConexao() {
   if (conexaoBD == null){
       conexaoBD = new ConexaoBD();
       }
       return conexaoBD;
       }
       public Connection getConnection()throws ClassNotFoundException, SQLException{
       Class.forName("com.mysql.cj.jdbc.Driver");
		String servidor = "localhost";
		String porta = "3306";
		String database = "clima";
		return DriverManager.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+database+"?useTimezone=true&serverTimezone=UTC", "root", "Digsboy@159");

	}
   public static void main(String [] args){
      try {
      System.out.println(obtemConexao().getConnection());
     } catch (Exception e) {
       e.printStackTrace();
     }

   }
}