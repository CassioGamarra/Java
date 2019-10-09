package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Conexao;

/**
 * Model para recuperar o histórico
 * @author cassio
 */
public class ModelHistorico {
    public ModelHistorico(){}
    Conexao conexao = Conexao.getInstance();
    
    //Método que retorna o histórico de entrada
    public ResultSet gerarHistorico(){
        String sql = "SELECT * FROM ENTRADA_E_SAIDA WHERE SITUACAO = 0";
        
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

}
