package controller;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Garagem;
import model.ModelConfig;
import static model.ModelConfig.*;
import view.ViewSistema;

/**
 *  Controller para recuperar as configurações do sistema
 * @author cassio
 */
public class ControllerConfig {
    public ControllerConfig(){}
    
    //Solicitar ao model as vagas preenchidas
    public void buscarVagas(ViewSistema view){
        ModelConfig config = new ModelConfig();
        config.buscarVagas();
        int posicao;
        for(int i = 0; i < VAGA.size(); i++){
            posicao = VAGA.get(i)+1;
            view.getTabelaVagas().setValueAt("VAGA "+posicao+" OCUPADA", VAGA.get(i), 0);
            view.getTabelaVagas().setValueAt(PLACA.get(i), VAGA.get(i), 1);
            view.getTabelaVagas().setValueAt(TIPO.get(i), VAGA.get(i), 2);
        }
    }
    
    //Solicitar ao model as configurações do sistema
    public void buscarConfig(ViewSistema view){
        ModelConfig config = new ModelConfig();
        String configuracao = config.buscarConfig();
        
        String[] vet = configuracao.split("-");
        
        String nomeGaragem = vet[0];
        int numVagas = Integer.parseInt(vet[1]);
        
        view.getLabelNomeGaragem().setText(nomeGaragem);
        view.getTabelaVagas();
        view.getFieldNomeGaragem().setText(nomeGaragem);
        view.getFieldQtdVagas().setText(String.valueOf(numVagas));
        DefaultTableModel model = (DefaultTableModel) view.getTabelaVagas().getModel();
        
        for(int i = 0; i < numVagas; i++){
            Object[] linha = {"VAGA "+(i+1)+"   |   LIVRE"};
            model.addRow(linha);
        }
    }
    
    //Solicitar ao model para configurar o nome e quantidade de vagas
    public void configurarGaragem(String nome, int vagas){
        Garagem garagem = new Garagem();
        garagem.setNome(nome);
        garagem.setVagas(vagas);
        
        ModelConfig config = new ModelConfig();
        if(config.inserirConfiguracao(garagem.getNome(), garagem.getVagas())){
            JOptionPane.showMessageDialog(null,"Por favor, reinicie o sistema para aplicar as alterações");
            
        }
        else{
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL SALVAR!");
        }
    }
}
