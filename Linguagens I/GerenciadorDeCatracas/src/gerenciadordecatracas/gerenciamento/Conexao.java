package gerenciadordecatracas.gerenciamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe para conexão com o banco de dados
 * @author CassioGamarra
 */
public class Conexao {
    
    public Conexao(){}
    
    public Connection conectar() throws SQLException{
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancocatracas","root","");
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR!", "ERRO!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
	}
	return conectar;
    }
}
