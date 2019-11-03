package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe com os métodos de busca e exclusão da base de dados
 * @author Cássio Gamarra
 */
public class ModelCadastroJogo {
    public ModelCadastroJogo(){}
    
    Conexao conexao = Conexao.getInstance();

    public ResultSet consulta(){
        String sql = "SELECT * FROM jogo";
        
        try {
            PreparedStatement stmt = conexao.conectarBanco().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            conexao.conectarBanco().close();
            return consulta;
        } 
        catch (SQLException e) {
            System.out.println("Erro");
        }
        return null;
    }
    
    public boolean excluir(Jogo jogo){
        int id = 0;
        
        id = jogo.getId();
        
        String sql = "UPDATE jogo SET status = 0 WHERE id = '"+id+"'";
        PreparedStatement stmt;
        try {
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.executeUpdate();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastroJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean restaurar(Jogo jogo){
        int id = 0;
        
        id = jogo.getId();
        
        String sql = "UPDATE jogo SET status = 1 WHERE id = '"+id+"'";
        PreparedStatement stmt;
        try {
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.executeUpdate();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastroJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
