package br.com.cassiogamarra.projetofinal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe para conexão com o banco de dados
 * @author Gnomo
 */
public class ConectarDB{
    
    public static Connection conectar() throws SQLException{
        Connection conectar = null;
        try{
            
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste","root","");
            
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar");
	}
	return conectar;
    }
}
