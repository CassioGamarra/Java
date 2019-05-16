package BancoDeDados;

import java.sql.Connection;
import java.sql.SQLException;

public class TestarConexao {
    
    public static void main(String[] args) throws SQLException{
        Connection conectar = new ConectarBanco().conectar();
        System.out.println("OK");
        conectar.close();
    }
}

