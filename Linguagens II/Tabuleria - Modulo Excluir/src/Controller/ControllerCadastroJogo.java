package Controller;

import Model.Conexao;
import Model.Jogo;
import Model.ModelCadastroJogo;
import Util.Util;
import View.ViewPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 * Classe do controller de busca e exclusão da base de dados
 * @author Cássio Gamarra
 */
public class ControllerCadastroJogo {
    public ControllerCadastroJogo(){}
    
    ModelCadastroJogo cadastro = new ModelCadastroJogo();
    Conexao conexao = Conexao.getInstance();
    Util util = new Util();
    
    public void consulta(ViewPrincipal view){ 
        if(conexao.getStatus()){
            ResultSet consulta = cadastro.consulta();
        
            DefaultTableModel tabelaJogos = (DefaultTableModel) view.getTabelaJogos().getModel();
            DefaultTableModel tabelaJogosExcluidos = (DefaultTableModel) view.getTabelaJogosExcluidos().getModel();

            String descricao, classificacao, valorAluguel, statusAmigavel;
            int id, status;

            try {
                while(consulta.next()){
                    id = consulta.getInt("ID");
                    descricao = consulta.getString("DESCRICAO");
                    classificacao = consulta.getString("CLASSIFICACAO");
                    valorAluguel = "R$"+ String.valueOf(consulta.getFloat("VALOR_ALUGUEL"));
                    status = consulta.getInt("STATUS");
                    if(status == 0){
                        statusAmigavel = "INATIVO";
                        Object[] linha = {id, descricao, classificacao, valorAluguel, statusAmigavel};
                        tabelaJogosExcluidos.addRow(linha);
                    }
                    else{
                        statusAmigavel = "ATIVO";
                        Object[] linha = {id, descricao, classificacao, valorAluguel, statusAmigavel};
                        tabelaJogos.addRow(linha);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCadastroJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void excluir(ViewPrincipal view){
        Jogo jogo = new Jogo();
        
        int i = view.getTabelaJogos().getSelectedRow();
        
        jogo.setId(Integer.parseInt(view.getTabelaJogos().getValueAt(i, 0).toString()));
        jogo.setDescricao(view.getTabelaJogos().getValueAt(i, 1).toString());
        
        int opcao = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR O JOGO: "+jogo.getDescricao());
        if(opcao == 0){
            if(cadastro.excluir(jogo)){
                JOptionPane.showMessageDialog(null, "O JOGO "+jogo.getDescricao()+" FOI EXCLUIDO COM SUCESSO");
                util.cleanJTable(view.getTabelaJogos());
                util.cleanJTable(view.getTabelaJogosExcluidos());
                consulta(view);
            }
            else{
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR!");
            }
                 
        }
        else if(opcao == 1){
            JOptionPane.showMessageDialog(null, "SEM ALTERAÇÕES!");
        }
        else{
            return;
        }
    }
    
    public void restaurar(ViewPrincipal view){
        Jogo jogo = new Jogo();
        
        int i = view.getTabelaJogosExcluidos().getSelectedRow();
        
        jogo.setId(Integer.parseInt(view.getTabelaJogosExcluidos().getValueAt(i, 0).toString()));
        jogo.setDescricao(view.getTabelaJogosExcluidos().getValueAt(i, 1).toString());
        
        int opcao = JOptionPane.showConfirmDialog(null, "DESEJA RESTAURAR O JOGO: "+jogo.getDescricao());
        if(opcao == 0){
            if(cadastro.restaurar(jogo)){
                JOptionPane.showMessageDialog(null, "O JOGO "+jogo.getDescricao()+" FOI RESTAURADO COM SUCESSO");
                util.cleanJTable(view.getTabelaJogos());
                util.cleanJTable(view.getTabelaJogosExcluidos());
                consulta(view);
            }
            else{
                JOptionPane.showMessageDialog(null, "ERRO AO RESTAURAR!");
            }
                 
        }
        else if(opcao == 1){
            JOptionPane.showMessageDialog(null, "SEM ALTERAÇÕES!");
        }
        else{
            return;
        }
    }
}
