package br.com.cassiogamarra.projetofinal.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe para verificar se o responsável possui dependentes no banco.
 * @author Gnomo
 */

public class VerificarDependentes {
    public VerificarDependentes(){}
    
    public int verificarDependentes(long codigo) throws SQLException{
        ConectarDB conectar = new ConectarDB();
        
        String sql;
        int dependentes = 0;
        
        sql = "SELECT * FROM usuario WHERE situacao = 1 AND codigo = "+codigo;
        
        try{
            PreparedStatement stmt = conectar.conectar().prepareStatement(sql);
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
