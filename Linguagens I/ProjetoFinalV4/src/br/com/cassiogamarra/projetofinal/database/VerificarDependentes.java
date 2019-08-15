package br.com.cassiogamarra.projetofinal.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarDependentes {
    public VerificarDependentes(){
    
    }
    public static int verificarDependentes(long codigo) throws SQLException{
        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT * FROM usuario WHERE situacao = 1 AND codigo = "+codigo;
        int dependentes = 0;
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String categoria = consulta.getString("categoria");
                if(categoria.equals("Responsável")){
                        String especial = consulta.getString("dependentes");
                        dependentes = Integer.parseInt(especial);
                }
            }
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
        return dependentes;
    }
}
