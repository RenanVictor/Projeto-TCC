

package tcc.dominio.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
   
    public static Connection get() throws SQLException{
        
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost:3306/BDTCC";
        
        return DriverManager.getConnection(url, usuario, senha);
    }
    
    
    
}
