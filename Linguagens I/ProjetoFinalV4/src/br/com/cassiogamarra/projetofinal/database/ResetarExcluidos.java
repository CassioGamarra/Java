
package br.com.cassiogamarra.projetofinal.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ResetarExcluidos {
    public static void resetarExcluidos() throws SQLException{
        Connection conectar = ConectarDB.conectar();
        String sql = "UPDATE usuario SET situacao = 1";
        int opcao;
        opcao = JOptionPane.showConfirmDialog(null, "DESEJA ATUALIZAR?", "ALERTA!", JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try{
                PreparedStatement stmt = conectar.prepareStatement(sql);
                stmt.execute();
                JOptionPane.showMessageDialog(null, "REGISTROS ATUALIZADOS COM SUCESSO!");
            }
            catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERRO!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "REGISTROS NÃO FORAM MODIFICADOS!");
        }
    }
}
