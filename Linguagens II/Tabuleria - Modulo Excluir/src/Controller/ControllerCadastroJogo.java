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
    
    //Excluir um jogo
    public void excluir(ViewPrincipal view){
        Jogo jogo = new Jogo();
        
        int i = view.getTabelaJogos().getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum jogo selecionado!");
            return;
        }
        
        jogo.setId(Integer.parseInt(view.getTabelaJogos().getValueAt(i, 0).toString()));
        jogo.setDescricao(view.getTabelaJogos().getValueAt(i, 1).toString());
               
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o jogo:\n\n"+jogo.getDescricao().toUpperCase(), "EXCLUIR", JOptionPane.YES_NO_OPTION);

        if(opcao == 0){
            if(cadastro.excluir(jogo)){
                JOptionPane.showMessageDialog(null, "O jogo\n\n"+jogo.getDescricao().toUpperCase()+"\n\nfoi excluido com sucesso!");
                util.cleanJTable(view.getTabelaJogos());
                util.cleanJTable(view.getTabelaJogosExcluidos());
                consulta(view);
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            }
                 
        }
        else if(opcao == 1){
            JOptionPane.showMessageDialog(null, "Sem alterações!");
        }
        else{
            return;
        }
    }
    
    //Restaurar um jogo
    public void restaurar(ViewPrincipal view){
        Jogo jogo = new Jogo();
        
        int i = view.getTabelaJogosExcluidos().getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Nenhum jogo selecionado!");
            return;
        }
        
        jogo.setId(Integer.parseInt(view.getTabelaJogosExcluidos().getValueAt(i, 0).toString()));
        jogo.setDescricao(view.getTabelaJogosExcluidos().getValueAt(i, 1).toString());
        
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja restaurar o jogo:\n\n"+jogo.getDescricao().toUpperCase(), "RESTAURAR", JOptionPane.YES_NO_OPTION);
        if(opcao == 0){
            if(cadastro.restaurar(jogo)){
                JOptionPane.showMessageDialog(null, "O jogo\n\n"+jogo.getDescricao().toUpperCase()+"\n\nfoi restaurado com sucesso!");
                util.cleanJTable(view.getTabelaJogos());
                util.cleanJTable(view.getTabelaJogosExcluidos());
                consulta(view);
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro ao restaurar!");
            }    
        }
        else if(opcao == 1){
            JOptionPane.showMessageDialog(null, "Sem alterações!");
        }
        else{
            return;
        }
    }
}
