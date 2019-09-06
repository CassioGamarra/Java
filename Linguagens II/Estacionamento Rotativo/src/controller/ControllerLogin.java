/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelLogin;
import view.ViewAdm;
import view.ViewLogin;

/**
 *
 * @author cassio
 */
public class ControllerLogin {
    public ControllerLogin(){}
    
    public void login(String usuario, char[] senha){
        ModelLogin entrar = new ModelLogin();
        String password = new String(senha);
        try {
            password = hash(password);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean entrada = entrar.login(usuario, password);
        
        if(entrada == true){
            ViewLogin viewLogin = new ViewLogin();
            viewLogin.dispose();
            ViewAdm view = new ViewAdm();
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Login ou senha inválidos", 
                    "LOGIN", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Transformando a senha em um HASH
    private String hash(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestSenha[] = algorithm.digest(password.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigestSenha) {
                 hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaHex = hexString.toString();
      
        return senhaHex;   
    }
}
