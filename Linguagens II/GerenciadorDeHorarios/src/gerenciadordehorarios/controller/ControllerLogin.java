/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordehorarios.controller;

import gerenciadordehorarios.model.ModelLogin;
import gerenciadordehorarios.view.ViewLogin;
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
        boolean entrada = entrar.login(usuario, password);
        
        if(entrada == true){
            ViewLogin view = new ViewLogin();
            view.dispose();
            view.getFrameAdministrador().setLocationRelativeTo(null);
            view.getFrameAdministrador().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Login ou senha inválidos", 
                    "LOGIN", JOptionPane.WARNING_MESSAGE);
        }
    }
}
