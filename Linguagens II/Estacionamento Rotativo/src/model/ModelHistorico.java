package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.Conexao;

/**
 * Model para recuperar o histórico
 * @author cassio
 */
public class ModelHistorico {
    public ModelHistorico(){}
    
    //Método que retorna o histórico de entrada
    public ResultSet gerarHistorico(){
        String sql = "SELECT * FROM ENTRADA_E_SAIDA WHERE SITUACAO = 0";
        
        try {
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            conectar().close();
            return consulta;
        } 
        catch (SQLException e) {
            System.out.println("Erro");
        }
        return null;
    }
    
     //Método para conectar com o banco
    private Connection conectar() throws SQLException{
        Conexao conexao = Conexao.getInstance();
        conexao.gerar();
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection(conexao.getUrl(),conexao.getUser(),conexao.getPassword());
            return conectar;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
        
        return conectar;
    }
}
