package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.ConectarDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe para consultar a duplicidade de um cadastro a partir do CPF
 * @author Gnomo
 */

public class ConsultarDuplicidade {
    
    public ConsultarDuplicidade(){}
    
    ConectarDB conectar = new ConectarDB();
    
    public boolean consultarDuplicidade(String CPF) throws SQLException{

        String sql = "SELECT cpf FROM usuario WHERE cpf = "+CPF;
        String cpfConsulta = "";
        try{
            PreparedStatement stmt = conectar.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                cpfConsulta = consulta.getString("cpf");
            }
            return !cpfConsulta.equals(CPF);
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
        
    }
}
