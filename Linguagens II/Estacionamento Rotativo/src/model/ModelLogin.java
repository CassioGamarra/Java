package model;

import util.Sessao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cassio
 */
public class ModelLogin {
    
    Sessao sessao = Sessao.getInstance();
    
    public boolean login(String usuario, String senha){
        
        try {
            conectar();
            
            String sql = "SELECT * FROM usuario WHERE USERNAME ='"+usuario+"'AND PASSWORD ='"+senha+"' AND NIVEL_ACESSO != 0";
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            String password = "";    
            if(consulta.next()){
                password = consulta.getString("PASSWORD");
                sessao.setNivelAcesso(consulta.getInt("NIVEL_ACESSO"));
            }
            if(password.equals(senha) && sessao.getNivelAcesso() != 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    //Método para conectar com o banco
    private Connection conectar() throws SQLException{
        
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/GARAGEM","root","");
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
        
        return conectar;
    }
}
