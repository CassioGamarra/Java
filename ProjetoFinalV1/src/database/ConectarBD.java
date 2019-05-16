package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectarBD{
    
    public Connection conectar(String banco, String user, String senha){
       String mensagem;
       try{
           return DriverManager.getConnection(banco,user,senha);
       }
       catch(SQLException e){    
           throw new RuntimeException(e);
       }
       
    }
}

