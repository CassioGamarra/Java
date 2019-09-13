package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cassio
 */
public class ModelHistorico {
    public ModelHistorico(){}
    //public static final ArrayList<Integer> HISTORICO = new ArrayList<>();
     //Método que retorna o histórico de entrada
    public ResultSet gerarHistorico(){
        String historico = "";
        String sql = "SELECT * FROM ENTRADA_E_SAIDA";
        
        try {
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            return consulta;
        } 
        catch (SQLException e) {
            System.out.println("Erro");
        }
        return null;
    }
    
     //Método para conectar com o banco
    private Connection conectar() throws SQLException{
        
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/GARAGEM","root","");
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
        
        return conectar;
    }
}
