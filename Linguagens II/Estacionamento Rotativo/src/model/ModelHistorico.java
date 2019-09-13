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
    
     //Método que retorna o histórico de entrada
    public String gerarHistorico(){
        String historicoEntrada = "";
        String sql = "SELECT usuario.nome, catraca.codigo, catraca.dataHora "
                + "FROM usuario, catraca "
                + "WHERE usuario.codigo = catraca.codigo "
                + "AND catraca.situacao = 1";
        
        try {
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                String dataHora = consulta.getString("dataHora");
                if(historicoEntrada.equals("")){
                    historicoEntrada = "Código: "+codigo+" |  Nome: "+nome+
                            " | "+dataHora+"\n";
                }
                else{
                    historicoEntrada = historicoEntrada+"Código: "+codigo+
                            " |  Nome: "+nome+" | "+dataHora+"\n";
                }
            }
            if(historicoEntrada.equals("")){
                return "SEM HISTÓRICO";
            }
            else{
                return historicoEntrada;
            }
        } 
        catch (SQLException e) {
            System.out.println("Errro");
            return historicoEntrada;
        }
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
