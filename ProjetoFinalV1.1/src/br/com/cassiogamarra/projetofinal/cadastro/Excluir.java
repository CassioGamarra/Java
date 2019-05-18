package br.com.cassiogamarra.projetofinal.cadastro;
import br.com.cassiogamarra.projetofinal.database.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Excluir {
    
    public Excluir(){
    }
    public static void excluir(long codigo) throws SQLException{
        Connection conectar = ConectarDB.conectar();
        String sql = "UPDATE usuario SET situacao = 0 WHERE codigo = "+codigo;
        int opcao;
        opcao = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR?", "ALERTA!", JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try{
                PreparedStatement stmt = conectar.prepareStatement(sql);
                stmt.execute();
                JOptionPane.showMessageDialog(null, "PESSOA EXCLUIDA COM SUCESSO");
            }
            catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERRO!");
            }
        }
        else{
            return;
        }
    }
}
