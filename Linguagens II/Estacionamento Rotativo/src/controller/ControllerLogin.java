package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelLogin;
import util.Sessao;
import view.ViewSistema;
import view.ViewLogin;

/**
 * Controller para realizar o login
 * @author cassio
 */
public class ControllerLogin {
    public ControllerLogin(){}
    
    public void login(String usuario, char[] senha){
        ModelLogin entrar = new ModelLogin();
        ControllerConfig configurar = new ControllerConfig();
        ViewLogin viewLogin = new ViewLogin();
        ControllerHistorico  historico = new ControllerHistorico();
        String password = new String(senha);
        try {
            password = hash(password);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean entrada = entrar.login(usuario, password);
        
        if(entrada == true){
            Sessao sessao = Sessao.getInstance();
            
            viewLogin.dispose();
            ViewSistema view = new ViewSistema();
            if(sessao.getNivelAcesso() == 1){
                view.getFieldNomeGaragem().setEditable(false);
                view.getFieldQtdVagas().setEditable(false);
                view.getBtnSalvarConfig().setEnabled(false);
            }
            view.setLocationRelativeTo(null);
            view.setVisible(true);
            
            if(view.getLabelNomeGaragem().getText().equals("")){
                configurar.buscarConfig(view);
                historico.gerarHistorico(view);
                configurar.buscarVagas(view);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Login ou senha inválidos", 
                    "LOGIN", JOptionPane.WARNING_MESSAGE);
            viewLogin.setLocationRelativeTo(null);
            
            viewLogin.setVisible(true);
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
