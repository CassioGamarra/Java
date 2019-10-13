package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Singleton com as conexões do banco
 * @author cassio
 */
public class Conexao {
    private static Conexao instance;
    private String url;
    private String user;
    private String password;
    
    private Conexao(){}
    
    public static Conexao getInstance(){
        if(instance == null){
            instance = new Conexao();
        }
        return instance;
    }
    
    
    public Connection conectarBanco() throws SQLException{
        url = "jdbc:mysql://localhost:3306/AULA03AGENDA?useTimezone=true&serverTimezone=UTC";
        user = "root";
        password = "root";
        return conectar();
    }
    
    //Método para conectar com o banco
    private Connection conectar() throws SQLException{

        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection(url, user, password);
            return conectar;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
        
        return conectar;
    }    
}
