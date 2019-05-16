import BancoDeDados.ConectarBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cadastrar {
    Connection conectar = new ConectarBanco().conectar();
    
    public Cadastrar(){
          
    }
    
    public void cadastrar(Pessoa usuario){
        
        String sql = "INSERT INTO usuario(nome, cpf, email, telefone)VALUES(?,?,?,?)";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCPF());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        }
        
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    
}
