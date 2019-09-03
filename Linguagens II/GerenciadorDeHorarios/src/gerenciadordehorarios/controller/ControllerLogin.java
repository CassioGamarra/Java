/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordehorarios.controller;

import gerenciadordehorarios.model.ModelLogin;
import gerenciadordehorarios.view.ViewAdministrador;
import gerenciadordehorarios.view.ViewLogin;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            ViewAdministrador viewAdm = new ViewAdministrador();
            viewAdm.setLocationRelativeTo(null);
            viewAdm.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Login ou senha inválidos", 
                    "LOGIN", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private String hash(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestSenhaAdmin[] = algorithm.digest(password.getBytes("UTF-8"));

        StringBuilder hexStringSenhaAdmin = new StringBuilder();
        for (byte b : messageDigestSenhaAdmin) {
                 hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
        }
        String senhahexAdmin = hexStringSenhaAdmin.toString();
      
        return senhahexAdmin;   
    }
}
