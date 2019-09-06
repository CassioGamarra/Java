/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author cassio
 */
public class ModelConfig {
    public ModelConfig(){}
    
    public boolean inserirConfiguracao(String nome, int vaga){
        System.out.println(buscarConfig());
        if(buscarConfig().equals("-0")){
            try {
                conectar();
                String sql = "INSERT INTO configuracao(nome, vagas) VALUES (?,?)";
                PreparedStatement stmt = conectar().prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setInt(2, vaga);
                stmt.execute();

                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                conectar();
                String sql = "UPDATE configuracao SET nome = '"+nome+"', vagas = '"+vaga+"' WHERE codigo = 1";
               
                PreparedStatement stmt = conectar().prepareStatement(sql);
                 
                stmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return false;
    }
    
    public String buscarConfig(){
        String config = "";
        String nomeGaragem = "";
        int numVagas = 0;
        try {
            conectar();
            String sql = "SELECT * FROM configuracao WHERE codigo = 1";
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            if(consulta.next()){
                nomeGaragem = consulta.getString("nome");
                numVagas = consulta.getInt("vagas");
            }
            config = nomeGaragem + "-" + numVagas;
            return config;
            
        } catch (SQLException ex) {
            Logger.getLogger(ModelConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config;
    }
    
    //Método para conectar com o banco
    private Connection conectar() throws SQLException{
        
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/estacionamento-rotativo","root","");
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
        
        return conectar;
    }
}
