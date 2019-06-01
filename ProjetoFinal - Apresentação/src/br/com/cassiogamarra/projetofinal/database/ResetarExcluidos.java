package br.com.cassiogamarra.projetofinal.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe para resetar os excluidos no banco
 * @author Gnomo
 */

public class ResetarExcluidos {
    public void resetarExcluidos() throws SQLException{
        ConectarDB conectar = new ConectarDB();
        
        String sql = "UPDATE usuario SET situacao = 1";
        int opcao;
        opcao = JOptionPane.showConfirmDialog(null, "DESEJA ATUALIZAR?",
                "ALERTA!", JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try{
                PreparedStatement stmt;
                stmt = conectar.conectar().prepareStatement(sql);
                stmt.execute();
                JOptionPane.showMessageDialog(null,
                        "REGISTROS ATUALIZADOS COM SUCESSO!");
            }
            catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERRO!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "REGISTROS NÃO FORAM MODIFICADOS!");
        }
    }
}
