package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.ConectarDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarDuplicidade {
    
    public ConsultarDuplicidade(){
    }
    
    public static boolean consultarDuplicidade(String CPF) throws SQLException{

        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT cpf FROM usuario WHERE cpf = "+CPF;
        String cpfConsulta = "";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
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
