package model;

import util.Sessao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexao;

/**
 * Model para o login
 * @author cassio
 */
public class ModelLogin {
    
    Sessao sessao = Sessao.getInstance();
    Conexao conexao = Conexao.getInstance();
    
    public boolean login(String usuario, String senha){
        
        try {
            conexao.conectarBanco();
            
            String sql = "SELECT * FROM usuario WHERE USERNAME LIKE'"+usuario+"'AND PASSWORD LIKE'"+senha+"' AND NIVEL_ACESSO != 0";
            PreparedStatement stmt = conexao.conectarBanco().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            String password = "";    
            if(consulta.next()){
                password = consulta.getString("PASSWORD");
                sessao.setNivelAcesso(consulta.getInt("NIVEL_ACESSO"));
            }
            if(password.equals(senha) && sessao.getNivelAcesso() != 0){
                conexao.conectarBanco().close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
