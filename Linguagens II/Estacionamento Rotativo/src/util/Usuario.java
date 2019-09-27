package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe para criar o usuário super admin no banco com uma senha segura
 * Posteriormente, a classe será replicada para criação de usuários do sistema
 * Os níveis de acesso são:
 * 0 -  BLOQUEADO NO SISTEMA
 * 1 -  USUÁRIO PADRÃO
 * 2 -  ADMINISTRADOR DO SISTEMA
 * 3 -  SUPER ADM
 * @author cassio
 */
public class Usuario {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            Connection conectar = conectar();
            String usuario = "operador";
            String senha = gerarAdmin("op");
            int nivelAcesso = 1;
            
            String sql = "INSERT INTO USUARIO(USERNAME, PASSWORD, NIVEL_ACESSO)"
                    + "VALUES(?,?,?)";
            
            PreparedStatement stmt = conectar().prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setInt(3, nivelAcesso);
            
            stmt.execute();
            System.out.println("SUCESSO!");
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String gerarAdmin(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestSenhaAdmin[] = algorithm.digest(password.getBytes("UTF-8"));

        StringBuilder hexStringSenhaAdmin = new StringBuilder();
        for (byte b : messageDigestSenhaAdmin) {
                 hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
        }
        String senhahexAdmin = hexStringSenhaAdmin.toString();
        
        System.out.println(senhahexAdmin);
        return senhahexAdmin;
    }
    
    public static Connection conectar() throws SQLException{
        
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/GARAGEM?useTimezone=true&serverTimezone=UTC","root","root");
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
        
        return conectar;
    }
}
