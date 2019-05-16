import BancoDeDados.ConectarBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultar {
    Connection conectar = new ConectarBanco().conectar();
    
    public Consultar(){
    
    }
    
    public String consultar(long codigo){
        String sql = "SELECT * FROM usuario WHERE codigo = "+codigo;
        String msg = "";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String cpf = consulta.getString("cpf");
                String email = consulta.getString("email");
                String telefone = consulta.getString("telefone");
                msg = "Nome: "+nome+"\nCPF: "+cpf+"\nEMAIL: "+email+"\nTELEFONE: "+telefone;
            }
            return msg;
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
}
