/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Garagem;
import model.ModelConfig;
import view.ViewAdm;

/**
 *
 * @author cassio
 */
public class ControllerConfig {
    public ControllerConfig(){}
    
    public void buscarConfig(ViewAdm view){
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
        Object[] linha = {"VAGA LIVRE"};
        for(int i = 0; i < numVagas; i++){
            model.addRow(linha);
        }
        System.out.println(nomeGaragem);
        System.out.println(numVagas);
    }
    
    //Configurar o nome e quantidade de vagas
    public void configurarGaragem(String nome, int vagas){
        Garagem garagem = new Garagem();
        garagem.setNome(nome);
        garagem.setVagas(vagas);
        
        ModelConfig config = new ModelConfig();
        if(config.inserirConfiguracao(garagem.getNome(), garagem.getVagas())){
            JOptionPane.showMessageDialog(null, "SUCESSO!");
        }
        else{
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL SALVAR!");
        }
    }
    
    public static void gerarVagas(int vagas){
        ViewAdm view = new ViewAdm();
        view.getTabelaVagas();
        
        DefaultTableModel model = (DefaultTableModel) view.getTabelaVagas().getModel();
        Object[] linha = {"VAGA LIVRE"};
        for(int i = 0; i < vagas; i++){
            model.addRow(linha);
        }
    }
}
