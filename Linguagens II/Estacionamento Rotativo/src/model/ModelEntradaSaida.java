package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.Conexao;
import util.Util;

/**
 * Model com os métodos de entrada e saida
 * @author cassio
 */
public class ModelEntradaSaida {
    
    public ModelEntradaSaida(){}
    
    Util util = new Util();
    //Métodos de entrada e saida
    public String entrada(String placa, int vaga, String tipo) {
        String textoEntrada = "";
        String sql = "SELECT SITUACAO FROM ENTRADA_E_SAIDA WHERE PLACA LIKE '"+placa+"'";
        int status = 0;
        
        String horario, data;
        horario = util.horarioSistema();
        data = util.dataSistema();
        try {
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                status = Integer.parseInt(consulta.getString("SITUACAO"));
            }
            //Verifica se não é uma entrada dupla
            if(status == 1){
                JOptionPane.showMessageDialog(null, "ENTRADA DUPLA!!!", "ERRO", JOptionPane.WARNING_MESSAGE);
                return textoEntrada;
            }
            else{
                sql = "INSERT INTO ENTRADA_E_SAIDA(PLACA, VAGA, DATA_ENTRADA, HORA_ENTRADA, TIPO_VEICULO,SITUACAO)VALUES(?, ?, ?, ?, ?, ?)";
                stmt = conectar().prepareStatement(sql);
                stmt.setString(1, placa);
                stmt.setInt(2, vaga+1);
                stmt.setString(3, data);
                stmt.setString(4, horario);
                stmt.setString(5, tipo);
                stmt.setInt(6, 1);
                stmt.execute();
                textoEntrada = horario+"-"+data;
                conectar().close();
                return textoEntrada;
            }           
        }
        catch (SQLException e) {
            System.out.println("ERRO!");
            throw new RuntimeException(e);
        }
        
    }
    
    public String saida(String placa, int vaga){
        String textoSaida = "";
        
        String sql = "SELECT * FROM ENTRADA_E_SAIDA WHERE PLACA LIKE '"+placa+"'";
        int status = 0;
        String horario, data;
        horario = util.horarioSistema();
        data = util.dataSistema();
        
        String horaEntrada = "", dataEntrada = "";
        
        try {
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                status = Integer.parseInt(consulta.getString("situacao"));
                horaEntrada = consulta.getString("HORA_ENTRADA");
                dataEntrada = consulta.getString("DATA_ENTRADA");
            }
            
            //Se a pessoa já realizou uma saída e está ativa no sistema
            if(status == 0){
                JOptionPane.showMessageDialog(null, "SAÍDA DUPLA!!!", "ERRO", JOptionPane.WARNING_MESSAGE);
                return textoSaida;
            }
            //Se a pessoa já foi excluida e já entrou ou se apenas entrou
            else{
                //Faz a saída da pessoa
                sql = "UPDATE ENTRADA_E_SAIDA SET DATA_SAIDA = '"+data+"', HORA_SAIDA = '"+horario+"', SITUACAO = 0 WHERE PLACA LIKE '"+placa+"'";
                stmt = conectar().prepareStatement(sql);
                stmt.executeUpdate();
                textoSaida = horaEntrada+"-"+dataEntrada+"-"+horario+"-"+data;
                conectar().close();
                return textoSaida;
            }
        }
        catch (SQLException e) {
            System.out.println("ERRO");
            throw new RuntimeException(e);
        }
    }
    
    //Método para conectar com o banco
    private Connection conectar() throws SQLException{
        Conexao conexao = Conexao.getInstance();
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
