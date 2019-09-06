/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.table.DefaultTableModel;
import model.ModelConfig;
import view.ViewAdm;

/**
 *
 * @author cassio
 */
public class ControllerConfig {
    public ControllerConfig(){}
    
    public void salvarVagas(int vagas){
        ModelConfig config = new ModelConfig();
        config.setVagas(vagas);
    }
    
    public void gerarVagas(){
        ModelConfig config = new ModelConfig();
        int vagas = config.getVagas();
        
        ViewAdm view = new ViewAdm();
        view.getTabelaVagas();
        
        DefaultTableModel model = (DefaultTableModel) view.getTabelaVagas().getModel();
        
        int linhas, colunas, i;
        
        
        view.getTabelaVagas().setVisible(true);
        view.getViewEntrada().setLocationRelativeTo(null);
        view.getViewEntrada().setVisible(true);
    }
}
