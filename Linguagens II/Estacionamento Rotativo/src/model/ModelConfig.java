package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Conexao;

/**
 * Model das configurações
 * @author cassio
 */
public class ModelConfig {
    public ModelConfig(){}
    
    public static final ArrayList<Integer> VAGA = new ArrayList<>();
    public static final ArrayList<String> PLACA = new ArrayList<>();
    public static final ArrayList<String> TIPO = new ArrayList<>();
    
    //Método para inserir a configuração no banco
    public boolean inserirConfiguracao(String nome, int vaga){
        if(buscarConfig().equals("-0")){
            try {
                conectar();
                String sql = "INSERT INTO CONFIGURACAO(NOME_GARAGEM, VAGAS_GARAGEM) VALUES (?,?)";
                PreparedStatement stmt = conectar().prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setInt(2, vaga);
                stmt.execute();
                conectar().close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                conectar();
                String sql = "UPDATE CONFIGURACAO SET NOME_GARAGEM = '"+nome+"', VAGAS_GARAGEM = '"+vaga+"' WHERE ID = 1";
               
                PreparedStatement stmt = conectar().prepareStatement(sql);
                 
                stmt.executeUpdate();
                conectar().close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    //Método para buscar a configuração no banco
    public String buscarConfig(){
        String config = "";
        String nomeGaragem = "";
        int numVagas = 0;
        try {
            conectar();
            String sql = "SELECT * FROM CONFIGURACAO WHERE ID = 1";
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            if(consulta.next()){
                nomeGaragem = consulta.getString("NOME_GARAGEM");
                numVagas = consulta.getInt("VAGAS_GARAGEM");
            }
            config = nomeGaragem + "-" + numVagas;
            conectar().close();
            return config;
            
        } catch (SQLException ex) {
            Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config;
    }
    
    //Método para carregar as vagas ocupadas
    public void buscarVagas(){        

        try {
            conectar();
            String sql = "SELECT VAGA, PLACA, TIPO_VEICULO FROM ENTRADA_E_SAIDA WHERE SITUACAO = 1";
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                VAGA.add(consulta.getInt("VAGA")-1);
                PLACA.add(consulta.getString("PLACA"));
                TIPO.add(consulta.getString("TIPO_VEICULO"));
            }
            conectar().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
        }

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
