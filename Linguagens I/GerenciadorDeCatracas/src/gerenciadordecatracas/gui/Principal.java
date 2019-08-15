package gerenciadordecatracas.gui;

import gerenciadordecatracas.gerenciamento.Conexao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        try {
            conexao.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "CONEXÃO REALIZADA COM SUCESSO!", "SUCESSO!", JOptionPane.PLAIN_MESSAGE);
        new MenuPrincipal().setVisible(true);
    }
}
