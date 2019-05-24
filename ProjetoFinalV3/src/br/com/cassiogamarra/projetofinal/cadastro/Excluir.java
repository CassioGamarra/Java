package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.*;
import br.com.cassiogamarra.projetofinal.gui.FramePessoas;
import br.com.cassiogamarra.projetofinal.utilitarios.ValidarCodigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Excluir {
    
    public Excluir(){
    }
    public static void verificarExclusao(FramePessoas frame){
        
        if(!ValidarCodigo.validarCodigo(frame.getCampoConsultaExclusao().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 5 digitos numéricos");
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
            try{
                if(Consultar.consultar(codigo).equals("")){
                    JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                }
                else{
                    frame.getTextoExclusao().setText(Consultar.consultar(codigo));
                    frame.getFrameExclusao().setVisible(true);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void excluir(FramePessoas frame) throws SQLException{
        
        long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
        try{
            if(VerificarDependentes.verificarDependentes(codigo) != 0){
                JOptionPane.showMessageDialog(null, "RESPONSÁVEL NÃO PODE SER EXCLUIDO!");
            }
            else{
                Connection conectar = ConectarDB.conectar();
                String sql = "UPDATE usuario SET situacao = 0 WHERE codigo = "+codigo;
                int opcao;
                opcao = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR?", "ALERTA!", JOptionPane.YES_NO_OPTION);

                if(opcao == JOptionPane.YES_OPTION){
                    try{
                        PreparedStatement stmt = conectar.prepareStatement(sql);
                        stmt.execute();
                        JOptionPane.showMessageDialog(null, "PESSOA EXCLUIDA COM SUCESSO");
                        frame.getFrameExclusao().dispose();
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
        catch (SQLException ex) {
            Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
