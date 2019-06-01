package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.*;
import br.com.cassiogamarra.projetofinal.gui.FramePessoas;
import br.com.cassiogamarra.projetofinal.utilitarios.LimparTela;
import br.com.cassiogamarra.projetofinal.utilitarios.ValidarCodigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe para excluir um cadastro
 * @author Gnomo
 */

public class Excluir {
    
    public Excluir(){}
    
    ConectarDB conectar = new ConectarDB();
    Consultar consultar = new Consultar();
    VerificarDependentes verificar = new VerificarDependentes();
    
    //Método para buscar a pessoa que vai ser excluida e exibir informações
    
    public void verificarExclusao(FramePessoas frame){
        
        if(!ValidarCodigo.validarCodigo(frame.getCampoConsultaExclusao().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 6 digitos numéricos");
            LimparTela.LimparTela(frame.getFrameExcluir());
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
            try{
                if(consultar.consultar(codigo).equals("")){
                    JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                    LimparTela.LimparTela(frame.getFrameExcluir());
                }
                else{
                    frame.getTextoExclusao().setText(consultar.consultar(codigo));
                    frame.getFrameExclusao().setVisible(true);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Método para realizar a exclusão
    public void excluir(FramePessoas frame) throws SQLException{
        
        long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
        try{
            if(verificar.verificarDependentes(codigo) != 0){
                JOptionPane.showMessageDialog(null, "RESPONSÁVEL NÃO PODE SER EXCLUIDO!");
            }
            else{
                String sql = "UPDATE usuario SET situacao = 0 WHERE codigo = "+codigo;
                int opcao;
                opcao = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR?", "ALERTA!", JOptionPane.YES_NO_OPTION);

                if(opcao == JOptionPane.YES_OPTION){
                    try{
                        PreparedStatement stmt = conectar.conectar().prepareStatement(sql);
                        stmt.execute();
                        JOptionPane.showMessageDialog(null, "PESSOA EXCLUIDA COM SUCESSO");
                        frame.getFrameExclusao().dispose();
                        LimparTela.LimparTela(frame.getFrameExcluir());
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
