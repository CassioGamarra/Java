package gerenciadordehorarios.model;

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
 * Classe para criar o usuário admin no banco com uma senha segura
 * @author cassio
 */
public class CriarADM {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            Connection conectar = conectar();
            String usuario = "admin";
            String senha = gerarAdmin("admin");
            
            String sql = "INSERT INTO USUARIO(username, pass, situacao)"
                    + "VALUES(?,?,?)";
            
            PreparedStatement stmt = conectar().prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setInt(3, 1);
            
            stmt.execute();
            System.out.println("SUCESSO!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CriarADM.class.getName()).log(Level.SEVERE, null, ex);
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
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciador","root","");
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
        
        return conectar;
    }
}
