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
public class ModelLogin {
    
    public boolean login(String usuario, String senha){

        try {
            conectar();
            //String sql = "SELECT SENHA FROM USUARIOS WHERE USUARIO = "+usuario;
            
            String sql = "SELECT pass FROM usuario WHERE username ='"+usuario+"'AND pass ='"+senha+"'";
            PreparedStatement stmt = conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            
            if(consulta.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
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
