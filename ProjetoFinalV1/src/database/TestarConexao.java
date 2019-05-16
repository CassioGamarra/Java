package database;
import java.sql.Connection;
import java.sql.SQLException;

public class TestarConexao{
    public static void main(String[] args) throws SQLException{
        Connection conectar = new ConectarBD().conectar("jdbc:mysql://localhost:3306/teste","root","");
        System.out.println("OK");
        conectar.close();
    }
}
