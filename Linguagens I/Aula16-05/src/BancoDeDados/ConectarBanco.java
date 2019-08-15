package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBanco {
    public Connection conectar(){
       try{
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/teste","root","");
       }
       catch(SQLException e){
           throw new RuntimeException(e);
       }
    }
}

