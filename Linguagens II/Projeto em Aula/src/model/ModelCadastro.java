package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe com os métodos que acessam o banco
 * @author cassio
 */
public class ModelCadastro {
    public ModelCadastro(){}
    
    Conexao conexao = Conexao.getInstance();
    
    public boolean cadastrar(Funcionario funcionario){
        String nome, email, cargo;
        
        nome = funcionario.getNome();
        email = funcionario.getEmail();
        cargo = funcionario.getCargo();
        
        String sql = "INSERT INTO funcionario (NOME, EMAIL, CARGO) VALUES (?,?,?)";
        try {
            PreparedStatement stmt;
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, cargo);
            stmt.execute();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public Funcionario consultar(String consulta, String tipoConsulta){
        Funcionario func = new Funcionario();
        int id = 0;
        String nome = " ", email = " ", cargo = " ";
        
        String sql = "SELECT * FROM FUNCIONARIO WHERE "+tipoConsulta+" LIKE '"+consulta+"'";
        PreparedStatement stmt;
        try {
            stmt = conexao.conectarBanco().prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);
            if(result.next()){
                id = result.getInt("id");
                nome = result.getString("nome");
                email = result.getString("email");
                cargo = result.getString("cargo");
            }
            
            func.setId(id);
            func.setNome(nome);
            func.setEmail(email);
            func.setCargo(cargo);
            
            return func;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return func;
    }
    
    public boolean alterar(Funcionario funcionario){
        String nome, email, cargo;
        int id = 0;
        
        id = funcionario.getId();
        nome = funcionario.getNome();
        email = funcionario.getEmail();
        cargo = funcionario.getCargo();
        
        String sql = "UPDATE FUNCIONARIO SET NOME ='"+nome+"', EMAIL = '"+email+"', CARGO = '"+cargo+"' WHERE ID = '"+id+"'";
        PreparedStatement stmt;
        try {
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.executeUpdate();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean excluir(Funcionario funcionario){
        int id = 0;
        
        id = funcionario.getId();
        
        
        String sql = "DELETE FROM FUNCIONARIO WHERE ID = '"+id+"'";
        try {
            PreparedStatement stmt;
            stmt = conexao.conectarBanco().prepareStatement(sql);
            stmt.execute();
            conexao.conectarBanco().close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(ModelCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
